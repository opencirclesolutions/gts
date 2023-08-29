package com.ocs.gts.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.ocs.dynamo.domain.model.PagingMode;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.ocs.dynamo.domain.AbstractEntity;
import com.ocs.dynamo.domain.model.AttributeSelectMode;
import com.ocs.dynamo.domain.model.BooleanType;
import com.ocs.dynamo.domain.model.CascadeMode;
import com.ocs.dynamo.domain.model.VisibilityType;
import com.ocs.dynamo.domain.model.annotation.*;
import com.ocs.dynamo.functional.domain.Country;
import com.ocs.gts.domain.type.Reputation;

import lombok.Getter;
import lombok.Setter;

/**
 * A criminal organization operating in Javapolis
 *
 * @author bas.rutten
 */
@Entity
@Table(name = "organization")
@Model(displayProperty = "name")
//@AttributeGroup(messageKey = "organization.first", attributeNames = { "name", "address", "headQuarters", "countryOfOrigin" })
//@AttributeGroup(messageKey = "organization.second", attributeNames = { "reputation" })
@AttributeOrder(attributeNames = { "name", "headQuarters", "address", "countryOfOrigin", "reputation" })
@Getter
@Setter
public class Organization extends AbstractEntity<Integer> {

    private static final long serialVersionUID = -3436199710873943375L;

    @Id
    @SequenceGenerator(name = "organization_id_gen", sequenceName = "organization_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_id_gen")
    private Integer id;

    @NotNull
    @Size(max = 255)
    @Attribute(searchable = SearchMode.ALWAYS, searchPrefixOnly = BooleanType.FALSE, searchSelectMode = AttributeSelectMode.TOKEN)
    private String name;

    @NotNull
    @Size(max = 255)
    @Attribute(searchable = SearchMode.ALWAYS, displayName = "Headquarters", groupTogetherWith = "address")
    private String headQuarters;

    @NotNull
    @Size(max = 255)
    @Attribute(searchable = SearchMode.NONE)
    private String address;

    @NotNull
    @JoinColumn(name = "country_of_origin")
    @ManyToOne(fetch = FetchType.LAZY)
    @Attribute(visibleInGrid = VisibilityType.SHOW, searchable = SearchMode.ALWAYS, multipleSearch = true, selectMode = AttributeSelectMode.LOOKUP, complexEditable = true,  
    quickAddAllowed = true, /*cascade = @Cascade(cascadeTo = "members", filterPath = "countryOfOrigin",mode = CascadeMode.SEARCH),*/ replacementSortPath = "countryOfOrigin.name")
    private Country countryOfOrigin;

    @NotNull
    @Column(name = "member_count")
    @Attribute(searchable = SearchMode.NONE)
    private Integer memberCount;

    @Column(name = "government_sponsored")
    @Attribute(searchable = SearchMode.NONE)
    private Boolean governmentSponsored = Boolean.FALSE;

    @Column(name = "yearly_mortality_rate")
    @Attribute(searchable = SearchMode.NONE, defaultValue = "100.00")
    private BigDecimal yearlyMortalityRate;

    @Enumerated(EnumType.STRING)
    @Attribute(searchable = SearchMode.NONE)
    private Reputation reputation;

    @Attribute(quickAddAllowed = true, complexEditable = true, searchable = SearchMode.ALWAYS, searchSelectMode = AttributeSelectMode.TOKEN)
    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    private Set<Person> members = new HashSet<>();

    @JoinColumn(name = "main_activity")
    @ManyToOne(fetch = FetchType.LAZY)
    @Attribute(quickAddAllowed = true, complexEditable = true, searchable = SearchMode.NONE, visibleInGrid = VisibilityType.SHOW, multipleSearch = true, selectMode = AttributeSelectMode.COMBO, 
    replacementSortPath = "mainActivity.name", pagingMode = PagingMode.PAGED)
    private MainActivity mainActivity;

    @Attribute(url = true)
    private String url;

    public void addMember(Person person) {
        this.members.add(person);
        person.setOrganization(this);
    }

    public void removeMember(Person person) {
        this.members.remove(person);
        person.setOrganization(null);
    }
}

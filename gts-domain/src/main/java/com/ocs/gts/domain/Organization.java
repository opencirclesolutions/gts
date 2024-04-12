package com.ocs.gts.domain;

import com.ocs.dynamo.domain.AbstractEntity;
import com.ocs.dynamo.domain.model.AttributeSelectMode;
import com.ocs.dynamo.domain.model.PagingMode;
import com.ocs.dynamo.domain.model.VisibilityType;
import com.ocs.dynamo.domain.model.annotation.Attribute;
import com.ocs.dynamo.domain.model.annotation.AttributeGroup;
import com.ocs.dynamo.domain.model.annotation.Model;
import com.ocs.dynamo.domain.model.annotation.SearchMode;
import com.ocs.dynamo.functional.domain.Country;
import com.ocs.gts.domain.type.Reputation;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A criminal organization operating in Javapolis
 *
 * @author bas.rutten
 */
@Entity
@Table(name = "organization")
@Model(displayProperty = "name", autofillInstructions = "Derive country from address, Translate member count to a number")
@Getter
@Setter
//@AttributeGroup(messageKey = "organization.first", attributeNames = { "name", "address", "headQuarters", "countryOfOrigin" })
//@AttributeGroup(messageKey = "organization.second", attributeNames = { "reputation" })
public class Organization extends AbstractEntity<Integer> {

    private static final long serialVersionUID = -3436199710873943375L;

    @Id
    @SequenceGenerator(name = "organization_id_gen", sequenceName = "organization_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_id_gen")
    private Integer id;

    @NotNull
    @Size(max = 255)
    @Attribute(searchable = SearchMode.ALWAYS)
    private String name;

    @NotNull
    @Size(max = 255)
    @Attribute(autoFillInstructions = "Look for a building")
    private String headQuarters;

    @NotNull
    @Size(max = 255)
    private String address;

    @Email
    @Attribute(autoFillInstructions = "Convert to a valid email address")
    private String email;

    @NotNull
    @JoinColumn(name = "country_of_origin")
    @ManyToOne(fetch = FetchType.LAZY)
    @Attribute(searchable = SearchMode.ALWAYS, multipleSearch = true,
            complexEditable = true, autoFillInstructions = "Look for a country, translate to English",
            selectMode = AttributeSelectMode.LOOKUP,
            pagingMode = PagingMode.PAGED)
    private Country countryOfOrigin;

    @NotNull
    @Column(name = "member_count")
    @Attribute(searchable = SearchMode.ALWAYS, searchForExactValue = true)
    private Integer memberCount;

    @Column(name = "government_sponsored")
    private Boolean governmentSponsored = Boolean.FALSE;

    @Column(name = "yearly_mortality_rate")
    @Attribute(percentage = true, autoFillInstructions = "round to two decimals, use comma as separator",
            searchable = SearchMode.ALWAYS)
    private BigDecimal yearlyMortalityRate;

    @Enumerated(EnumType.STRING)
    @Attribute(autoFillInstructions = "Format as snake case")
    private Reputation reputation;

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
    private Set<Person> members = new HashSet<>();

    @JoinColumn(name = "main_activity")
    @ManyToOne(fetch = FetchType.LAZY)
    private MainActivity mainActivity;

    @ManyToMany(fetch = FetchType.LAZY)
    @Attribute(complexEditable = true, visibleInGrid = VisibilityType.HIDE,
            searchable = SearchMode.ALWAYS, selectMode = AttributeSelectMode.TOKEN,
            autoFillInstructions = "Separate using commas")
    @JoinTable(name = "organization_neighbourhood", joinColumns = @JoinColumn(name = "organization_id"),
            inverseJoinColumns = @JoinColumn(name = "neighbourhood_id"))
    private Set<Neighbourhood> neighbourhoods = new HashSet<>();

    private LocalDate founded;

    public void addMember(Person person) {
        this.members.add(person);
        person.setOrganization(this);
    }

    public void removeMember(Person person) {
        this.members.remove(person);
        person.setOrganization(null);
    }
}

package com.ocs.gts.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ocs.dynamo.domain.AbstractEntity;
import com.ocs.dynamo.domain.model.AttributeSelectMode;
import com.ocs.dynamo.domain.model.AttributeTextFieldMode;
import com.ocs.dynamo.domain.model.VisibilityType;
import com.ocs.dynamo.domain.model.annotation.Attribute;
import com.ocs.dynamo.domain.model.annotation.AttributeOrder;
import com.ocs.dynamo.domain.model.annotation.Model;
import com.ocs.dynamo.functional.domain.Country;
import com.ocs.gts.domain.type.Reputation;

/**
 * A criminal organization operating in Javapolis
 * 
 * @author bas.rutten
 *
 */
@Entity
@Table(name = "organization")
@Model(displayProperty = "name")
@AttributeOrder(attributeNames = { "name", "headQuarters", "address", "countryOfOrigin", "reputation" })
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
    @Attribute(searchable = true, searchCaseSensitive = false, searchPrefixOnly = true, multipleSearch = true, searchSelectMode = AttributeSelectMode.TOKEN)
    private String name;

    @NotNull
    @Size(max = 255)
    @Attribute(searchable = true, displayName = "Headquarters", groupTogetherWith = "address")
    private String headQuarters;

    @NotNull
    @Size(max = 255)
    @Attribute(textFieldMode = AttributeTextFieldMode.TEXTAREA, searchable = true)
    private String address;

    @NotNull
    @JoinColumn(name = "country_of_origin")
    @ManyToOne(fetch = FetchType.LAZY)
    @Attribute(visibleInGrid = VisibilityType.SHOW, searchable = true, complexEditable = true, multipleSearch = true)
    private Country countryOfOrigin;

    @NotNull
    @Column(name = "member_count")
    @Attribute(searchable = true)
    private Integer memberCount;

    @Column(name = "government_sponsored")
    @Attribute(searchable = true)
    private Boolean governmentSponsored = Boolean.FALSE;

    @Column(name = "yearly_mortality_rate")
    @Attribute(searchable = true, defaultValue = "10", currency = true)
    private BigDecimal yearlyMortalityRate;

    @Enumerated(EnumType.STRING)
    private Reputation reputation;

    @OneToMany(mappedBy = "organization", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @Attribute(searchable = true)
    private Set<Person> members = new HashSet<>();

    @Attribute(url = true)
    private String url;

    public String getAddress() {
        return address;
    }

    public Country getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public Boolean getGovernmentSponsored() {
        return governmentSponsored;
    }

    public String getHeadQuarters() {
        return headQuarters;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public String getName() {
        return name;
    }

    public Reputation getReputation() {
        return reputation;
    }

    public BigDecimal getYearlyMortalityRate() {
        return yearlyMortalityRate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCountryOfOrigin(Country countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public void setGovernmentSponsored(Boolean governmentSponsored) {
        this.governmentSponsored = governmentSponsored;
    }

    public void setHeadQuarters(String headQuarters) {
        this.headQuarters = headQuarters;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setReputation(Reputation reputation) {
        this.reputation = reputation;
    }

    public void setYearlyMortalityRate(BigDecimal yearlyMortalityRate) {
        this.yearlyMortalityRate = yearlyMortalityRate;
    }

    public Set<Person> getMembers() {
        return members;
    }

    public void setMembers(Set<Person> members) {
        this.members = members;
    }

    public void addMember(Person person) {
        this.members.add(person);
        person.setOrganization(this);
    }

    public void removeMember(Person person) {
        this.members.remove(person);
        person.setOrganization(null);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package com.ocs.gts.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.ocs.dynamo.domain.model.BooleanType;
import com.ocs.dynamo.domain.model.annotation.SearchMode;
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
import com.ocs.dynamo.domain.model.annotation.Attribute;
import com.ocs.dynamo.domain.model.annotation.Model;
import com.ocs.dynamo.functional.domain.Country;
import com.ocs.gts.domain.type.Reputation;

import lombok.Getter;
import lombok.Setter;

/**
 * A criminal organization operating in Javapolis
 * 
 * @author bas.rutten
 *
 */
@Entity
@Table(name = "organization")
@Model(displayProperty = "name")
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
	@Attribute(searchable = SearchMode.ALWAYS, searchCaseSensitive = BooleanType.TRUE, searchPrefixOnly = BooleanType.TRUE)
	private String name;

	@NotNull
	@Size(max = 255)
	@Attribute(searchable = SearchMode.ALWAYS)
	private String headQuarters;

	@NotNull
	@Size(max = 255)
	@Attribute(searchable = SearchMode.ALWAYS)
	private String address;

	@NotNull
	@JoinColumn(name = "country_of_origin")
	@ManyToOne(fetch = FetchType.LAZY)
	private Country countryOfOrigin;

	@NotNull
	@Column(name = "member_count")
	@Attribute(searchable = SearchMode.ALWAYS)
	private Integer memberCount;

	@Column(name = "government_sponsored")
	@Attribute(searchable = SearchMode.ALWAYS)
	private Boolean governmentSponsored = Boolean.FALSE;

	@Column(name = "yearly_mortality_rate")
	@Attribute(searchable = SearchMode.ALWAYS)
	private BigDecimal yearlyMortalityRate;

	@Enumerated(EnumType.STRING)
	@Attribute(searchable = SearchMode.ALWAYS)
	private Reputation reputation;

	@Attribute(quickAddAllowed = true, complexEditable = true)
	@OneToMany(mappedBy = "organization", fetch = FetchType.LAZY)
	private Set<Person> members = new HashSet<>();

	@JoinColumn(name = "main_activity")
	@ManyToOne(fetch = FetchType.LAZY)
	private MainActivity mainActivity;

	public void addMember(Person person) {
		this.members.add(person);
		person.setOrganization(this);
	}

	public void removeMember(Person person) {
		this.members.remove(person);
		person.setOrganization(null);
	}
}

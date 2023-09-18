package com.ocs.gts.domain;

import com.ocs.dynamo.domain.AbstractEntity;
import com.ocs.dynamo.domain.model.annotation.Attribute;
import com.ocs.dynamo.domain.model.annotation.Model;
import com.ocs.dynamo.functional.domain.Country;
import com.ocs.gts.domain.type.Reputation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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
	private String name;

	@NotNull
	@Size(max = 255)
	private String headQuarters;

	@NotNull
	@Size(max = 255)
	private String address;

	@NotNull
	@JoinColumn(name = "country_of_origin")
	@ManyToOne(fetch = FetchType.LAZY)
	private Country countryOfOrigin;

	@NotNull
	@Column(name = "member_count")
	private Integer memberCount;

	@Column(name = "government_sponsored")
	private Boolean governmentSponsored = Boolean.FALSE;

	@Column(name = "yearly_mortality_rate")
	private BigDecimal yearlyMortalityRate;

	@Enumerated(EnumType.STRING)
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

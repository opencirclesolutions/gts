package com.ocs.gts.domain;

import java.time.LocalDate;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ocs.dynamo.domain.AbstractEntity;
import com.ocs.dynamo.domain.model.EditableType;
import com.ocs.dynamo.domain.model.NumberSelectMode;
import com.ocs.dynamo.domain.model.VisibilityType;
import com.ocs.dynamo.domain.model.annotation.Attribute;
import com.ocs.dynamo.domain.model.annotation.AttributeOrder;
import com.ocs.dynamo.domain.model.annotation.Model;
import com.ocs.gts.domain.type.Reputation;

@Entity
@Table(name = "person")
@Model(displayProperty = "fullName")
@AttributeOrder(attributeNames = { "firstName", "lastName", "nickName", "organization", "born", "died" })
public class Person extends AbstractEntity<Integer> {

	private static final long serialVersionUID = -3436199710873943375L;

	@Id
	@SequenceGenerator(name = "person_id_gen", sequenceName = "person_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_gen")
	private Integer id;

	@Attribute(week = true, searchable = true)
	@Column(name = "birth_week")
	private LocalDate birthWeek;

	@NotNull
	@Size(max = 255)
	@Column(name = "first_name")
	@Attribute(searchable = true)
	private String firstName;

	@NotNull
	@Size(max = 255)
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@Size(max = 255)
	@Column(name = "nickname")
	private String nickName;

	@NotNull
	@JoinColumn(name = "organization")
	@ManyToOne(fetch = FetchType.LAZY)
	@Attribute(complexEditable = true, showInTable = VisibilityType.SHOW, navigable = true)
	private Organization organization;

	@Attribute(searchable = true)
	private LocalDate born;

	private LocalDate died;

	@Attribute(searchable = true, numberSelectMode = NumberSelectMode.SLIDER)
	private Integer age;

	@Attribute(searchable = true)
	private Boolean professional;

	@Attribute(searchable = true)
	@Enumerated(EnumType.STRING)
	private Reputation reputation;

	public Integer getAge() {
		return age;
	}

	public LocalDate getBorn() {
		return born;
	}

	public LocalDate getDied() {
		return died;
	}

	public String getFirstName() {
		return firstName;
	}

	@Attribute(editable = EditableType.READ_ONLY, main = true)
	public String getFullName() {
		StringBuilder builder = new StringBuilder();
		builder.append(firstName);
		builder.append(" '" + nickName + "' ");
		builder.append(lastName);
		return builder.toString();
	}

	@Override
	public Integer getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setBorn(LocalDate born) {
		this.born = born;
	}

	public void setDied(LocalDate died) {
		this.died = died;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public LocalDate getBirthWeek() {
		return birthWeek;
	}

	public void setBirthWeek(LocalDate birthWeek) {
		this.birthWeek = birthWeek;
	}

	public Boolean getProfessional() {
		return professional;
	}

	public void setProfessional(Boolean professional) {
		this.professional = professional;
	}

	public Reputation getReputation() {
		return reputation;
	}

	public void setReputation(Reputation reputation) {
		this.reputation = reputation;
	}

}

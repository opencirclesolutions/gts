package com.ocs.gts.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;

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
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ocs.dynamo.domain.AbstractEntity;
import com.ocs.dynamo.domain.model.AttributeSelectMode;
import com.ocs.dynamo.domain.model.CheckboxMode;
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
@AttributeOrder(attributeNames = { "firstName", "lastName", "nickName", "organization", "born", "died", "someTime" })
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
	@Attribute(searchable = true, requiredForSearching = false)
	private String firstName;

	@NotNull
	@Size(max = 255)
	@Column(name = "last_name")
	@Attribute(searchable = true)
	private String lastName;

	@NotNull
	@Size(max = 255)
	@Column(name = "nickname")
	private String nickName;

	@NotNull
	@JoinColumn(name = "organization")
	@ManyToOne(fetch = FetchType.LAZY)
	@Attribute(complexEditable = true, showInTable = VisibilityType.SHOW, navigable = true, searchable = true, selectMode = AttributeSelectMode.COMBO)
	private Organization organization;

	@Attribute(searchable = true, displayFormat = "yyyy/MM/dd")
	private LocalDate born;

	private LocalDate died;

	@Column(name = "some_timestamp")
	@Attribute(searchable = true)
	private LocalDateTime someTimestamp;

	@Column(name = "some_time")
	@Attribute(searchable = true)
	private LocalTime someTime;

	@Attribute(searchable = true)
	@Column(name = "created_on")
	private ZonedDateTime createdOn;

	@Attribute(searchable = true, numberSelectMode = NumberSelectMode.SLIDER)
	private Integer age;

	@Attribute(searchable = true, checkboxMode = CheckboxMode.SWITCH)
	private Boolean professional;

	@Attribute(searchable = true)
	@Enumerated(EnumType.STRING)
	private Reputation reputation;

	@Attribute(searchable = true, complexEditable = true, quickAddPropertyName = "name", selectMode = AttributeSelectMode.LOOKUP)
	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

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

	@Attribute(editable = EditableType.READ_ONLY, main = true, visible = VisibilityType.HIDE)
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalTime getSomeTime() {
		return someTime;
	}

	public void setSomeTime(LocalTime someTime) {
		this.someTime = someTime;
	}

	public LocalDateTime getSomeTimestamp() {
		return someTimestamp;
	}

	public void setSomeTimestamp(LocalDateTime someTimestamp) {
		this.someTimestamp = someTimestamp;
	}

	public ZonedDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(ZonedDateTime createdOn) {
		this.createdOn = createdOn;
	}

	@PreUpdate
	@PrePersist
	@PostPersist
	public void preUpdate() {
		this.createdOn = ZonedDateTime.now();
	}
}

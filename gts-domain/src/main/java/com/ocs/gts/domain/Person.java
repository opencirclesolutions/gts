package com.ocs.gts.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ocs.dynamo.domain.AbstractEntity;
import com.ocs.dynamo.domain.model.EditableType;
import com.ocs.dynamo.domain.model.VisibilityType;
import com.ocs.dynamo.domain.model.annotation.Attribute;
import com.ocs.dynamo.domain.model.annotation.AttributeOrder;
import com.ocs.dynamo.domain.model.annotation.Model;

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

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@NotNull
	@Size(max = 255)
	@Column(name = "first_name")
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
	@Attribute(complexEditable = true, showInTable = VisibilityType.SHOW)
	private Organization organization;

	@Temporal(TemporalType.DATE)
	private Date born;

	@Temporal(TemporalType.DATE)
	private Date died;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Date getBorn() {
		return born;
	}

	public void setBorn(Date born) {
		this.born = born;
	}

	public Date getDied() {
		return died;
	}

	public void setDied(Date died) {
		this.died = died;
	}

	@Attribute(editable = EditableType.READ_ONLY, main = true)
	public String getFullName() {
		StringBuilder builder = new StringBuilder();
		builder.append(firstName);
		builder.append(" '" + nickName + "' ");
		builder.append(lastName);
		return builder.toString();
	}

}

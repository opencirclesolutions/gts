package com.ocs.gts.domain;

import java.time.LocalDate;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.ocs.dynamo.domain.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "person")
@Getter
@Setter
public class Person extends AbstractEntity<Integer> {

	private static final long serialVersionUID = -3436199710873943375L;

	@Id
	@SequenceGenerator(name = "person_id_gen", sequenceName = "person_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_gen")
	private Integer id;

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
	private Organization organization;

	private LocalDate born;

	private LocalDate died;

}

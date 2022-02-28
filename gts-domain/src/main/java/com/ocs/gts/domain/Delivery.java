package com.ocs.gts.domain;

import java.time.LocalDate;

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
@Table(name = "delivery")
@Getter
@Setter
public class Delivery extends AbstractEntity<Integer> {

	private static final long serialVersionUID = -3362281378174257729L;

	@Id
	@SequenceGenerator(name = "delivery_id_gen", sequenceName = "delivery_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_id_gen")
	private Integer id;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "from_person")
	private Person fromPerson;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "to_person")
	private Person toPerson;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gift")
	private Gift gift;

	@NotNull
	private LocalDate date;

	@Size(max = 255)
	private String remarks;

}

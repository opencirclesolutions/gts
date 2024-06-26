package com.ocs.gts.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import com.ocs.dynamo.domain.AbstractEntity;
import com.ocs.dynamo.domain.model.EditableType;
import com.ocs.dynamo.domain.model.VisibilityType;
import com.ocs.dynamo.domain.model.annotation.Attribute;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Entity
@Table(name = "gift_logo")
@Getter
@Setter
public class GiftLogo extends AbstractEntity<Integer> {

	private static final long serialVersionUID = -8668064619628599752L;

	@Id
	@SequenceGenerator(name = "gift_logo_id_gen", sequenceName = "gift_logo_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gift_logo_id_gen")
	private Integer id;

	@Lob
	private byte[] image;

	// hide in table to prevent fetch issues
	@Attribute(editable = EditableType.READ_ONLY, visibleInGrid = VisibilityType.HIDE)
	private String fileName;

}

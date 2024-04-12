package com.ocs.gts.domain;

import com.ocs.dynamo.domain.AbstractEntity;

import com.ocs.dynamo.domain.model.AttributeSelectMode;
import com.ocs.dynamo.domain.model.VisibilityType;
import com.ocs.dynamo.domain.model.annotation.Attribute;
import com.ocs.dynamo.domain.model.annotation.SearchMode;
import com.ocs.dynamo.functional.domain.Country;
import com.ocs.gts.domain.type.Reputation;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;

/**
 * The translation of the name of a gift
 * 
 * @author bas.rutten
 *
 */
@Entity
@Table(name = "gift_translations")
@Getter
@Setter
public class GiftTranslation extends AbstractEntity<Integer> {

	private static final long serialVersionUID = 1600667730778955026L;

	@Id
	@SequenceGenerator(name = "gift_translations_id_gen", sequenceName = "gift_translations_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gift_translations_id_gen")
	private Integer id;

	@JoinColumn(name = "gift")
	@ManyToOne(fetch = FetchType.LAZY)
	private Gift gift;

	@NotNull
	private String description;

	@NotNull
	private String language;

//	@Enumerated(EnumType.STRING)
//	@Attribute(autoFillInstructions = "Format as snake case")
//	private Reputation reputation;

	@JoinColumn(name = "country")
	@ManyToOne(fetch = FetchType.LAZY)
	@Attribute(complexEditable = true, autoFillInstructions = "Look for a country, translate to English" ,
		visibleInGrid = VisibilityType.SHOW)
	private Country country;

	@Override
	public int hashCode() {
		return super.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}

		// if either of the objects does not have an ID, then they are
		// in memory only and are never considered equal
		GiftTranslation other = (GiftTranslation) obj;
		if (this.id == null || other.id == null) {
			return false;
		}
		return this.id.equals(other.id);
	}
}

package com.ocs.gts.domain;

import com.ocs.dynamo.domain.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
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

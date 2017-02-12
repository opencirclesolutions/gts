package com.ocs.gts.domain;

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

import com.ocs.dynamo.domain.AbstractEntity;

/**
 * The translation of the name of a gift
 * 
 * @author bas.rutten
 *
 */
@Entity
@Table(name = "gift_translations")
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
	public Integer getId() {
		return this.id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

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

package com.ocs.gts.domain;

import java.util.HashSet;
import java.util.Set;

import com.ocs.dynamo.domain.model.FetchJoin;
import com.ocs.dynamo.domain.model.FetchJoins;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import com.ocs.dynamo.domain.AbstractEntity;
import com.ocs.dynamo.domain.model.annotation.Attribute;
import com.ocs.dynamo.domain.model.annotation.AttributeOrder;

import lombok.Getter;
import lombok.Setter;

/**
 * An expensive gift
 * 
 * @author bas.rutten
 *
 */
@Entity
@Table(name = "gift")
@AttributeOrder(attributeNames = { "name", "description" })
@Getter
@Setter
@FetchJoins(joins = @FetchJoin(attribute = "translations"))
public class Gift extends AbstractEntity<Integer> {

	private static final long serialVersionUID = -3436199710873943375L;

	@Id
	@SequenceGenerator(name = "gift_id_gen", sequenceName = "gift_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gift_id_gen")
	private Integer id;

	@Attribute(embedded = true)
	@JoinColumn(name = "logo")
	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	private GiftLogo logo = new GiftLogo();

	@NotNull
	@Size(max = 255)
	@Attribute(main = true)
	private String name;

	@NotNull
	@Size(max = 255)
	private String description;

	@Valid
	@OneToMany(mappedBy = "gift", fetch = FetchType.LAZY, cascade = { CascadeType.MERGE,
			CascadeType.PERSIST }, orphanRemoval = true)
	private Set<GiftTranslation> translations = new HashSet<>();

	public void addTranslation(GiftTranslation translation) {
		this.translations.add(translation);
		translation.setGift(this);
	}

	public GiftLogo getLogo() {
		if (logo == null) {
			logo = new GiftLogo();
		}
		return logo;
	}

	public void removeTranslation(GiftTranslation translation) {
		this.translations.remove(translation);
		translation.setGift(null);
	}

}

package com.ocs.gts.domain;

import com.ocs.dynamo.domain.AbstractEntity;
import com.ocs.dynamo.domain.model.annotation.Attribute;
import com.ocs.dynamo.domain.model.annotation.AttributeOrder;
import com.ocs.dynamo.domain.model.annotation.Model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * An expensive gift
 *
 * @author bas.rutten
 */
@Entity
@Table(name = "gift")
@Model(displayProperty = "name")
@AttributeOrder(attributeNames = {"name", "description"})
@Getter
@Setter
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
    @OneToMany(mappedBy = "gift", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE,
            CascadeType.PERSIST}, orphanRemoval = true)
    @Attribute(complexEditable = true)
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

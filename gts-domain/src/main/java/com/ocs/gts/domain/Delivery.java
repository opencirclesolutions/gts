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
import com.ocs.dynamo.domain.model.AttributeSelectMode;
import com.ocs.dynamo.domain.model.VisibilityType;
import com.ocs.dynamo.domain.model.annotation.Attribute;
import com.ocs.dynamo.domain.model.annotation.AttributeOrder;
import com.ocs.dynamo.domain.model.annotation.Model;

@Entity
@Table(name = "delivery")
@AttributeOrder(attributeNames = { "date", "fromPerson", "toPerson", "gift" })
@Model(displayProperty = "gift", displayNamePlural = "Deliveries")
public class Delivery extends AbstractEntity<Integer> {

    private static final long serialVersionUID = -3362281378174257729L;

    @Id
    @SequenceGenerator(name = "delivery_id_gen", sequenceName = "delivery_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_id_gen")
    private Integer id;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_person")
    @Attribute(complexEditable = true, visibleInGrid = VisibilityType.SHOW, replacementSortPath = "fromPerson.nickName", gridSelectMode = AttributeSelectMode.LOOKUP)
    private Person fromPerson;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_person")
    @Attribute(complexEditable = true, visibleInGrid = VisibilityType.SHOW, replacementSortPath = "toPerson.nickName")
    private Person toPerson;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @Attribute(complexEditable = true, visibleInGrid = VisibilityType.SHOW, replacementSortPath = "gift.name")
    @JoinColumn(name = "gift")
    private Gift gift;

    @NotNull
    private LocalDate date;

    @Size(max = 255)
    private String remarks;

    public Person getFromPerson() {
        return fromPerson;
    }

    public void setFromPerson(Person fromPerson) {
        this.fromPerson = fromPerson;
    }

    public Person getToPerson() {
        return toPerson;
    }

    public void setToPerson(Person toPerson) {
        this.toPerson = toPerson;
    }

    public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}

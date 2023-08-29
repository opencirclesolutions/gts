package com.ocs.gts.domain;

import com.ocs.dynamo.domain.AbstractEntity;
import com.ocs.dynamo.domain.model.PagingMode;
import com.ocs.dynamo.domain.model.VisibilityType;
import com.ocs.dynamo.domain.model.annotation.Attribute;
import com.ocs.dynamo.domain.model.annotation.AttributeOrder;
import com.ocs.dynamo.domain.model.annotation.Model;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "delivery")
@Model(displayProperty = "gift.name")
@AttributeOrder(attributeNames = {"date", "fromPerson", "toPerson", "gift", "remarks"})
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
    @Attribute(visibleInGrid = VisibilityType.SHOW, complexEditable = true, pagingMode = PagingMode.NON_PAGED, 
    replacementSortPath = "fromPerson.firstName")
    private Person fromPerson;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_person")
    @Attribute(visibleInGrid = VisibilityType.SHOW, complexEditable = true)
    private Person toPerson;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gift")
    @Attribute(visibleInGrid = VisibilityType.SHOW, complexEditable = true)
    private Gift gift;

    @NotNull
    @Attribute(visibleInGrid = VisibilityType.SHOW, complexEditable = true)
    private LocalDate date;

    @Size(max = 255)
    private String remarks;

}

package com.ocs.gts.domain;

import java.time.LocalDate;

import com.ocs.dynamo.domain.model.FetchJoin;
import com.ocs.dynamo.domain.model.FetchJoins;
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
import jakarta.validation.constraints.Size;

import com.ocs.dynamo.domain.AbstractEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "delivery")
@Getter
@Setter
@FetchJoins(joins = {@FetchJoin(attribute = "fromPerson"),
        @FetchJoin(attribute = "toPerson"), @FetchJoin(attribute = "gift")})
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

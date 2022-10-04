package com.ocs.gts.domain;

import com.ocs.dynamo.domain.AbstractEntity;
import com.ocs.dynamo.domain.model.VisibilityType;
import com.ocs.dynamo.domain.model.annotation.Attribute;
import com.ocs.dynamo.domain.model.annotation.AttributeOrder;
import com.ocs.dynamo.domain.model.annotation.Model;
import com.ocs.dynamo.domain.model.annotation.SearchMode;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
@Model(displayProperty = "firstName")
@AttributeOrder(attributeNames = {"firstName", "lastName", "nickName", "born", "died"})
@Getter
@Setter
public class Person extends AbstractEntity<Integer> {

    private static final long serialVersionUID = -3436199710873943375L;

    @Id
    @SequenceGenerator(name = "person_id_gen", sequenceName = "person_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_gen")
    private Integer id;

    @NotNull
    @Size(max = 255)
    @Column(name = "first_name")
    @Attribute(searchable = SearchMode.ALWAYS)
    private String firstName;

    @NotNull
    @Size(max = 255)
    @Column(name = "last_name")
    @Attribute(searchable = SearchMode.ALWAYS)
    private String lastName;

    @NotNull
    @Size(max = 255)
    @Column(name = "nickname")
    @Attribute(displayName = "Nickname")
    private String nickName;

    @NotNull
    @JoinColumn(name = "organization")
    @ManyToOne(fetch = FetchType.LAZY)
    @Attribute(visibleInGrid = VisibilityType.SHOW, navigable = true)
    private Organization organization;

    @ElementCollection
    @CollectionTable(name = "person_lucky_numbers")
    @Column(name = "lucky_number")
    @Attribute(complexEditable = true, minValue = 0, maxValue = 100)
    private Set<Integer> luckyNumbers = new HashSet<>();

    private LocalDate born;

    private LocalDate died;

}

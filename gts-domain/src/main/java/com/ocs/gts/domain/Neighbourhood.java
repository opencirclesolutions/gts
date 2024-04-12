package com.ocs.gts.domain;

import com.ocs.dynamo.domain.AbstractEntity;
import com.ocs.dynamo.domain.model.VisibilityType;
import com.ocs.dynamo.domain.model.annotation.Attribute;
import com.ocs.dynamo.domain.model.annotation.Model;
import com.ocs.dynamo.domain.model.annotation.SearchMode;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "neighbourhood")
@Model(displayProperty = "name")
@Getter
@Setter
public class Neighbourhood extends AbstractEntity<Integer> {

    @Id
    @SequenceGenerator(name = "neighbourhood_id_gen", sequenceName = "neighbourhood_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "neighbourhood_id_gen")
    @Attribute(visible = VisibilityType.SHOW, visibleInGrid = VisibilityType.SHOW)
    private Integer id;

    @NotNull
    @Size(max = 255)
    @Attribute(searchable = SearchMode.ALWAYS)
    private String name;
}

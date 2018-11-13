package com.ocs.gts.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ocs.dynamo.domain.model.annotation.Model;
import com.ocs.dynamo.functional.domain.Domain;

@Entity
@DiscriminatorValue(value = "TRAIT")
@Model(displayProperty = "name")
public class Trait extends Domain {

	private static final long serialVersionUID = -8083537601214672281L;

}

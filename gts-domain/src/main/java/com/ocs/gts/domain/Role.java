package com.ocs.gts.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.ocs.dynamo.functional.domain.Domain;

@Entity
@DiscriminatorValue(value = "ROLE")
public class Role extends Domain {

	private static final long serialVersionUID = -8083537601214672281L;

}

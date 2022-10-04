package com.ocs.gts.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import com.ocs.dynamo.domain.model.annotation.Model;
import com.ocs.dynamo.functional.domain.Domain;

@Entity
@DiscriminatorValue("MAIN_ACTIVITY")
@Model(displayProperty = "name", displayNamePlural = "Main Activities")
public class MainActivity extends Domain {

    private static final long serialVersionUID = 7370000766848596526L;

}

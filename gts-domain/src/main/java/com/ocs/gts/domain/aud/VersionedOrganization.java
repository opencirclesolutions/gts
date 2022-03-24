package com.ocs.gts.domain.aud;

import com.ocs.dynamo.domain.model.VisibilityType;
import com.ocs.dynamo.domain.model.annotation.Attribute;
import com.ocs.dynamo.domain.model.annotation.AttributeGroup;
import com.ocs.dynamo.domain.model.annotation.GridAttributeOrder;
import com.ocs.dynamo.domain.model.annotation.Model;
import com.ocs.dynamo.envers.domain.RevisionType;
import com.ocs.dynamo.envers.domain.VersionedEntity;
import com.ocs.gts.domain.Organization;


@GridAttributeOrder(attributeNames = { "entity.id", "revision", "revisionTimeStamp" })
@AttributeGroup(messageKey = "organization.group1", attributeNames = { "entity.name", "entity.headQuarters",
		"entity.address" })
@Model(displayName = "Organization revision", displayNamePlural = "Organization revisions", displayProperty = "entity.name")
public class VersionedOrganization extends VersionedEntity<Integer, Organization> {

	private static final long serialVersionUID = 4271855110308393329L;

	public VersionedOrganization(Organization entity, int revision) {
		super(entity, revision);
	}

	@Attribute(embedded = true)
	public Organization getEntity() {
		return super.getEntity();
	}

	@Attribute(visible = VisibilityType.HIDE)
	public String getDescription() {
		return RevisionType.DEL.equals(getRevisionType()) ? "Deleted" : getEntity().getName();
	}

}

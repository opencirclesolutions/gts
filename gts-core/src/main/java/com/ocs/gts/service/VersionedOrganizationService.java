package com.ocs.gts.service;

import com.ocs.dynamo.envers.domain.RevisionKey;
import com.ocs.dynamo.service.BaseService;
import com.ocs.gts.domain.aud.VersionedOrganization;

public interface VersionedOrganizationService extends BaseService<RevisionKey<Integer>, VersionedOrganization> {

}

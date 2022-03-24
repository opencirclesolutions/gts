package com.ocs.gts.domain.dao.aud.impl;

import org.springframework.stereotype.Repository;

import com.ocs.dynamo.envers.dao.impl.VersionedEntityDaoImpl;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.aud.VersionedOrganization;
import com.ocs.gts.domain.dao.aud.VersionedOrganizationDao;

@Repository
public class VersionedOrganizationDaoImpl extends VersionedEntityDaoImpl<Integer, Organization, VersionedOrganization>
		implements VersionedOrganizationDao {

	@Override
	public Class<VersionedOrganization> getEntityClass() {
		return VersionedOrganization.class;
	}

	@Override
	protected VersionedOrganization createVersionedEntity(Organization t, int revision) {
		return new VersionedOrganization(t, revision);
	}

	@Override
	public Class<Organization> getBaseEntityClass() {
		return Organization.class;
	}

	@Override
	protected void doMap(VersionedOrganization u) {
		super.doMap(u);
		if (u.getEntity().getCountryOfOrigin() != null) {
			u.getEntity().getCountryOfOrigin().getName();
		}
		if (u.getEntity().getMembers() != null) {
			u.getEntity().getMembers().forEach(c -> c.getFirstName());
		}
		if (u.getEntity().getMainActivity() != null) {
			u.getEntity().getMainActivity().getName();
		}
	}
}

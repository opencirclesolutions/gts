package com.ocs.gts.domain.dao.impl;

import org.springframework.stereotype.Repository;

import com.ocs.dynamo.dao.impl.BaseDaoImpl;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.QOrganization;
import com.ocs.gts.domain.dao.OrganizationDao;
import com.querydsl.core.types.dsl.EntityPathBase;

@Repository("organizationDao")
public class OrganizationDaoImpl extends BaseDaoImpl<Integer, Organization> implements OrganizationDao {

	private QOrganization qOrganization = QOrganization.organization;

	@Override
	public Class<Organization> getEntityClass() {
		return Organization.class;
	}

	@Override
	protected EntityPathBase<Organization> getDslRoot() {
		return qOrganization;
	}

}

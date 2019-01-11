package com.ocs.gts.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.dynamo.dao.BaseDao;
import com.ocs.dynamo.service.impl.BaseServiceImpl;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.dao.OrganizationDao;
import com.ocs.gts.service.OrganizationService;

@Service("organizationService")
public class OrganizationServiceImpl extends BaseServiceImpl<Integer, Organization> implements OrganizationService {

	@Inject
	private OrganizationDao dao;

	@Override
	protected BaseDao<Integer, Organization> getDao() {
		return dao;
	}

	@Transactional
	@Override
	public Organization save(Organization t) {
		return super.save(t);
	}
}

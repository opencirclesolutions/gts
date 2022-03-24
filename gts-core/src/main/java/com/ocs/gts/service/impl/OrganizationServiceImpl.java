package com.ocs.gts.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.dynamo.dao.BaseDao;
import com.ocs.dynamo.dao.FetchJoinInformation;
import com.ocs.dynamo.dao.SortOrders;
import com.ocs.dynamo.filter.Filter;
import com.ocs.dynamo.service.impl.BaseServiceImpl;
import com.ocs.gts.domain.Organization;
import com.ocs.gts.domain.dao.OrganizationDao;
import com.ocs.gts.service.OrganizationService;

@Service("organizationService")
//@javax.transaction.Transactional
@Transactional
public class OrganizationServiceImpl extends BaseServiceImpl<Integer, Organization> implements OrganizationService {

	@Inject
	private OrganizationDao dao;

	@Override
	protected BaseDao<Integer, Organization> getDao() {
		return dao;
	}

	@Override
	public Organization fetchById(Integer id, FetchJoinInformation... joins) {
		return loadRelations(super.fetchById(id, joins));
	}

	@Override
	public List<Organization> fetchByIds(List<Integer> ids, FetchJoinInformation... joins) {
		List<Organization> organizations = super.fetchByIds(ids, joins);
		organizations.forEach(org -> loadRelations(org));
		return organizations;
	}

	@Override
	public List<Organization> fetchByIds(List<Integer> ids, Filter additionalFilter, SortOrders sortOrders,
			FetchJoinInformation... joins) {
		List<Organization> organizations = super.fetchByIds(ids, additionalFilter, sortOrders, joins);
		organizations.forEach(org -> loadRelations(org));
		return organizations;
	}

	@Override
	public List<Organization> fetchByIds(List<Integer> ids, SortOrders sortOrders, FetchJoinInformation... joins) {
		List<Organization> organizations = super.fetchByIds(ids, sortOrders, joins);
		organizations.forEach(org -> loadRelations(org));
		return organizations;
	}

	private Organization loadRelations(Organization org) {

		org.getCountryOfOrigin().getName();

		if (org.getMainActivity() != null) {
			org.getMainActivity().getName();
		}
		org.getMembers().forEach(m -> m.getFirstName());
		return org;
	}

}

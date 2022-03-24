//package com.ocs.gts.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ocs.dynamo.dao.BaseDao;
//import com.ocs.dynamo.envers.domain.RevisionKey;
//import com.ocs.dynamo.service.impl.BaseServiceImpl;
//import com.ocs.gts.domain.aud.VersionedOrganization;
//import com.ocs.gts.domain.dao.aud.VersionedOrganizationDao;
//import com.ocs.gts.service.VersionedOrganizationService;
//
//@Service
//public class VersionedOrganizationServiceImpl extends BaseServiceImpl<RevisionKey<Integer>, VersionedOrganization>
//		implements VersionedOrganizationService {
//
//	@Autowired
//	private VersionedOrganizationDao dao;
//
//	@Override
//	protected BaseDao<RevisionKey<Integer>, VersionedOrganization> getDao() {
//		return dao;
//	}
//
//}

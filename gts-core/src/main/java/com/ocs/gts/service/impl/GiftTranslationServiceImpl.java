package com.ocs.gts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocs.dynamo.dao.BaseDao;
import com.ocs.dynamo.service.impl.BaseServiceImpl;
import com.ocs.gts.domain.GiftTranslation;
import com.ocs.gts.domain.dao.GiftTranslationDao;
import com.ocs.gts.service.GiftTranslationService;

@Service
public class GiftTranslationServiceImpl extends BaseServiceImpl<Integer, GiftTranslation>
		implements GiftTranslationService {

	@Autowired
	private GiftTranslationDao dao;

	@Override
	protected BaseDao<Integer, GiftTranslation> getDao() {
		return dao;
	}

}

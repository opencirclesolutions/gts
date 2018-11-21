package com.ocs.gts.domain.dao.impl;

import org.springframework.stereotype.Repository;

import com.ocs.dynamo.dao.impl.BaseDaoImpl;
import com.ocs.gts.domain.GiftTranslation;
import com.ocs.gts.domain.QGiftTranslation;
import com.ocs.gts.domain.dao.GiftTranslationDao;
import com.querydsl.core.types.dsl.EntityPathBase;

@Repository
public class GiftTranslationDaoImpl extends BaseDaoImpl<Integer, GiftTranslation> implements GiftTranslationDao {

	@Override
	public Class<GiftTranslation> getEntityClass() {
		return GiftTranslation.class;
	}

	@Override
	protected EntityPathBase<GiftTranslation> getDslRoot() {
		return QGiftTranslation.giftTranslation;
	}

}

package com.ocs.gts.domain.dao.impl;

import com.ocs.dynamo.dao.impl.BaseDaoImpl;
import com.ocs.gts.domain.Gift;
import com.ocs.gts.domain.QGift;
import com.ocs.gts.domain.dao.GiftDao;
import com.querydsl.core.types.dsl.EntityPathBase;
import org.springframework.stereotype.Repository;

@Repository
public class GiftDaoImpl extends BaseDaoImpl<Integer, Gift> implements GiftDao {

	@Override
	public Class<Gift> getEntityClass() {
		return Gift.class;
	}

	@Override
	protected EntityPathBase<Gift> getDslRoot() {
		return QGift.gift;
	}

}

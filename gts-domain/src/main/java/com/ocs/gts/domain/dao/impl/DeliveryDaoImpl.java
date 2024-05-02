package com.ocs.gts.domain.dao.impl;

import org.springframework.stereotype.Repository;

import com.ocs.dynamo.dao.FetchJoinInformation;
import com.ocs.dynamo.dao.impl.BaseDaoImpl;
import com.ocs.gts.domain.Delivery;
import com.ocs.gts.domain.QDelivery;
import com.ocs.gts.domain.dao.DeliveryDao;
import com.querydsl.core.types.dsl.EntityPathBase;

@Repository
public class DeliveryDaoImpl extends BaseDaoImpl<Integer, Delivery> implements DeliveryDao {

	@Override
	public Class<Delivery> getEntityClass() {
		return Delivery.class;
	}

	@Override
	protected EntityPathBase<Delivery> getDslRoot() {
		return QDelivery.delivery;
	}

}

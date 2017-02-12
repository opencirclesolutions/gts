package com.ocs.gts.domain.dao.impl;

import org.springframework.stereotype.Repository;

import com.mysema.query.types.path.EntityPathBase;
import com.ocs.dynamo.dao.impl.BaseDaoImpl;
import com.ocs.dynamo.dao.query.FetchJoinInformation;
import com.ocs.gts.domain.Delivery;
import com.ocs.gts.domain.QDelivery;
import com.ocs.gts.domain.dao.DeliveryDao;

@Repository("deliveryDao")
public class DeliveryDaoImpl extends BaseDaoImpl<Integer, Delivery> implements DeliveryDao {

	@Override
	public Class<Delivery> getEntityClass() {
		return Delivery.class;
	}

	@Override
	protected EntityPathBase<Delivery> getDslRoot() {
		return QDelivery.delivery;
	}

	@Override
	protected FetchJoinInformation[] getFetchJoins() {
		return new FetchJoinInformation[] { new FetchJoinInformation("fromPerson"),
		        new FetchJoinInformation("toPerson"), new FetchJoinInformation("gift") };
	}
}

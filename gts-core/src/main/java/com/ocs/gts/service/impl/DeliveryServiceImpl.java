package com.ocs.gts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocs.dynamo.dao.BaseDao;
import com.ocs.dynamo.service.impl.BaseServiceImpl;
import com.ocs.gts.domain.Delivery;
import com.ocs.gts.domain.dao.DeliveryDao;
import com.ocs.gts.service.DeliveryService;

@Service("deliveryService")
public class DeliveryServiceImpl extends BaseServiceImpl<Integer, Delivery> implements DeliveryService {

	@Autowired
	private DeliveryDao dao;

	@Override
	protected BaseDao<Integer, Delivery> getDao() {
		return dao;
	}

}

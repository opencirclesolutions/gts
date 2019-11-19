package com.ocs.gts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.dynamo.dao.BaseDao;
import com.ocs.dynamo.dao.FetchJoinInformation;
import com.ocs.dynamo.dao.SortOrders;
import com.ocs.dynamo.filter.Filter;
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

    @Override
    @Transactional
    public List<Delivery> fetch(Filter filter, FetchJoinInformation... joins) {
        return super.fetch(filter, joins);
    }

    @Override
    @Transactional
    public List<Delivery> fetch(Filter filter, int pageNumber, int pageSize, FetchJoinInformation... joins) {
        return super.fetch(filter, pageNumber, pageSize, joins);
    }
    
    @Override
    @Transactional
    public List<Delivery> fetch(Filter filter, int pageNumber, int pageSize, SortOrders sortOrders, FetchJoinInformation... joins) {
        return super.fetch(filter, pageNumber, pageSize, sortOrders, joins);
    }
    
    @Override
    @Transactional
    public List<Delivery> fetch(Filter filter, SortOrders orders, FetchJoinInformation... joins) {
        return super.fetch(filter, orders, joins);
    }
}

package com.ocs.gts.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ocs.dynamo.dao.BaseDao;
import com.ocs.dynamo.dao.FetchJoinInformation;
import com.ocs.dynamo.dao.SortOrder;
import com.ocs.dynamo.dao.SortOrders;
import com.ocs.dynamo.filter.Filter;
import com.ocs.dynamo.service.impl.BaseServiceImpl;
import com.ocs.gts.domain.Gift;
import com.ocs.gts.domain.dao.GiftDao;
import com.ocs.gts.service.GiftService;

@Transactional
@Service("giftService")
public class GiftServiceImpl extends BaseServiceImpl<Integer, Gift> implements GiftService {

    @Inject
    private GiftDao dao;

    @Override
    protected BaseDao<Integer, Gift> getDao() {
        return dao;
    }

    @Override
    @Transactional
    public List<Gift> fetchByIds(List<Integer> ids, SortOrders sortOrders, FetchJoinInformation... joins) {
        return super.fetchByIds(ids, sortOrders, joins);
    }

    @Override
    @Transactional
    public List<Gift> fetchByIds(List<Integer> ids, FetchJoinInformation... joins) {
        return super.fetchByIds(ids, joins);
    }
    
    @Override
    @Transactional
    public Gift fetchById(Integer id, FetchJoinInformation... joins) {
        return super.fetchById(id, joins);
    }
    
    @Override
    @Transactional
    public List<Gift> find(Filter filter) {
        return super.find(filter);
    }
    
    @Override
    @Transactional
    public List<Gift> find(Filter filter, SortOrder... orders) {
        return super.find(filter, orders);
    }

}

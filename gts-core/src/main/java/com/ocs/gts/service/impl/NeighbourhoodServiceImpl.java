package com.ocs.gts.service.impl;

import com.ocs.dynamo.dao.BaseDao;
import com.ocs.dynamo.service.impl.BaseServiceImpl;
import com.ocs.gts.domain.Neighbourhood;
import com.ocs.gts.domain.dao.NeighbourhoodDao;
import com.ocs.gts.service.NeighbourhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NeighbourhoodServiceImpl extends BaseServiceImpl<Integer, Neighbourhood>
        implements NeighbourhoodService {

    @Autowired
    private NeighbourhoodDao dao;

    @Override
    protected BaseDao<Integer, Neighbourhood> getDao() {
        return dao;
    }
}

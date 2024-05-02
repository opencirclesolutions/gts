package com.ocs.gts.domain.dao.impl;

import com.ocs.dynamo.dao.impl.BaseDaoImpl;
import com.ocs.gts.domain.Neighbourhood;
import com.ocs.gts.domain.QNeighbourhood;
import com.ocs.gts.domain.dao.NeighbourhoodDao;
import com.querydsl.core.types.dsl.EntityPathBase;
import org.springframework.stereotype.Repository;

@Repository
public class NeighbourhoodDaoImpl extends BaseDaoImpl<Integer, Neighbourhood> implements NeighbourhoodDao {

    @Override
    public Class<Neighbourhood> getEntityClass() {
        return Neighbourhood.class;
    }

    @Override
    protected EntityPathBase<Neighbourhood> getDslRoot() {
        return QNeighbourhood.neighbourhood;
    }
}

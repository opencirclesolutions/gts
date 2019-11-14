package com.ocs.gts.domain.dao.impl;

import org.springframework.stereotype.Repository;

import com.ocs.dynamo.dao.FetchJoinInformation;
import com.ocs.dynamo.dao.impl.BaseDaoImpl;
import com.ocs.gts.domain.Gift;
import com.ocs.gts.domain.QGift;
import com.ocs.gts.domain.dao.GiftDao;
import com.querydsl.core.types.dsl.EntityPathBase;

@Repository("giftDao")
public class GiftDaoImpl extends BaseDaoImpl<Integer, Gift> implements GiftDao {

    @Override
    public Class<Gift> getEntityClass() {
        return Gift.class;
    }

    @Override
    protected EntityPathBase<Gift> getDslRoot() {
        return QGift.gift;
    }

    @Override
    protected FetchJoinInformation[] getFetchJoins() {
        return new FetchJoinInformation[] { new FetchJoinInformation("translations"), new FetchJoinInformation("logo") };
    }
}

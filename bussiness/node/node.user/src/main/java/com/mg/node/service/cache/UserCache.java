package com.mg.node.service.cache;

import com.mg.common.pojo.ResultItem;
import com.mg.node.common.service.cache.IBaseCache;
import com.mg.node.pojo.po.UserPo;
import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;

public class UserCache  extends IBaseCache<UserPo> {
    @Override
    protected boolean check(String key) {
        return false;
    }

    @Override
    protected ResultItem<UserPo> updatePojo(String pojo, UserPo dtoPOJO) {
        return null;
    }


    @Override
    protected ResultItem getPojoByDB(String id) {
        return null;
    }

    @Override
    protected ResultItem deletePojoByDB(String id) {
        return null;
        AtomicInteger
    }
}

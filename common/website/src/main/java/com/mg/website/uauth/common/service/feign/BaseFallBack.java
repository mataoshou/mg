package com.mg.website.uauth.common.service.feign;

import com.mg.common.constant.CommonItemConstant;
import com.mg.common.pojo.CommonItem;

public interface BaseFallBack {

    default CommonItem fail(String serverName)
    {
        CommonItem item = new CommonItem();
        item.setErrorStatus(CommonItemConstant.STATUS_FAIL);

        item.setErrorReason(String.format("[%s]服务访问失败！！",serverName ));

        return item;
    }
}

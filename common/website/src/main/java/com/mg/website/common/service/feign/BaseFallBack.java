package com.mg.website.common.service.feign;

import com.mg.website.common.constant.CommonItemConstant;
import com.mg.website.common.pojo.CommonItem;

public interface BaseFallBack {

    default CommonItem fail(String serverName)
    {
        CommonItem item = new CommonItem();
        item.setErrorStatus(CommonItemConstant.STATUS_FAIL);

        item.setErrorReason(String.format("[%s]服务访问失败！！",serverName ));

        return item;
    }
}

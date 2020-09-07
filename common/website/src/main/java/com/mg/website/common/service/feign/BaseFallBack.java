package com.mg.website.common.service.feign;


import com.mg.common.pojo.ResultItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface BaseFallBack {

    default ResultItem fail(String serverName,String msg) {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info(String.format("[%s]服务访问失败！！",serverName ));
        return new ResultItem(-1,String.format("[%s]服务访问失败[%s]",serverName,msg ));
    }
}

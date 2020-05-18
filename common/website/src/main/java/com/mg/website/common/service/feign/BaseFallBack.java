package com.mg.website.common.service.feign;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface BaseFallBack {

    default void fail(String serverName)
    {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        logger.info(String.format("[%s]服务访问失败！！",serverName ));
    }
}

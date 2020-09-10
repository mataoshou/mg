package com.mg.node.config;

import com.mg.node.common.plugin.mybatis.MgMapperServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MapperServer extends MgMapperServer {

    @Override
    public void configPreLoad() throws Exception {
        log.info(".....开始配置扫描区域！");
        addPackage("com.mg.node.db.sql.pojo");
    }

}

package com.mg.node.service.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SysConfigFeignFallbackFactory implements FallbackFactory<SysConfigFeign> {
    @Override
    public SysConfigFeign create(Throwable cause) {
        log.info(cause.getMessage());
        cause.printStackTrace();
        return new SysConfigFeignFallBack();
    }
}

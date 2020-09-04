package com.mg.compose.service.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SysFeignFallbackFactory implements FallbackFactory<SysFeign> {
    @Override
    public SysFeign create(Throwable cause) {
        log.info(cause.getMessage());
        cause.printStackTrace();
        return new SysFeignFallBack();
    }
}

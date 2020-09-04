package com.mg.website.service.feign;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FreeFeignFallbackFactory implements FallbackFactory<FreeFeign> {
    @Override
    public FreeFeign create(Throwable cause) {
        log.info(cause.getMessage());
        cause.printStackTrace();
        return new FreeFeignFallBack();
    }
}

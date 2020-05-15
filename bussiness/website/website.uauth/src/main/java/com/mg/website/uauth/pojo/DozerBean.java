package com.mg.website.uauth.pojo;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class DozerBean {
    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBean() {

        DozerBeanMapper dozerBean = new DozerBeanMapper();
        return dozerBean;
    }
}

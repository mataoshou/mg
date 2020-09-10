//package com.mg.node.common.frame.mgmybatis.init;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@Slf4j
//public class MgAbstractInitializingConfiguration {
//
//    @Bean
//    @ConditionalOnMissingBean(MgAbstractInitializing.class)
//    public MgAbstractInitializing generalInitializing()
//    {
//        return new MgAbstractInitializing(){
//            @Override
//            public void setConfig() throws Exception {
//                log.info(".....未找到MgAbstractInitializing的实现，无法配置扫描包和pojo");
////                addPojo(RmtActiorInfo.class);
//            }
//        };
//    }
//
//
////    @Bean
////    public StartAddMyMapper SpringContextHolder() {
////        return new StartAddMyMapper();
////    }
//}

package com.mg.node.service.task;

import com.codingapi.txlcn.common.util.SpringUtils;
import com.mg.node.common.constant.PoolConstant;
import com.mg.node.db.sql.imp.ITemplate;
import com.mg.node.db.sql.pojo.RmtUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@EnableScheduling
@Component
public class UserTask {
//
//    @Autowired
//    @Qualifier("userImp")
//    ITemplate<RmtUserInfo> template1;


    @Autowired
    SqlSessionTemplate template;

    @Autowired
    SpringUtil utill;

    @Scheduled(initialDelay=1000, fixedRate=5000)
    @Async(PoolConstant.POOL_SCHEDULE)
    public void dailyDemo() throws Exception {
//        log.info("1111.......................{}",template.getById("111").getId());
//        RmtUserInfo userInfo =template.getBySql("select * from rmt_user_info where id='111'");
//        RmtUserInfo userInfo =;
        Object o = utill.getBean("userImp");
        log.info(",,,,,,,,,,,,{}",o.getClass());
        ITemplate iTemplate= template.getMapper(ITemplate.class);
        log.info("2222.......................{}",iTemplate.getBySql("111"));
    }

}

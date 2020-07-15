package com.mg.node.service.task;

import com.codingapi.txlcn.common.util.SpringUtils;
import com.mg.node.common.constant.PoolConstant;
import com.mg.node.db.sql.build.ClassBuild;
import com.mg.node.db.sql.imp.ITemplate;
import com.mg.node.db.sql.merge.IRmtActiorInfoMapper;
import com.mg.node.db.sql.pojo.RmtActiorInfo;
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
    @Autowired
////    @Qualifier("userImp")
    ITemplate<RmtUserInfo> iTemplate;

    //
    @Autowired
    ITemplate<RmtActiorInfo> iTemplate2;

//    @Autowired
//    IRmtActiorInfoMapper mapper;

    @Autowired
    SqlSessionTemplate template;

    @Autowired
    SpringUtil utill;

    @Scheduled(initialDelay=1000, fixedRate=5000)
    @Async(PoolConstant.POOL_SCHEDULE)
    public void dailyDemo() throws Exception {
        log.info("33333333333333333.......................{}",iTemplate.getBySql("select * from rmt_user_info where id='111'").getId());
        log.info("33333333333333333.......................{}",iTemplate);
        log.info("44444444444444444.......................{}",iTemplate2.getBySql("select * from rmt_actior_info where id='111'"));
        log.info("33333333333333333.......................{}",iTemplate2);
//        RmtUserInfo userInfo =template.getBySql();
//        RmtUserInfo userInfo =;
//        log.info(",.,.,.,{}",template1.getBySql("select * from rmt_user_info where id='111'"));
        ITemplate iTemplate1 = (ITemplate) utill.getBean(ClassBuild.single().cl[0]);
        log.info("1111111111111,,,,,,,,,,,,{}",iTemplate1);

//        ITemplate iTemplate= (ITemplate) template.getMapper(ClassBuild.single().cl[0]);
//        log.info("2222.......................{}",iTemplate.getBySql("select * from rmt_user_info where id='111'"));


//        log.info(",.,.,.,{}",template1.getBySql("select * from rmt_user_info where id='111'"));
        ITemplate iTemplate2 = (ITemplate) utill.getBean(ClassBuild.single().cl[1]);
        log.info("2222222222222,,,,,,,,,,,,{}",iTemplate2);
    }

}

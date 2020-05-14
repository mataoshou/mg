package com.mg.compose.service.task;

import com.mg.compose.common.constant.PoolConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class UserTask {
//
//    @Autowired
//    UserNoticeMessageClient messageClient;

    Logger logger = LoggerFactory.getLogger(UserTask.class);

    @Scheduled(fixedRate = 2000)
    @Async(PoolConstant.POOL_SCHEDULE)
    public void intervalBuild(){

//        logger.info("...........用户更新完成，更新状态！！");

//        messageClient.output().send(MessageBuilder.withPayload(SysCache.single.getCache(CacheConstant.CACHE_SYS_USER)).build());
    }

}

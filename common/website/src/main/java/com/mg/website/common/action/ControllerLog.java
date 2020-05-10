package com.mg.website.common.action;

import com.shineon.api.common.base.constant.sys.SysConstant;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ControllerLog {

    @Pointcut("args(com.alibaba.fastjson.JSONObject)")
    public void params() {
    }

    @Pointcut("execution(* com.shineon.api.action..*.*(..))")
    public void methods() {
    }

    @Pointcut("params() && methods()")
    private void actionLog(){

    }

    @Before("actionLog()")
    public void before(JoinPoint point) {
        log.info(String.format("action [%s] [%s] [%s] start execute", SysConstant.getSys(), point.getTarget().getClass().getSimpleName(),point.getSignature().getName()));
    }
}

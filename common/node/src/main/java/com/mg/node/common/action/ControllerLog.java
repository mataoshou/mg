package com.mg.node.common.action;

import com.mg.node.common.constant.SysConstant;
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


    @Pointcut("execution(* com.mg.node.action..*.*(..))")
    public void methods() {
    }

    @Pointcut("methods()")
    private void actionLog(){

    }

    @Before("actionLog()")
    public void before(JoinPoint point) {
        log.info("action [{}] [{}] [{}] start execute", SysConstant.getSys(), point.getTarget().getClass().getSimpleName(),point.getSignature().getName());
    }



}

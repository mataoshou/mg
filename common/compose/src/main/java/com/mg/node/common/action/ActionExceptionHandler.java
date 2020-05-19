package com.mg.node.common.action;

import com.mg.common.pojo.ResultItem;
import com.mg.node.common.constant.SysConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
@Slf4j
public class ActionExceptionHandler {

    @ResponseBody
    @ExceptionHandler
    public ResultItem processEx(Exception ex) throws Exception {

        String errorReason =String.format("[%s]异常：[%s]", SysConstant.getSys(),ex.getMessage());

        log.info(String.format("[%s]异常：[%s] (%s)", SysConstant.getSys(),ex.getMessage(), ex.getStackTrace()[0]));
        ex.printStackTrace();

        return new ResultItem(-1,ex.getMessage());
    }
}

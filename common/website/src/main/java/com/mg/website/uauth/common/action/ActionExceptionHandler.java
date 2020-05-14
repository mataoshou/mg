package com.mg.website.uauth.common.action;

import com.mg.website.uauth.common.constant.SysConstant;
import com.mg.website.uauth.common.pojo.ApiResultItem;
import com.mg.website.uauth.common.service.convert.BasicCommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class ActionExceptionHandler {

    @Autowired
    BasicCommonUtil utils;

    Logger logger = LoggerFactory.getLogger(SysConstant.getSys());
    @ResponseBody
    @ExceptionHandler
    public ApiResultItem processEx(Exception ex) throws Exception {

        String errorReason =String.format("[%s]异常：[%s]", SysConstant.getSys(),ex.getMessage());

        logger.info(String.format("[%s]异常：[%s] (%s)", SysConstant.getSys(),ex.getMessage(), ex.getStackTrace()[0]));
        ex.printStackTrace();

        return new ApiResultItem(utils.fail(errorReason),null);
    }
}

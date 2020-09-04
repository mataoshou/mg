package com.mg.common.util;

import com.mg.common.action.MgApiException;
import com.mg.common.constant.ResultItemEnum;
import com.mg.common.pojo.ResultItem;


public class ResultItemUtil {

    public static  <T> T getDate(ResultItem<T> item) throws MgApiException {
        if(check(item))
        {
                return item.toItem();
        }
        else{
            throw new MgApiException(item.getCode(),item.getMsg());
        }

    }

    private static boolean check(ResultItem item)
    {
        ResultItemEnum itemEnum = selectResult(item.getCode());

        if(itemEnum.equals(ResultItemEnum.RESULT_ENUM_SUCCESS))
        {
            return true;
        }
        else{
            return false;
        }
    }


    private static ResultItemEnum selectResult(int code){
        switch(code){
            case -16:
                return ResultItemEnum.RESULT_ENUM_AUTH;
            case -99:
                return ResultItemEnum.RESULT_ENUM_DENY;
            case -1:
                return ResultItemEnum.RESULT_ENUM_FAIL;
            default:
                return ResultItemEnum.RESULT_ENUM_SUCCESS;
        }
    }
}

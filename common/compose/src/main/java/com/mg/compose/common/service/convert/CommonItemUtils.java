package com.mg.compose.common.service.convert;

import com.mg.common.constant.CommonItemConstant;
import com.mg.common.pojo.CommonData;
import com.mg.common.pojo.CommonItem;

import java.util.List;

public interface CommonItemUtils<T> {


    CommonItem toCommon(T pojo);

    CommonItem toCommon(List<T> pojos);


    T toPojo(CommonItem item) throws Exception;

    public List<T> toPojoList(CommonItem item) throws Exception;


    ///////////////////////////////////////////////////////////////////////////////////////////
    ///  成功
    //////////////////////////////////////////////////////////////////////////////////////////


    default CommonItem success()
    {
        CommonItem item = new CommonItem();

        return success(item);
    }

    default CommonItem success(CommonItem item)
    {
        item.setErrorStatus(CommonItemConstant.STATUS_SUCCESS);
        item.setErrorReason(CommonItemConstant.REASON_SUCCESS);

        return  item;
    }

    default CommonItem success(CommonData data)
    {
        CommonItem item = new CommonItem();
        item.addData(data);
        return success(item);
    }


    default CommonItem success(List<CommonData> data)
    {
        CommonItem item = new CommonItem();
        item.setDatas(data);
        return success(item);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    ///  失败
    //////////////////////////////////////////////////////////////////////////////////////////
    default CommonItem fail()
    {
        CommonItem item = new CommonItem();

        return fail(item);
    }

    default CommonItem fail(String reason)
    {
        CommonItem item = new CommonItem();

        return fail(item, CommonItemConstant.STATUS_FAIL,reason);
    }

    default CommonItem fail(CommonItem item)
    {
        return fail(item, CommonItemConstant.STATUS_FAIL, CommonItemConstant.REASON_FAIL);
    }

    default CommonItem fail(CommonItem item, String reason)
    {
        return fail(item, CommonItemConstant.STATUS_FAIL,reason);
    }

    default CommonItem fail(CommonItem item, int errorStatus, String reason)
    {
        item.setErrorStatus(errorStatus);

        item.setErrorReason(reason);

        return item;
    }

    default CommonItem fail(int errorStatus, String reason)
    {
        CommonItem item = new CommonItem();

        item.setErrorStatus(errorStatus);

        item.setErrorReason(reason);

        return item;
    }


    default boolean check(CommonItem item)
    {
        if(item.getErrorStatus().equals(CommonItemConstant.STATUS_SUCCESS))
        {
            return true;
        }

        return  false;
    }

    default void checkCommonItem(CommonItem item) throws Exception {
        if(!item.getErrorStatus().equals(CommonItemConstant.STATUS_SUCCESS))
        {
            throw new Exception(item.getErrorReason());
        }
    }

}

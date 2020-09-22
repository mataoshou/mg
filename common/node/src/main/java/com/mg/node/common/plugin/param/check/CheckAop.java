package com.mg.node.common.plugin.param.check;

import com.mg.common.util.ReflectUtil;
import com.mg.node.common.plugin.param.annotation.ParamsCheck;
import com.mg.node.common.plugin.param.constant.CheckType;
import com.mg.node.common.plugin.param.pojo.CheckParamsItem;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
@Slf4j
public class CheckAop {

    @Before(value = "@annotation(com.mg.node.common.plugin.param.annotation.ParamsCheck)")
    public void chenckParam(JoinPoint point) throws Exception {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        ParamsCheck paramsCheck = method.getDeclaredAnnotation(ParamsCheck.class);

        Object[] args = point.getArgs();
        Class cl = method.getParameterTypes()[0];

        if(args==null||args.length==0)
        {
            throw new Exception(String.format("没有获取到函数[%s]参数,请检查是否正确设置！！",method.getName()));
        }

        doCheck(paramsCheck,args[0],method);
    }


    public void doCheck(ParamsCheck paramsCheck,Object param,Method method) throws Exception {
        List<CheckParamsItem> items = getParams(paramsCheck.value());

        for(CheckParamsItem item : items)
        {
            Class paramCl = method.getParameterTypes()[0];
            String methodName = ReflectUtil.getGetMethodName(item.getParam());
            Method getMethod  = paramCl.getDeclaredMethod(methodName);
            item.setValue(getMethod.invoke(param));


            CheckType check = item.getCheckType();
            if(!check.getFunction().apply( item.getValue(),item.getParam())){
                throw new Exception(item.getMsg());
            }
        }
    }

    private List<CheckParamsItem> getParams(String[] values) throws Exception {
        List<CheckParamsItem> items = new ArrayList<>();
        String spliteStr = ":";
        for(String value:values)
        {
            if(value.indexOf(spliteStr)<0) throw new Exception( String.format("[%s]不符合参数模板,标准模板格式[param:title:errMsg]",value));
            String[] item = value.split(spliteStr);
            items.add(new CheckParamsItem(item[0],checkOper(item[1]),item[2]));
        }

        return items;
    }
    private CheckType checkOper(String oper) throws Exception {
        if(oper.equals(CheckType.NONULL.getOper()))
        {
            return CheckType.NONULL;
        }
        else if(oper.equals(CheckType.NOEMPTY.getOper()))
        {
            return CheckType.NOEMPTY;
        }
        else {
            throw new Exception(String.format("不支持的操作类型[%s],可使用的操作[%s||%s]",
                    oper,CheckType.NONULL.getOper(),CheckType.NOEMPTY.getOper()));
        }
    }

}

package com.mg.website.common.action.sys;


import com.mg.common.iservice.ibasic.IFactory;
import com.mg.common.pojo.CommonItem;
import com.mg.website.common.constant.ActionConstant;
import com.mg.website.common.constant.FeignConstant;
import com.mg.website.common.constant.SysConstant;
import com.mg.website.common.generate.action.ActionFactory;
import com.mg.website.common.generate.convert.ConvertFactory;
import com.mg.website.common.generate.feign.FeignFactory;
import com.mg.website.common.service.convert.util.SimpleItemCommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SysOperController {


    @Autowired
    SimpleItemCommonUtil commonUtil;


    @RequestMapping("sys/oper/api")
    public CommonItem api(@RequestBody SysItem item) throws Exception {

        if(item==null)throw new Exception("参数为空，请检查！！");
        if(item.getName()==null||item.getName().trim().length()==0)throw new Exception("名称为空，请检查！！");

        if(item.getMethods()!=null)
        {
            item.setOper(item.getOper().replace("，",","));
        }else{
            item.setMethods(ActionConstant.ACTION_METHOD);
        }

        ActionFactory factory = new ActionFactory(item.getName(),
                Class.forName(item.getCommonName()),
                Class.forName(item.getPojoName()),
                item.getMethods());
        oper(factory,item);
        return commonUtil.success();
    }



    @RequestMapping("sys/oper/feign")
    public CommonItem feign(@RequestBody SysItem item) throws Exception {

        if(item==null)throw new Exception("参数为空，请检查！！");
        if(item.getName()==null||item.getName().trim().length()==0)throw new Exception("名称为空，请检查！！");

        if(item.getMethods()!=null)
        {
            item.setOper(item.getOper().replace("，",","));
        }else{
            item.setMethods(FeignConstant.FEIGN_METHOD);
        }

        FeignFactory factory = new FeignFactory(item.getName(),item.getMethods()
                ,item.getSysName());
        oper(factory,item);
        return commonUtil.success();
    }

//    @RequestMapping("sys/oper/db")
//    public CommonItem db(@RequestBody SysItem item) throws Exception {
//
//
//        GeneratorFactory factory = new GeneratorFactory();
//        factory.build();
//        return commonUtil.success();
//    }

    @RequestMapping("sys/oper/convert")
    public CommonItem convert(@RequestBody SysItem item) throws Exception {


        ConvertFactory factory = new ConvertFactory();
        oper(factory,item);
        return commonUtil.success();
    }



    @RequestMapping("sys/oper/buildAll")
    public CommonItem buildAll(@RequestBody SysItem item) throws Exception {


        if(item==null)throw new Exception("参数为空，请检查！！");
        if(item.getName()==null||item.getName().trim().length()==0)throw new Exception("名称为空，请检查！！");

        if(item.getOper()!=null)
        {
            item.setOper(item.getOper().replace("，",","));
        }
        ActionFactory actionfactory = new ActionFactory(item.getName(),Class.forName(item.getCommonName()),Class.forName(item.getPojoName()),item.getMethods());
        oper(actionfactory,item);


        FeignFactory feignfactory = new FeignFactory(item.getName(),item.getMethods()
                ,item.getSysName());
        oper(feignfactory,item);
        return commonUtil.success();
    }


    public void oper(IFactory factory, SysItem item) throws Exception {
        if(item.getCreateType()==0)
        {
            factory.build();
        }
        else if(item.getCreateType()==1)
        {
            factory.rebuild();
        }
        else if(item.getCreateType()==3)
        {
            factory.edit();
        }
        else if(item.getCreateType()==2)
        {
            factory.delete();
        }
    }

}

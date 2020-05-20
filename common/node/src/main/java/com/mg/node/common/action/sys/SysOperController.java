package com.mg.node.common.action.sys;


import com.mg.common.iservice.ibasic.IFactory;
import com.mg.common.pojo.ResultItem;
import com.mg.node.common.generate.dao.DAOFactory;
import com.mg.node.common.generate.action.ActionFactory;
import com.mg.node.common.generate.db.DBFactory;
import com.mg.node.common.generate.feign.FeignFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SysOperController {


    @RequestMapping("sys/oper/api")
    public ResultItem api(@RequestBody SysItem item) throws Exception {

        if(item==null)throw new Exception("参数为空，请检查！！");
        if(item.getName()==null||item.getName().trim().length()==0)throw new Exception("名称为空，请检查！！");

        if(item.getMethods()==null)
        {
            item.setOper(item.getOper().replace("，",","));
        }

        ActionFactory factory = new ActionFactory(item);
        oper(factory,item);
        return new ResultItem();
    }



    @RequestMapping("sys/oper/feign")
    public ResultItem feign(@RequestBody SysItem item) throws Exception {

        if(item==null)throw new Exception("参数为空，请检查！！");
        if(item.getName()==null||item.getName().trim().length()==0)throw new Exception("名称为空，请检查！！");

        if(item.getMethods()==null)
        {
            item.setOper(item.getOper().replace("，",","));
        }

        FeignFactory factory = new FeignFactory(item);
        oper(factory,item);
        return new ResultItem();
    }

    @RequestMapping("sys/oper/db")
    public ResultItem db(@RequestBody SysItem item) throws Exception {

        DBFactory factory = new DBFactory();
        factory.build();
        return new ResultItem();
    }

    @RequestMapping("sys/oper/dao")
    public ResultItem dao(@RequestBody SysItem item) throws Exception {

        if(item.getMethods()==null)
        {
            item.setOper(item.getOper().replace("，",","));
        }
        DAOFactory factory = new DAOFactory(item.getName(),Class.forName(item.getPoName()),item.getMethods());
        factory.build();
        return new ResultItem();
    }

//    @RequestMapping("sys/oper/convert")
//    public ResultItem convert(@RequestBody SysItem item) throws Exception {
//
//
//        ConvertFactory factory = new ConvertFactory();
//        oper(factory,item);
//        return new ResultItem();
//    }



    @RequestMapping("sys/oper/buildAll")
    public ResultItem buildAll(@RequestBody SysItem item) throws Exception {


        if(item==null)throw new Exception("参数为空，请检查！！");
        if(item.getName()==null||item.getName().trim().length()==0)throw new Exception("名称为空，请检查！！");

        if(item.getMethods()==null)
        {
            item.setOper(item.getOper().replace("，",","));
        }
        ActionFactory actionfactory = new ActionFactory(item);
        oper(actionfactory,item);


        FeignFactory feignfactory = new FeignFactory(item);
        oper(feignfactory,item);
        return new ResultItem();
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

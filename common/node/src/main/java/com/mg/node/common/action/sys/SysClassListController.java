package com.mg.node.common.action.sys;

import com.mg.common.constant.ServerConstant;
import com.mg.common.pojo.SimpleItem;
import com.mg.common.util.BaseFileUtil;
import com.mg.node.common.constant.CommonConstant;
import com.mg.node.common.constant.DBConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class SysClassListController {


    @RequestMapping("sys/list/repository")
    public List<SimpleItem> listDTO() throws IOException {

        File root =getRoot(CommonConstant.RESPOSITORY_PACKAGE);

        log.info(root.getPath());

        List<SimpleItem> names = getFileNames(root, CommonConstant.RESPOSITORY_PACKAGE);

        return names;
    }

    @RequestMapping("sys/list/indto")
    public  List<SimpleItem> listinDtos() throws IOException {

        File root =getRoot(CommonConstant.INDTO_PACKAGE);

        log.info(root.getPath());

        List<SimpleItem> names = getFileNames(root, CommonConstant.INDTO_PACKAGE);

        return names;
    }

    @RequestMapping("sys/list/outdto")
    public  List<SimpleItem> listoutDtos() throws IOException {

        File root =getRoot(CommonConstant.OUTDTO_PACKAGE);

        log.info(root.getPath());

        List<SimpleItem> names = getFileNames(root, CommonConstant.OUTDTO_PACKAGE);

        return names;
    }


    @RequestMapping("sys/list/sysName")
    public  List<SimpleItem> listSysNames() throws IOException, IllegalAccessException {

        ServerConstant constant = new ServerConstant();
        Field[] field = ServerConstant.class.getDeclaredFields();


        List<SimpleItem> names = new ArrayList();
        for (int j = 0; j < field.length; j++) { // 遍历所有属性
            String name = field[j].get(constant).toString(); // 获取属性的名字
            SimpleItem item = new SimpleItem();
            item.setKey(name);
            item.setValue(name);
            names.add(item);
        }

        return names;
    }


    @RequestMapping("sys/list/invo")
    public  List<SimpleItem> listInVos() throws IOException {

        File root =getRoot(CommonConstant.INVO_PACKAGE);

        log.info(root.getPath());

        List<SimpleItem> names = getFileNames(root, CommonConstant.INVO_PACKAGE);

        return names;
    }


    @RequestMapping("sys/list/outvo")
    public  List<SimpleItem> listOutVos() throws IOException {

        File root =getRoot(CommonConstant.OUTVO_PACKAGE);

        log.info(root.getPath());

        List<SimpleItem> names = getFileNames(root, CommonConstant.OUTVO_PACKAGE);

        return names;
    }

    @RequestMapping("sys/list/bo")
    public  List<SimpleItem> listBos() throws IOException {

        File root =getRoot(CommonConstant.BO_PACKAGE);

        log.info(root.getPath());

        List<SimpleItem> names = getFileNames(root, CommonConstant.BO_PACKAGE);

        return names;
    }

    @RequestMapping("sys/list/po")
    public  List<SimpleItem> listPos() throws IOException {

        File root =getRoot(DBConstant.DB_POJO_PACKAGE);

        log.info(root.getPath());

        List<SimpleItem> names = getFileNames(root, DBConstant.DB_POJO_PACKAGE);

        return names;
    }

    public List<SimpleItem> getFileNames(File file, String pre)
    {
        File[] fs = file.listFiles();
        List<SimpleItem> names = new ArrayList();
        if(fs==null||fs.length==0)return names;
        for(File f :fs) {
            SimpleItem item = new SimpleItem();
            item.setKey(pre + "." + BaseFileUtil.getFileNameNoSuffix(f.getName()));
            item.setValue( BaseFileUtil.getFileNameNoSuffix(f.getName()));
            names.add( item);
        }
        return names;
    }

    public File getRoot(String packageName)
    {
        File base = new File( this.getClass().getResource("/").getPath());

        File root = new File(base,packageName.replace(".","/"));

        System.out.println("......."  + root.getPath());

        return root;
    }
}

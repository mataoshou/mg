package com.mg.common.genate.ibasic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 生成过程组合
 */
public abstract class IMakeUpBase {


    public IMakeUpBase(String name, Class toolClass,
                       Class pojoClass, String[] methods, String sysName)
    {

    }

    protected void add(ICreate item)
    {
        items.add(item);
    }


    List<ICreate> items = new ArrayList<>();

    /**
     * 重新生成对象
     * @throws IOException
     */
    public void rebuild() throws IOException{
        for(ICreate item : items)
        {
            item.setConver(true);
            item.startCreate();
        }

    }

    /**
     * 生成对象
     * @throws IOException
     */
    public void build() throws IOException{
        for(ICreate item : items)
        {
            item.startCreate();
        }
    }

    public void edit() throws IOException {
        for(ICreate item : items)
        {
            item.startEdit();
        }
    }


    /**
     * 删除生成的对象
     */
    public void delete(){
        for(ICreate item : items)
        {
            item.deleteFile();
        }
    }

    /**
     * 清空文件夹
     */
    public void empty()
    {
        for(ICreate item : items)
        {
            item.empty();
        }
    }
}

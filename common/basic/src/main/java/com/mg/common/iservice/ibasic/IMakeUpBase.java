package com.mg.common.iservice.ibasic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 生成过程组合
 */
public abstract class IMakeUpBase {


    public IMakeUpBase()
    {

    }
    
    
    public void initMakeUp(String name, String[] methods, String sysName, ICreate item)
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
            item.setOverwrite(true);
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

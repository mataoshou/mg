package com.mg.node.common.frame.mgmybatis;

import com.mg.node.common.frame.mgmybatis.produce.ProduceStore;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperProxy;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public abstract class MgMapperServer implements ApplicationContextAware {

    @Autowired
    SqlSessionTemplate template;

    @Autowired
    ProduceStore store;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.debug("[begin add mapper]");
        try {
            configPreLoad();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Class> cls = store.listClass();
        for(Class cl : cls) {
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(cl);
            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
            GenericBeanDefinition definition = (GenericBeanDefinition) beanDefinitionBuilder.getRawBeanDefinition();

            definition.setBeanClass(MapperFactoryBean.class);
            definition.getPropertyValues().add("sqlSessionTemplate",template);
            definition.getPropertyValues().add("mapperInterface",cl);
            defaultListableBeanFactory.registerBeanDefinition(cl.getSimpleName(), beanDefinitionBuilder.getBeanDefinition());
        }
        store.cleanData();
    }

    /**
     * 直接添加的方式，可用
     * @param cl
     * @param applicationContext
     */
    private void addMapper(Class  cl,ApplicationContext applicationContext)
    {
        template.getConfiguration().addMapper(cl);
        Object mapper = template.getMapper(cl);
        MapperProxy mapperProxy = new MapperProxy(template, cl, new ConcurrentHashMap<>());
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(mapper.getClass());
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        beanDefinitionBuilder.addConstructorArgValue(mapperProxy);
        defaultListableBeanFactory.registerBeanDefinition(cl.getSimpleName(), beanDefinitionBuilder.getBeanDefinition());
    }


    public abstract void configPreLoad()throws Exception;

    /**
     * 添加新的pojo
     * @param pojo
     */
    protected void addPojo(Class pojo){
        store.addPojo(pojo);
    }

    /**
     * 添加新的pojo
     * @param pojo
     * @param template
     * @param imp
     */
    protected void addPojo(Class pojo,Class template,Class imp){
        store.addPojo(pojo,template,imp);
    }

    /**
     * 添加扫描包
     * @param packageName
     * @throws Exception
     */
    protected void addPackage(String packageName) throws Exception{
        store.addPackage(packageName);
    }

    /**
     * 添加扫描包
     * @param packageName
     * @param template
     * @param imp
     * @throws Exception
     */
    protected void addPackage(String packageName,Class template,Class imp) throws Exception{
        store.addPackage(packageName,template,imp);
    }

    protected void setDefaultTemplate(Class defaultTemplate )
    {
        store.setDefTemplate(defaultTemplate);
    }

    protected void setDefaultImp(Class defaultImp )
    {
        store.setDefImp(defaultImp);
    }
}

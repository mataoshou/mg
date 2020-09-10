package com.mg.node.common.plugin.mybatis;

import com.mg.node.common.plugin.mybatis.produce.ProduceStore;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.*;

import java.util.List;

@Slf4j
public abstract class MgMapperServer implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        log.debug("[begin add mapper]");
        try {
            configPreLoad();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Class> cls = ProduceStore.single().listClass();
        for(Class cl : cls) {
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
//            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
            GenericBeanDefinition definition = (GenericBeanDefinition) beanDefinitionBuilder.getRawBeanDefinition();

            definition.setBeanClass(MapperFactoryBean.class);
            definition.getPropertyValues().add("sqlSessionTemplate",new RuntimeBeanReference("sqlSessionTemplate"));
//            definition.getPropertyValues().add("sqlSessionFactory",new RuntimeBeanReference("sqlSessionFactory"));
            definition.getPropertyValues().add("mapperInterface",cl);
            registry.registerBeanDefinition(cl.getSimpleName(), beanDefinitionBuilder.getBeanDefinition());
        }
        ProduceStore.single().cleanData();
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        log.debug("[begin add mapper]");
//        try {
//            configPreLoad();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        List<Class> cls = store.listClass();
//        for(Class cl : cls) {
//            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(cl);
//            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
//            GenericBeanDefinition definition = (GenericBeanDefinition) beanDefinitionBuilder.getRawBeanDefinition();
//
//            definition.setBeanClass(MapperFactoryBean.class);
//            definition.getPropertyValues().add("sqlSessionTemplate",template);
//            definition.getPropertyValues().add("mapperInterface",cl);
//            defaultListableBeanFactory.registerBeanDefinition(cl.getSimpleName(), beanDefinitionBuilder.getBeanDefinition());
//        }
//        store.cleanData();
//    }

//    /**
//     * 直接添加的方式，可用
//     * @param cl
//     * @param applicationContext
//     */
//    private void addMapper(Class  cl,ApplicationContext applicationContext)
//    {
//        template.getConfiguration().addMapper(cl);
//        Object mapper = template.getMapper(cl);
//        MapperProxy mapperProxy = new MapperProxy(template, cl, new ConcurrentHashMap<>());
//        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(mapper.getClass());
//        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
//        beanDefinitionBuilder.addConstructorArgValue(mapperProxy);
//        defaultListableBeanFactory.registerBeanDefinition(cl.getSimpleName(), beanDefinitionBuilder.getBeanDefinition());
//    }


    public abstract void configPreLoad()throws Exception;

    /**
     * 添加新的pojo
     * @param pojo
     */
    protected void addPojo(Class pojo){
        ProduceStore.single().addPojo(pojo);
    }

    /**
     * 添加新的pojo
     * @param pojo
     * @param template
     * @param imp
     */
    protected void addPojo(Class pojo,Class template,Class imp){
        ProduceStore.single().addPojo(pojo,template,imp);
    }

    /**
     * 添加扫描包
     * @param packageName
     * @throws Exception
     */
    protected void addPackage(String packageName) throws Exception{
        ProduceStore.single().addPackage(packageName);
    }

    /**
     * 添加扫描包
     * @param packageName
     * @param template
     * @param imp
     * @throws Exception
     */
    protected void addPackage(String packageName,Class template,Class imp) throws Exception{
        ProduceStore.single().addPackage(packageName,template,imp);
    }

    protected void setDefaultTemplate(Class defaultTemplate )
    {
        ProduceStore.single().setDefTemplate(defaultTemplate);
    }

    protected void setDefaultImp(Class defaultImp )
    {
        ProduceStore.single().setDefImp(defaultImp);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}

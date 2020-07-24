//package com.mg.node.db.sql.build;
//
//import com.itranswarp.compiler.JavaStringCompiler;
//import com.mg.node.db.sql.imp.ITemplate;
//import com.mg.node.service.task.SpringUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.binding.MapperProxy;
//import org.apache.ibatis.binding.MapperRegistry;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.mapper.MapperFactoryBean;
//import org.mybatis.spring.mapper.MapperScannerConfigurer;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.support.BeanDefinitionBuilder;
//import org.springframework.beans.factory.support.DefaultListableBeanFactory;
//import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationHandler;
//import java.lang.reflect.Parameter;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Service
//@Slf4j
//public class StartAddMyMapper implements InitializingBean, ApplicationContextAware {
////    @Autowired
////    MapperFactoryBean factoryBean;
//
//
//    @Autowired
//    SqlSessionTemplate template;
//
//    @Autowired
//    SqlSessionFactory sqlSessionFactory;
//
//
////    @Autowired
////    MapperRegistry registry;
////    @Override
////    public void onApplicationEvent(ContextRefreshedEvent event)
////    {
////
////
//////        Class cl =ClassBuild.single().cl;
//////        MapperFactoryBean bean = new MapperFactoryBean(ITemplate.class);
//////        bean.setSqlSessionTemplate(template);
//////        bean.setSqlSessionFactory(sqlSessionFactory);
//////        template.(ITemplate.class);
////    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//
//    }
//
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        template.getSqlSessionFactory().getConfiguration();
//        log.info(".......add mapper");
////        sqlSessionFactory.getConfiguration().addMapper(ITemplate.class);
////        ITemplate cl =template.getMapper(ITemplate.class);
////        log.info("............className:" +cl.getClass().getName());
//
//        for(int i=0;i<2;i++) {
//
//            sqlSessionFactory.getConfiguration().addMapper(ClassBuild.single().cl[i]);
//            Object mapper = template.getMapper(ClassBuild.single().cl[i]);
//            log.info("............className:" + mapper.toString());
//
////        log.info("............proxy:{}" ,proxy);
//
////        Constructor[] cs = cl.getClass().getConstructors();
////        for (Constructor c : cs) {
////            Parameter[] ps = c.getParameters();
////            String pStr = "";
////            for (Parameter p : ps) {
////                pStr += p.getType().getSimpleName() + " " + p.getName() + ",";
////            }
////            log.info("......{} ({})", c.getName(), pStr);
////        }
//
//
//            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(mapper.getClass());
//            Class scl = ClassBuild.single().cl[i];
//            MapperProxy mapperProxy = new MapperProxy(template.getSqlSessionFactory().openSession(), scl, new ConcurrentHashMap<>());
//
//            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
//
//            beanDefinitionBuilder.addConstructorArgValue(mapperProxy);
//            defaultListableBeanFactory.registerBeanDefinition("userImp"+i, beanDefinitionBuilder.getBeanDefinition());
//        }
//    }
//}

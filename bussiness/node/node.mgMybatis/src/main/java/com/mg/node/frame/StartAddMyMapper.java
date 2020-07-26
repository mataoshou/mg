package com.mg.node.frame;

import com.mg.node.db.sql.build.ClassBuild;
import com.mg.node.frame.init.MgAbstractInitializing;
import com.mg.node.frame.produce.ProduceStore;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperProxy;
import org.apache.ibatis.binding.MapperProxyFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class StartAddMyMapper implements InitializingBean, ApplicationContextAware {

    @Autowired
    SqlSessionTemplate template;

//    @Autowired
//    SqlSessionFactory sqlSessionFactory;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Autowired
    MgAbstractInitializing initializing;

    @Autowired
    ProduceStore store;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        template.getSqlSessionFactory().getConfiguration();
        log.debug("[begin  add mapper]");

        try {
            initializing.setConfig();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Class> cls = store.listClass();
        SqlSession session = template.getSqlSessionFactory().openSession();
        for(Class cl : cls) {
//            template.getConfiguration().addMapper(cl);
//            Object mapper = template.getMapper(cl);
            MapperProxy mapperProxy = new MapperProxy(session, cl, new ConcurrentHashMap<>());
            MapperProxyFactory factory = new MapperProxyFactory(cl);
            Object mapper =factory.newInstance(session);
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(mapper.getClass());
//

            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
            beanDefinitionBuilder.addConstructorArgValue(mapperProxy);
            defaultListableBeanFactory.registerBeanDefinition(cl.getSimpleName(), beanDefinitionBuilder.getBeanDefinition());
        }
//        session.close();
    }
}

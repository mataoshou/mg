package com.mg.node.db.sql.build;

import com.itranswarp.compiler.JavaStringCompiler;
import com.mg.node.db.sql.imp.ITemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
@Service
@Slf4j
public class StartAddDataListener  implements ApplicationListener<ContextRefreshedEvent> {
//    @Autowired
//    MapperFactoryBean factoryBean;


    @Autowired
    SqlSessionTemplate template;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

//    @Autowired
//    MapperRegistry registry;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        template.getSqlSessionFactory().getConfiguration();
        log.info(".......add mapper");
        sqlSessionFactory.getConfiguration().addMapper(ITemplate.class);
        ITemplate cl =template.getMapper(ITemplate.class);
        log.info("............className:" +cl.getClass().getName());

        ApplicationContext applicationContext =event.getApplicationContext();
        applicationContext.getAutowireCapableBeanFactory();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(cl.getClass());
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory)applicationContext.getAutowireCapableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("userImp",beanDefinitionBuilder.getBeanDefinition());


//        Class cl =ClassBuild.single().cl;
//        MapperFactoryBean bean = new MapperFactoryBean(ITemplate.class);
//        bean.setSqlSessionTemplate(template);
//        bean.setSqlSessionFactory(sqlSessionFactory);
//        template.(ITemplate.class);
    }
}

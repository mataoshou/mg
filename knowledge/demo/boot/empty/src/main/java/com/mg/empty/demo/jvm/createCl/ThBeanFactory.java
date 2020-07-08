package com.mg.empty.demo.jvm.createCl;

import groovy.lang.GroovyClassLoader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ThBeanFactory implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        log.info(".......add class");

        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory)configurableListableBeanFactory;
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(getAddClass());
        //用于设置指定的类中需要引入的其他bean
        //beanDefinitionBuilder.addPropertyValue("otherBeanName","otherBeanName");
        defaultListableBeanFactory.registerBeanDefinition("mgDemoImp",beanDefinitionBuilder.getBeanDefinition());


        beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(getAddClass2());
//        //用于设置指定的类中需要引入的其他bean
//        //beanDefinitionBuilder.addPropertyValue("otherBeanName","otherBeanName");
        defaultListableBeanFactory.registerBeanDefinition("mgDemoImp2",beanDefinitionBuilder.getBeanDefinition());

    }

    public Class getAddClass()
    {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        //里面的文本是Java代码,但是我们可以看到这是一个字符串我们可以直接生成对应的Class<?>对象,而不需要我们写一个.java文件
        Class<?> clazz = groovyClassLoader.parseClass("package mg.demo;\n" +
                "\n" +
                "import com.mg.empty.demo.jvm.createCl.IDemo;"+
                "public class MgSample implements IDemo{\n" +
                "\n" +
                "    public int count = 22;\n" +
                "    \n" +
                "    public void sayHello() {\n" +
                "        System.out.println(\"mgDemo:\" + count);\n" +
                "    }\n" +
                "}\n");
        return clazz;
    }

    public Class getAddClass2()
    {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        //里面的文本是Java代码,但是我们可以看到这是一个字符串我们可以直接生成对应的Class<?>对象,而不需要我们写一个.java文件
        Class<?> clazz = groovyClassLoader.parseClass("package mg.demo;\n" +
                "\n" +
                "import com.mg.empty.demo.jvm.createCl.IDemo;"+
                "public class MgSample1 implements IDemo{\n" +
                "\n" +
                "    \n" +
                "    public void sayHello() {\n" +
                "        System.out.println(\"mgDemo:sample\" );\n" +
                "    }\n" +
                "}\n");
        return clazz;
    }


//    @Bean
//    ThBeanFactory specialBeanForEngine(){
//        return new ThBeanFactory();
//    }
}

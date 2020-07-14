package com.mg.node.db.sql.build;

import com.itranswarp.compiler.JavaStringCompiler;
import com.mg.node.db.sql.imp.ITemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Component
@Slf4j
public class ThBeanFactory implements BeanFactoryPostProcessor {
//
//    @Autowired
//    MapperRegistry registry;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Autowired
    SqlSessionTemplate template;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        log.info(".......add class");

        log.info("............{}",sqlSessionFactory);
        log.info("............{}",template);

//        template.getSqlSessionFactory().getConfiguration();

        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory)configurableListableBeanFactory;
//        try {
//            Class cl =ClassBuild.single().cl;
//            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(ITemplate.class);
//            defaultListableBeanFactory.registerBeanDefinition("userImp",beanDefinitionBuilder.getBeanDefinition());
//        Class cl =ClassBuild.single().cl;

//            MapperFactoryBean bean = new MapperFactoryBean(cl);
//            bean.setMapperInterface(cl);
//            bean.setSqlSessionFactory(sqlSessionFactory);
//            bean.setSqlSessionTemplate(template);
//            registry.addMapper(cl);
//////            template.getMapper(cl);
//            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(cl);
//            GenericBeanDefinition definition = (GenericBeanDefinition) beanDefinitionBuilder.getRawBeanDefinition();
//            definition.setBeanClass(SqlSessionFactoryBean.class);
//            defaultListableBeanFactory.registerBeanDefinition("UserImp",beanDefinitionBuilder.getBeanDefinition());
//            log.info(".......add bean UserImp");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        //用于设置指定的类中需要引入的其他bean
        //beanDefinitionBuilder.addPropertyValue("otherBeanName","otherBeanName");



//        beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(getAddClass2());
////        //用于设置指定的类中需要引入的其他bean
////        //beanDefinitionBuilder.addPropertyValue("otherBeanName","otherBeanName");
//        defaultListableBeanFactory.registerBeanDefinition("mgDemoImp2",beanDefinitionBuilder.getBeanDefinition());

    }

    public Class getAddClass() throws IOException, ClassNotFoundException {
        // 声明类名
        String className = "UserTemplate";
        String packageName = "com.mg.node.db.sql.build";
//        // 声明包名：package top.fomeiherz;
//        String prefix = String.format("package %s;", packageName);
//        // 全类名：top.fomeiherz.Main
        String fullName = String.format("%s.%s", packageName, className);

        // 传入String类型的代码
        String source = "package com.mg.node.db.sql.build;\n" +
                "\n" +
                "import com.mg.node.db.sql.pojo.RmtActiorInfo;\n" +
                "import com.mg.node.db.sql.pojo.RmtUserInfo;\n" +
                "import org.apache.ibatis.annotations.Param;\n" +
                "import org.apache.ibatis.annotations.Select;"+
                "public interface UserTemplate extends ITemplate<RmtUserInfo>{\n" +
                "\n" +
                "    @Select(\"select * from rmt_actior_info where id=#{id}\")\n" +
                "    RmtUserInfo getById(@Param(\"id\") String id);\n" +
                "\n" +
                "    @Select(\"${sql}\")\n" +
                "    RmtUserInfo getBySql(@Param(\"sql\") String id);\n" +
                "\n" +
                "}";

        JavaStringCompiler compiler = new JavaStringCompiler();
        System.out.println(source);
        // 编译：compiler.compile("Main.java", source)
        Map<String, byte[]> results = compiler.compile(className + ".java", source);
        // 加载内存中byte到Class<?>对象
        Class<?> clazz = compiler.loadClass(fullName, results);
        return clazz;
    }

//    public Class getAddClass() throws IOException, ClassNotFoundException {
//        // 声明类名
//        String className = "MgSample";
//        String packageName = "mg.demo";
//        // 声明包名：package top.fomeiherz;
//        String prefix = String.format("package %s;", packageName);
//        // 全类名：top.fomeiherz.Main
//        String fullName = String.format("%s.%s", packageName, className);
//
//        // 传入String类型的代码
//        String source = "public class MgSample" +
//                "{" +
//                "public static void main(String[] args) {" +
//                "System.out.println(\"...................mgDemoTest\");" +
//                "}" +
//                "}";
//
//        JavaStringCompiler compiler = new JavaStringCompiler();
//        System.out.println(prefix + source);
//        // 编译：compiler.compile("Main.java", source)
//        Map<String, byte[]> results = compiler.compile(className + ".java", prefix + source);
//        // 加载内存中byte到Class<?>对象
//        Class<?> clazz = compiler.loadClass(fullName, results);
//        return clazz;
//    }



//    public Class getAddClass2()
//    {
//        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
//        //里面的文本是Java代码,但是我们可以看到这是一个字符串我们可以直接生成对应的Class<?>对象,而不需要我们写一个.java文件
//        Class<?> clazz = groovyClassLoader.parseClass("package mg.demo;\n" +
//                "\n" +
//                "import com.mg.empty.demo.jvm.createCl.IDemo;"+
//                "public class MgSample1 implements IDemo{\n" +
//                "\n" +
//                "    \n" +
//                "    public void sayHello() {\n" +
//                "        System.out.println(\"mgDemo:sample\" );\n" +
//                "    }\n" +
//                "}\n");
//        return clazz;
//    }


//    @Bean
//    ThBeanFactory specialBeanForEngine(){
//        return new ThBeanFactory();
//    }
}

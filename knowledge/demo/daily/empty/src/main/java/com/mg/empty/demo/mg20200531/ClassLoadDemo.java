package com.mg.empty.demo.mg20200531;

import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

@Slf4j
public class ClassLoadDemo {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Person person = new Person();
        Class cl1 = person.getClass();
        Class cl2 = Person.class;
        Class cl3 = Class.forName("com.mg.empty.demo.mg20200531.Person");
        Class cl4 = ClassLoader.getSystemClassLoader().loadClass("com.mg.empty.demo.mg20200531.Person");


        Class cl = Person.class;
        String pStr = "";
        /////获取所有构造函数
        {
            log.info("------------获取所有构造函数----------------");
            Constructor[] cs = cl.getConstructors();
            for (Constructor c : cs) {
                Parameter[] ps = c.getParameters();
                pStr = "";
                for (Parameter p : ps) {
                    pStr += p.getType().getSimpleName() + " " + p.getName() + ",";
                }
                log.info(String.format("%s (%s)", c.getName(), pStr));
            }
        }

        ///////获取指定构造函数
        {
            log.info("------------获取指定构造函数----------------");
            Constructor sc = cl.getConstructor(String.class);
            Parameter[] ps = sc.getParameters();
            pStr = "";
            for (Parameter p : ps) {
                pStr += p.getType().getSimpleName() + " " + p.getName() + ",";
            }
            log.info(String.format("%s (%s)", sc.getName(), pStr));
        }

        ///////使用构造函数
        {
            log.info("------------使用构造函数----------------");
            Constructor sc1 = cl.getConstructor(String.class);
            Person person1 = (Person) sc1.newInstance("mg");
            log.info(person1.getName());
        }

        /////获取public属性
        {
            log.info("------------获取public属性----------------");
            Field[] fs = cl.getFields();
            for (Field f : fs) {
                log.info(String.format("%s %s", f.getType().getSimpleName(), f.getName()));
            }
        }
        /////获取所有属性
        {
            log.info("------------获取所有属性----------------");
            Field[] fs = cl.getDeclaredFields();
            for(Field f : fs)
            {
                log.info(String.format("%s %s",f.getType().getSimpleName(),f.getName()));
            }
        }
        /////获取指定属性
        {
            log.info("------------获取指定属性----------------");
            Field field = cl.getDeclaredField("name");
            log.info(String.format("%s %s",field.getType().getSimpleName(),field.getName()));
        }
        /////获取和修改属性值
        {
            log.info("------------获取和修改属性值----------------");
            Person person1 = new Person();
            person1.setName("mg");
            Field field = cl.getDeclaredField("name");
            field.setAccessible(true);
            log.info(field.get(person1).toString());
            field.set(person1,"mg2020");
            log.info(field.get(person1).toString());
        }


        /////获取包括父类的所有方法
        {
            log.info("------------获取包括父类的所有方法----------------");
            Method[] ms = cl.getMethods();
            for (Method m : ms) {
                Parameter[] ps = m.getParameters();
                pStr = "";
                for (Parameter p : ps) {
                    pStr += p.getType().getSimpleName() + " " + p.getName() + ",";
                }
                log.info(String.format("%s (%s)", m.getName(), pStr));
            }
        }
        /////获取所有方法
        {
            log.info("------------获取所有方法----------------");
            Method[] ms = cl.getDeclaredMethods();
            for (Method m : ms) {
                Parameter[] ps = m.getParameters();
                pStr = "";
                for (Parameter p : ps) {
                    pStr += p.getType().getSimpleName() + " " + p.getName() + ",";
                }
                log.info(String.format("%s (%s)", m.getName(), pStr));
            }
        }
        /////获取指定方法
        {
            log.info("------------获取指定方法----------------");
            Method method = cl.getMethod("setName",String.class);
            Parameter[] ps = method.getParameters();
            pStr = "";
            for (Parameter p : ps) {
                pStr += p.getType().getSimpleName() + " " + p.getName() + ",";
            }
            log.info(String.format("%s (%s)", method.getName(), pStr));
        }
        /////使用方法
        {
            log.info("------------使用方法----------------");
            Person person1 = new Person();
            Method method = cl.getMethod("setName",String.class);
            method.invoke(person1,"mg");
            log.info(person1.getName());
        }

        /////获取注解
        {
            log.info("------------获取注解----------------");
            Method method = cl.getDeclaredMethod("showMessage");
            Mg annotation = method.getAnnotation(Mg.class);
            log.info(annotation.name());
        }

    }
}

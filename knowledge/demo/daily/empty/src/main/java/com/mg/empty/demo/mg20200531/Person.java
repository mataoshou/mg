package com.mg.empty.demo.mg20200531;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
public class Person {
    static {
        log.info("I am person");
    }

    public Person(String name){this.name=name;}
    public Person(){}
    public int id;
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Mg
    public void showMessage()
    {
        log.info("this person message");
    }
}

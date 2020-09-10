package com.mg.node.common.plugin.mybatis.annotations;


import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Table {
    String value();
}

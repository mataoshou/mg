package com.mg.node.common.frame.mgmybatis.annotations;


import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface MgTable {
    String value();
}

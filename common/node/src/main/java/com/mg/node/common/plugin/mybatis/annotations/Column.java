package com.mg.node.common.plugin.mybatis.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Column {
    String cloumn();
    boolean ingore() default false;

}

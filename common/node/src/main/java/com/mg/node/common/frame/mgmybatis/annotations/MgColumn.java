package com.mg.node.common.frame.mgmybatis.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface MgColumn {
    String cloumn();
    boolean ingore() default false;

}

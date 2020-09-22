package com.mg.node.common.plugin.param.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ParamsCheck {

    String[] value();

}

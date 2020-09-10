package com.mg.node.common.plugin.mybatis.annotations;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface PrimaryId {
    int idType()default 0;
}

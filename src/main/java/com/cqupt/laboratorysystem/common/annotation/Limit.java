package com.cqupt.laboratorysystem.common.annotation;

import com.cqupt.laboratorysystem.common.utils.LimitType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @create 2023/5/2 20:53
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Limit {

    // 单位时间，以秒为单位
    int period() default 0;

    // 单位时间最大访问次数
    int requestLimitMaxNum() default 10000;

    LimitType limit() default LimitType.CUSTOMER;

    String type() default "customer";

    String prefix() default "limit";

}

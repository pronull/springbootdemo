package com.github.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by qwe on 17/4/10.
 */
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface OnPage {

    String[] pageSize() default {};

    String[] pageIndex() default {};
}

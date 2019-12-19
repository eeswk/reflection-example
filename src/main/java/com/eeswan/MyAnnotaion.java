package com.eeswan;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
public @interface MyAnnotaion {

    String name() default "swan";

    int number() default 100;

    String value() default "eeswan";

}

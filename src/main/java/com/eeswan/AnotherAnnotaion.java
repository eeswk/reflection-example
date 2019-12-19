package com.eeswan;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface AnotherAnnotaion {

    String name() default "swan";

    int number() default 100;

    String value() default "eeswan";

}

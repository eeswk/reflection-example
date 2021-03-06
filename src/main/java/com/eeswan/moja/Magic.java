package com.eeswan.moja;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 애노테이션 프로세서
 */
@Target(ElementType.TYPE) // interface, class, enum
@Retention(RetentionPolicy.SOURCE)
public @interface Magic {
}

package com.arminzheng.observer.infrastructure.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * field mapping
 *
 * @author Yu Zheng
 * @since 2021-09-04
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(FieldMaps.class)
@Documented
public @interface FieldMap {
    String channel();

    String value();
}

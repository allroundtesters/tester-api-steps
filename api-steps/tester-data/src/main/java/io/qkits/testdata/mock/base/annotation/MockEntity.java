package io.qkits.testdata.mock.base.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MockEntity {
    String[] value() default "";
}

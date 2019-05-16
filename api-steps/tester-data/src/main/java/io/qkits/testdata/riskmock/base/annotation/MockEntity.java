package io.qkits.testdata.riskmock.base.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MockEntity {
    String[] value() default "";
}

package io.qkits.common.reflections.tpmock.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Invoker {

  String value() default "";

  String serviceName() default "";
}
package io.qkits.testdata.riskmock.base.annotation;

import java.lang.annotation.*;

/**
 * document the configuration tables for the annotated service
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FeatuerConfig {
    String[] config() default "";
}

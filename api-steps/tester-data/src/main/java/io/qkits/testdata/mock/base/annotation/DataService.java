package io.qkits.testdata.mock.base.annotation;

import java.lang.annotation.*;

/**
 * name: serviceName
 * desc: 三方数据的中文名或者规则中配置名称
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataService {
  String name() default "";

  String desc() default "";
}

package io.qkits.rule.common.util;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Order(value = -1000)
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext ;

    public static <T> T getBeanByName(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

    public static <T> T getBeanByClass(Class clazz) {
        return (T) applicationContext.getBean(clazz);
    }

    @Autowired
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(this.applicationContext == null){
            this.applicationContext  = applicationContext;
        }
    }

    public static <T> Map<String, T> getBeansByType(Class clazz) {

        return applicationContext.getBeansOfType(clazz);
    }
}

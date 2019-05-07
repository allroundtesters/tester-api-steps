package io.qkits.testdata.mock.base;

import io.qkits.testdata.mock.base.annotation.DataService;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @author patrick
 */
@Slf4j
public class FeaturesProvider {
    /**
     * Get All The Features
     * @return Map, Key: serviceName, value: @ServiceFeatureDefinition
     */
    public Map<String, ServiceFeatureDefinition> getAllFeatures() {

        Reflections reflections = new Reflections(FeaturesConstant.FEATURE_PACKAGE);
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(DataService.class);
        Map<String, ServiceFeatureDefinition> sfdMapping = new HashMap<>();
        for (Class<?> tpClass : annotated) {
            ServiceFeatureDefinition sfd = new ServiceFeatureDefinition();
            DataService ds = tpClass.getAnnotation(DataService.class);
            //todo: consider data service description
            //todo: feature use json configuration
            if (ds != null) {
                sfd.setServiceName(ds.name());
            } else {
                sfd.setServiceName(tpClass.getSimpleName());
            }
            try {
                BaseFeatureEntity entity = (BaseFeatureEntity) tpClass.getDeclaredConstructor().newInstance();
                sfd.setFeatures(entity.getDataPathMap());
                sfdMapping.putIfAbsent(sfd.getServiceName(), sfd);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                log.error("fail to init service {},error={}", tpClass.getName(), e);
            }
        }
        return sfdMapping;
    }
}

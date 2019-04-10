package io.qkits.common.reflections;

import dorkbox.annotation.AnnotationDefaults;
import dorkbox.annotation.AnnotationDetector;
import io.qkits.common.reflections.tpmock.annotation.Invoker;
import io.qkits.common.reflections.tpmock.features.BaseTPEntity;
import io.qkits.common.reflections.tpmock.features.DataPath;
import org.junit.Test;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AnnotationScannerTest {

    @Test
    public void testScanTPMOCK() throws IOException, IllegalAccessException, InstantiationException {
        List<Class<?>> classModules = AnnotationDetector.
                scanClassPath("io.qkits.common.reflections.tpmock.features.tp")
                .forAnnotations(Invoker.class).on(ElementType.TYPE)
                .collect(AnnotationDefaults.getType);

        System.out.println(classModules);

        //data structure: serviceName+ Features
        Map<String, Map<String, DataPath>>featureMapping = new HashMap<>();
        for (Class<?> classModule : classModules) {
            BaseTPEntity instance = (BaseTPEntity) classModule.newInstance();
            Invoker invoker = instance.getClass().getAnnotation(Invoker.class);
            String serviceName = invoker.serviceName();
            featureMapping.put(serviceName,instance.getDataPathMap());
        }

        System.out.println(featureMapping);
        System.out.println(featureMapping.size());
    }
}
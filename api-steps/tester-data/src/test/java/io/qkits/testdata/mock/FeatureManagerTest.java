package io.qkits.testdata.mock;

import io.qkits.testdata.mock.base.ServiceFeatureDefinition;
import org.assertj.core.api.Assertions;

import java.util.Map;
import java.util.Set;


class FeatureManagerTest {
    FeatureManager featureManager = new FeatureManager();

    @org.junit.jupiter.api.Test
    void testGetFeaturesByTPName() {
//        featureManager.getFeaturesByTPName("")
    }

    @org.junit.jupiter.api.Test
    void getFeaturesByServiceName() {
       Set<String> featureNames = featureManager.getFeaturesByServiceName("pyAntifraudEntryService");
        Assertions.assertThat(featureNames.size()).isGreaterThan(1);
    }

    @org.junit.jupiter.api.Test
    void getServiceFeatureDefByServiceName() {
        ServiceFeatureDefinition sfd = featureManager.getServiceFeatureDefByServiceName("pyAntifraudEntryService");
        Assertions.assertThat(sfd.getServiceName()).isEqualTo("pyAntifraudEntryService");
    }

    @org.junit.jupiter.api.Test
    void getAllFeatures() {
        Map<String, ServiceFeatureDefinition> features = featureManager.getFeatures();
        Assertions.assertThat(features.size()).isGreaterThan(10);
    }
}

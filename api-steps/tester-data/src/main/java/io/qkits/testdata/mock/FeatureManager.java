package io.qkits.testdata.mock;


import io.qkits.testdata.mock.base.FeaturesProvider;
import io.qkits.testdata.mock.base.ServiceFeatureDefinition;
import io.qkits.testdata.mock.thirdparty.ThirdPartyServiceMapping;

import java.util.Map;
import java.util.Set;

/**
 * @author patrick
 */
public class FeatureManager {

    private FeaturesProvider provider = new FeaturesProvider();
    private Map<String, ServiceFeatureDefinition> features;

    public FeatureManager() {
        initTPFeatures();
    }


    private void initTPFeatures() {
        features = provider.getAllFeatures();
    }

    /**
     * get feature by chinese third party name or in-house service name
     *
     * @param tpName
     * @return
     */
    public Set<String> getFeaturesByTPName(String tpName) {
        String serviceName = ThirdPartyServiceMapping.getServiceNameByTPName(tpName);
        //todo: retrieve all the feature definitions
        return features.get(serviceName).getFeatures().keySet();
    }

    public void reloadFeatures() {
        //todo:put into cache if multiple nodes used
        initTPFeatures();
    }

    /**
     * get feature by service name
     *
     * @param serviceName
     * @return
     */
    public Set<String> getFeaturesByServiceName(String serviceName) {

        return features.get(serviceName).getFeatures().keySet();
    }

    public ServiceFeatureDefinition getServiceFeatureDefByServiceName(String serviceName) {

        return features.get(serviceName);
    }

    public Map<String, ServiceFeatureDefinition> getFeatures() {
        return features;
    }
}

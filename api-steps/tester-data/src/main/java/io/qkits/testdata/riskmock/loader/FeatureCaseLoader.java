package io.qkits.testdata.riskmock.loader;

import java.util.Map;

/**
 * @author patrick
 */
public interface FeatureCaseLoader {
    /**
     * Load File
     * @param path
     * @return
     */
    public Map<String, Map<String, Map<String, Object>>> loadTestCases(String path);
}

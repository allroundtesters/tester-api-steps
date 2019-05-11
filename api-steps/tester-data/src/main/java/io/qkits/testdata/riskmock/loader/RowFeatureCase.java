package io.qkits.testdata.riskmock.loader;

import lombok.Data;

/**
 * @author patrick
 */
@Data
public class RowFeature {
    private String caseId;
    private String serviceName;
    private String featureName;
    private Object value;
}

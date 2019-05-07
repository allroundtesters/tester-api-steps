package io.qkits.testdata.mock.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author patrick
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeatureDefinition {

    private String extractPath;
    private Object defaultNullValue;
    private String resultPath;
    private String possibleValues;
    private String featureType="";
    private String defaultValue;
}

package io.qkits.testdata.riskmock.base;

import lombok.*;

import java.util.Map;

/**
 * @author patrick
 * @date created on 2019-05-08
 **/
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class ServiceFeatureDefinition {
    private String serviceName;
    private Map<String,FeatureDefinition> features;
}

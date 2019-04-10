package io.qkits.common.reflections.tpmock.features;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataPath {

    private String path;
    private Object defaultNullValue;
    private String resultPath;
}
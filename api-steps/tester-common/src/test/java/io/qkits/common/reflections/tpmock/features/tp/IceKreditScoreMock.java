package io.qkits.common.reflections.tpmock.features.tp;

import io.qkits.common.reflections.tpmock.annotation.Invoker;
import io.qkits.common.reflections.tpmock.features.BaseTPEntity;
import io.qkits.common.reflections.tpmock.features.DataPath;

@Invoker(serviceName = "iceKreditScoreEntryService")
public class IceKreditScoreMock extends BaseTPEntity {
    private static final String huomou_score = "huomou_score";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(huomou_score, DataPath.builder()
                .path("$")
                .defaultNullValue("")
                .build());
    }
}

package io.qkits.common.reflections.tpmock.features.tp;

import io.qkits.common.reflections.tpmock.annotation.Invoker;
import io.qkits.common.reflections.tpmock.features.BaseTPEntity;
import io.qkits.common.reflections.tpmock.features.DataPath;

@Invoker(serviceName = "miniScoresOverdueEntryService")
public class MiniScoreMock extends BaseTPEntity {

    private static String BLACK_LIST_HIT_RESULT = "blackListHitResult";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(BLACK_LIST_HIT_RESULT, DataPath.builder()
                .path("$")
                .defaultNullValue("")
                .build());

    }
}

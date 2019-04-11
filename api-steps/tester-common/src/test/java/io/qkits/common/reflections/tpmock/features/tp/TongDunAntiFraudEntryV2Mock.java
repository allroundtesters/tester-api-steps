package io.qkits.common.reflections.tpmock.features.tp;

import io.qkits.common.reflections.tpmock.annotation.Invoker;
import io.qkits.common.reflections.tpmock.features.BaseTPEntity;
import io.qkits.common.reflections.tpmock.features.DataPath;

@Invoker(serviceName = "tongDunAntifraudEntryServiceV2")
public class TongDunAntiFraudEntryV2Mock extends BaseTPEntity {
    private static final String ANTIFRAUD_FINAL_SCORE = "td_score";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {

        dataPathMap.put(ANTIFRAUD_FINAL_SCORE, DataPath.builder().build());

    }
}

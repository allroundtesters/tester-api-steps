package io.qkits.testdata.riskmock.thirdparty.features.tp.tongdun;

import io.qkits.testdata.riskmock.base.annotation.MockEntity;
import io.qkits.testdata.riskmock.base.annotation.DataService;
import io.qkits.testdata.riskmock.base.BaseFeatureEntity;
import io.qkits.testdata.riskmock.base.FeatureDefinition;


@DataService(name = "tongDunAntifraudEntryServiceV2")
@MockEntity
public class TongDunAntiFraudEntryV2Mock extends BaseFeatureEntity {
    private static final String ANTIFRAUD_FINAL_SCORE = "td_score";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {

        dataPathMap.put(ANTIFRAUD_FINAL_SCORE, FeatureDefinition.builder().build());

    }
}

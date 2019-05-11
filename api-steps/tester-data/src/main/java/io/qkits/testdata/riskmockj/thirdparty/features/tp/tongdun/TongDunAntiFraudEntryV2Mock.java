package io.qkits.testdata.mock.thirdparty.features.tp.tongdun;

import io.qkits.testdata.mock.base.annotation.MockEntity;
import io.qkits.testdata.mock.base.annotation.DataService;
import io.qkits.testdata.mock.base.BaseFeatureEntity;
import io.qkits.testdata.mock.base.FeatureDefinition;


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

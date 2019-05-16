package io.qkits.testdata.riskmock.thirdparty.features.tp;

import io.qkits.testdata.riskmock.base.annotation.MockEntity;
import io.qkits.testdata.riskmock.base.annotation.DataService;
import io.qkits.testdata.riskmock.base.BaseFeatureEntity;
import io.qkits.testdata.riskmock.base.FeatureDefinition;


@DataService(name = "iceKreditScoreEntryService")
@MockEntity
public class IceKreditScoreMock extends BaseFeatureEntity {
    private static final String huomou_score = "huomou_score";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(huomou_score, FeatureDefinition.builder()
                .extractPath("$")
                .defaultNullValue("")
                .build());
    }
}

package io.qkits.testdata.mock.thirdparty.features.tp;

import io.qkits.testdata.mock.base.annotation.MockEntity;
import io.qkits.testdata.mock.base.annotation.DataService;
import io.qkits.testdata.mock.base.BaseFeatureEntity;
import io.qkits.testdata.mock.base.FeatureDefinition;


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

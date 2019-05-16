package io.qkits.testdata.riskmock.thirdparty.features.tp.miniscore;

import io.qkits.testdata.riskmock.base.annotation.MockEntity;
import io.qkits.testdata.riskmock.base.annotation.DataService;
import io.qkits.testdata.riskmock.base.BaseFeatureEntity;
import io.qkits.testdata.riskmock.base.FeatureDefinition;
import io.qkits.testdata.riskmock.base.FeatureTypeEnum;


@DataService(name = "miniScoresOverdueEntryService")
@MockEntity
public class MiniScoreMock extends BaseFeatureEntity {

    private static String BLACK_LIST_HIT_RESULT = "blackListHitResult";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(BLACK_LIST_HIT_RESULT, FeatureDefinition.builder()
                .possibleValues("1,2,-1")
                .defaultValue("2")
                .featureType(FeatureTypeEnum.Enum.name())
                .build());

    }
}

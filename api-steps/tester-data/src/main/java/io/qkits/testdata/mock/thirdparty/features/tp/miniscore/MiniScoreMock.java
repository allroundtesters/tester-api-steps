package io.qkits.testdata.mock.thirdparty.features.tp.miniscore;

import io.qkits.testdata.mock.base.annotation.MockEntity;
import io.qkits.testdata.mock.base.annotation.DataService;
import io.qkits.testdata.mock.base.BaseFeatureEntity;
import io.qkits.testdata.mock.base.FeatureDefinition;
import io.qkits.testdata.mock.base.FeatureTypeEnum;


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

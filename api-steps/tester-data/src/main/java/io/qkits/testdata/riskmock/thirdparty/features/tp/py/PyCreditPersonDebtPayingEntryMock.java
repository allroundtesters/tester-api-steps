package io.qkits.testdata.riskmock.thirdparty.features.tp.py;

import io.qkits.testdata.riskmock.base.annotation.MockEntity;
import io.qkits.testdata.riskmock.base.annotation.DataService;
import io.qkits.testdata.riskmock.base.BaseFeatureEntity;
import io.qkits.testdata.riskmock.base.FeatureDefinition;
import io.qkits.testdata.riskmock.base.FeatureTypeEnum;


@DataService(name = "pyCreditPersonDebtPayingEntryService")
@MockEntity
public class PyCreditPersonDebtPayingEntryMock extends BaseFeatureEntity {
    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put("unstableDebtPayingAbility", FeatureDefinition.builder()
                    .possibleValues("0,1,-1")
                .featureType(FeatureTypeEnum.Enum.name()).defaultValue("-1").build());
        dataPathMap.put("riskyDebtPayingAbility", FeatureDefinition.builder().possibleValues("0,1,-1")
                .featureType(FeatureTypeEnum.Enum.name()).defaultValue("-1").build());
        dataPathMap.put("minAmount", FeatureDefinition.builder().possibleValues("3000,50000").featureType("Range")
                .defaultValue("-1").build());
        dataPathMap.put("maxAmount", FeatureDefinition.builder().possibleValues("3000,50000").featureType("Range").build());
        dataPathMap.put("aveAmount", FeatureDefinition.builder().possibleValues("3000,50000").featureType("Range")
                .defaultValue("-1").build());
    }
}

package io.qkits.testdata.mock.thirdparty.features.tp.bits;

import io.qkits.testdata.mock.base.annotation.MockEntity;
import io.qkits.testdata.mock.base.annotation.DataService;
import io.qkits.testdata.mock.base.BaseFeatureEntity;
import io.qkits.testdata.mock.base.FeatureDefinition;
import io.qkits.testdata.mock.base.FeatureTypeEnum;


@DataService(name = "bitsLoanHistoryEntryService")
@MockEntity
public class BitsLoanHistoryEntryMock extends BaseFeatureEntity {
    private static final String QUERY_STATUS = "queryStatus";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(QUERY_STATUS, FeatureDefinition.builder()
                .possibleValues("0,1,99").defaultValue("0")
                .featureType(FeatureTypeEnum.Enum.name()).build());
    }
}

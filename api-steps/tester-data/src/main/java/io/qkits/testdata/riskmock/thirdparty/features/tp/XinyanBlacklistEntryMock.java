package io.qkits.testdata.riskmock.thirdparty.features.tp;

import io.qkits.testdata.riskmock.base.annotation.MockEntity;
import io.qkits.testdata.riskmock.base.annotation.DataService;
import io.qkits.testdata.riskmock.base.BaseFeatureEntity;
import io.qkits.testdata.riskmock.base.FeatureDefinition;
import io.qkits.testdata.riskmock.base.FeatureTypeEnum;


@DataService(name = "xinyanBlacklistEntryService")
@MockEntity
public class XinyanBlacklistEntryMock extends BaseFeatureEntity {
    private static final String CURRENTLY_OVERDUE = "xy_blacklist_currently_overdue";
    private static final String MAX_OVERDUE_DAYS = "xy_blacklist_max_overdue_days";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(CURRENTLY_OVERDUE, FeatureDefinition.builder().possibleValues("1,1000")
                .featureType(FeatureTypeEnum.Counter.name()).build());
        dataPathMap.put(MAX_OVERDUE_DAYS, FeatureDefinition.builder()
                .possibleValues("1,10000").featureType(FeatureTypeEnum.Counter.name()).build());
    }
}

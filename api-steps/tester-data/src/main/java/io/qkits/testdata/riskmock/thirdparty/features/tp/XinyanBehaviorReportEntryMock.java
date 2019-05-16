package io.qkits.testdata.riskmock.thirdparty.features.tp;

import io.qkits.testdata.riskmock.base.annotation.MockEntity;
import io.qkits.testdata.riskmock.base.annotation.DataService;
import io.qkits.testdata.riskmock.base.BaseFeatureEntity;
import io.qkits.testdata.riskmock.base.FeatureDefinition;
import io.qkits.testdata.riskmock.base.FeatureTypeEnum;


@DataService(name = "xinyanBehaviorReportEntryService")
@MockEntity
public class XinyanBehaviorReportEntryMock extends BaseFeatureEntity {
    private static final String LOAN_CNT_LAST_1MONTH = "xy_loan_cnt_lst1m";
    private static final String LOAN_CNT_LAST_3MONTH = "xy_loan_cnt_lst3m";
    private static final String DEDUCT_SUC_CNT_LAST_1MONTH = "xy_deduct_suc_cnt_lst1m";
    private static final String DEDUCT_FAIL_CNT_LAST_1MONTH = "xy_deduct_fail_cnt_lst1m";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(LOAN_CNT_LAST_1MONTH, FeatureDefinition.builder().possibleValues("1,1000").featureType(
                FeatureTypeEnum.Counter.name()
        ).build());
        dataPathMap.put(LOAN_CNT_LAST_3MONTH, FeatureDefinition.builder().possibleValues("1,1000").featureType(
                FeatureTypeEnum.Counter.name()
        ).build());
        dataPathMap.put(DEDUCT_SUC_CNT_LAST_1MONTH, FeatureDefinition.builder().possibleValues("1,1000").featureType(
                FeatureTypeEnum.Counter.name()).build());
        dataPathMap.put(DEDUCT_FAIL_CNT_LAST_1MONTH, FeatureDefinition.builder().possibleValues("1,1000").featureType(
                FeatureTypeEnum.Counter.name()).build());
    }
}

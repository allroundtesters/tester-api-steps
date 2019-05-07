package io.qkits.testdata.mock.thirdparty.features.tp.py;

import io.qkits.testdata.mock.base.annotation.MockEntity;
import io.qkits.testdata.mock.base.annotation.DataService;
import io.qkits.testdata.mock.base.BaseFeatureEntity;
import io.qkits.testdata.mock.base.FeatureDefinition;


@DataService(name = "pyCreditCourtDetailEntryService")
@MockEntity
public class PyCreditCourtEntryMock extends BaseFeatureEntity {


    private static final String SX_COURT_COUNT_KEY = "sx_court_count";
    private static final String CRIMINAL_RELATED_CHECK = "criminal_related_check";
    private static final String HIT_ENFORCEMENT_LITIGATION = "hit_enforcement_litigation";
    private static final String HIT_CIVIL_LITIGATION = "hit_civil_litigation";
    private static final String ALS_SJRQ_TIME = "als_sjrq_time";  //司法案例审结日期距今年数 eg: 2.5年
    private static final String HIT_CQS_FIX_FZR = "hit_cqs_fix_fzr";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        // 学历
        dataPathMap.put(SX_COURT_COUNT_KEY, FeatureDefinition.builder()
                .extractPath("$.degreeType")
                .defaultNullValue(-1)
                .build());

        // 婚姻状况
        dataPathMap.put(CRIMINAL_RELATED_CHECK, FeatureDefinition.builder()
                .extractPath("$.marriage")
                .defaultNullValue(-1)
                .build());

        // 在职期限
        dataPathMap.put(HIT_ENFORCEMENT_LITIGATION, FeatureDefinition.builder()
                .extractPath("$.entryDate")
                .defaultNullValue(-1)
                .build());

        // 在职状态
        dataPathMap.put(HIT_CIVIL_LITIGATION, FeatureDefinition.builder()
                .extractPath("$.onJobStatus")
                .defaultNullValue(-1)
                .build());

        dataPathMap.put(ALS_SJRQ_TIME, FeatureDefinition.builder()
                .extractPath("$.onJobStatus")
                .defaultNullValue(-1)
                .build());
        dataPathMap.put(HIT_CQS_FIX_FZR, FeatureDefinition.builder()
                .extractPath("$.onJobStatus")
                .defaultNullValue(-1)
                .build());

    }
}



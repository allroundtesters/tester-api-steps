package io.qkits.common.reflections.tpmock.features.tp;

import io.qkits.common.reflections.tpmock.annotation.Invoker;
import io.qkits.common.reflections.tpmock.features.BaseTPEntity;
import io.qkits.common.reflections.tpmock.features.DataPath;

@Invoker(serviceName = "pyCreditCourtDetailEntryService")
public class PyCreditCourtEntryMock extends BaseTPEntity {


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
        dataPathMap.put(SX_COURT_COUNT_KEY, DataPath.builder()
                .path("$.degreeType")
                .defaultNullValue(-1)
                .build());

        // 婚姻状况
        dataPathMap.put(CRIMINAL_RELATED_CHECK, DataPath.builder()
                .path("$.marriage")
                .defaultNullValue(-1)
                .build());

        // 在职期限
        dataPathMap.put(HIT_ENFORCEMENT_LITIGATION, DataPath.builder()
                .path("$.entryDate")
                .defaultNullValue(-1)
                .build());

        // 在职状态
        dataPathMap.put(HIT_CIVIL_LITIGATION, DataPath.builder()
                .path("$.onJobStatus")
                .defaultNullValue(-1)
                .build());

        dataPathMap.put(ALS_SJRQ_TIME, DataPath.builder()
                .path("$.onJobStatus")
                .defaultNullValue(-1)
                .build());
        dataPathMap.put(HIT_CQS_FIX_FZR, DataPath.builder()
                .path("$.onJobStatus")
                .defaultNullValue(-1)
                .build());

    }
}



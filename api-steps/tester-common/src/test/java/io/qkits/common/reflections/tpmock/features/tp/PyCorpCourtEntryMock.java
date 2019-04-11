package io.qkits.common.reflections.tpmock.features.tp;

import io.qkits.common.reflections.tpmock.annotation.Invoker;
import io.qkits.common.reflections.tpmock.features.BaseTPEntity;
import io.qkits.common.reflections.tpmock.features.DataPath;
@Invoker(serviceName = "pyCorpCourtService")
public class PyCorpCourtEntryMock extends BaseTPEntity {


    private static final String CORP_LIST = "corp_list";
    private static final String CORP_COUNT = "corp_count";
    private static final String HIT_CORP_LITIGATION = "hit_corp_litigation";
    private static final String HIT_ZXS_FIX = "hit_zxs_fix";
    private static final String HIT_SXS_FIX = "hit_sxs_fix";
    private static final String HIT_KTGGS_FIX = "hit_ktggs_fix";
    private static final String HIT_SPLCS_FIX = "hit_splcs_fix";
    private static final String HIT_SFGGS_FIX = "hit_sfggs_fix";
    private static final String HIT_CQS_FIX = "hit_cqs_fix";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        // 学历
        dataPathMap.put(CORP_LIST, DataPath.builder()
                .path("$.degreeType")
                .defaultNullValue(-1)
                .build());

        // 婚姻状况
        dataPathMap.put(CORP_COUNT, DataPath.builder()
                .path("$.marriage")
                .defaultNullValue(-1)
                .build());

        // 在职期限
        dataPathMap.put(HIT_CORP_LITIGATION, DataPath.builder()
                .path("$.entryDate")
                .defaultNullValue(-1)
                .build());

        // 在职状态
        dataPathMap.put(HIT_ZXS_FIX, DataPath.builder()
                .path("$.onJobStatus")
                .defaultNullValue(-1)
                .build());

        dataPathMap.put(HIT_SXS_FIX, DataPath.builder()
                .path("$.onJobStatus")
                .defaultNullValue(-1)
                .build());
        dataPathMap.put(HIT_ZXS_FIX, DataPath.builder()
                .path("$.onJobStatus")
                .defaultNullValue(-1)
                .build());
        dataPathMap.put(HIT_ZXS_FIX, DataPath.builder()
                .path("$.onJobStatus")
                .defaultNullValue(-1)
                .build());
        dataPathMap.put(HIT_KTGGS_FIX, DataPath.builder()
                .path("$.onJobStatus")
                .defaultNullValue(-1)
                .build());
        dataPathMap.put(HIT_SPLCS_FIX, DataPath.builder()
                .path("$.onJobStatus")
                .defaultNullValue(-1)
                .build());

        dataPathMap.put(HIT_SFGGS_FIX, DataPath.builder()
                .path("$.onJobStatus")
                .defaultNullValue(-1)
                .build());

        dataPathMap.put(HIT_CQS_FIX, DataPath.builder()
                .path("$.onJobStatus")
                .defaultNullValue(-1)
                .build());


    }
}



package io.qkits.common.reflections.tpmock.features.tp;

import io.qkits.common.reflections.tpmock.annotation.Invoker;
import io.qkits.common.reflections.tpmock.features.BaseTPEntity;
import io.qkits.common.reflections.tpmock.features.DataPath;

import java.util.HashMap;
import java.util.Map;

@Invoker(serviceName = "pyAntifraudEntryService")
public class PyAntifraudEntryMock extends BaseTPEntity {

    private static final String ANTIFRAUD_RISK_SCORE = "antifraud_risk_score";
    private static final String HIT_ECONNOISSEUR_LIST = "hit_econnoisseur_list";
    private static final String HIT_FRAUD_RISK_LIST = "hit_fraud_risk_list";
    private static final String RISK_SUMMARY_TOTAL_COUNT = "risk_summary_total_count";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        // 学历
        dataPathMap.put(ANTIFRAUD_RISK_SCORE, DataPath.builder()
                .path("$.degreeType")
                .defaultNullValue(-1)
                .build());

        // 婚姻状况
        dataPathMap.put(HIT_ECONNOISSEUR_LIST, DataPath.builder()
                .path("$.marriage")
                .defaultNullValue(-1)
                .build());

        // 在职期限
        dataPathMap.put(HIT_FRAUD_RISK_LIST, DataPath.builder()
                .path("$.entryDate")
                .defaultNullValue(-1)
                .build());

        // 在职状态
        dataPathMap.put(RISK_SUMMARY_TOTAL_COUNT, DataPath.builder()
                .path("$.onJobStatus")
                .defaultNullValue(-1)
                .build());

    }

    private Map<String, Object> initResultMap() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put(ANTIFRAUD_RISK_SCORE, -999);
        resultMap.put(HIT_ECONNOISSEUR_LIST, 0);
        resultMap.put(HIT_FRAUD_RISK_LIST, 0);
        resultMap.put(RISK_SUMMARY_TOTAL_COUNT, -999);
        return resultMap;
    }
}

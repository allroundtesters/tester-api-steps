package io.qkits.common.reflections.tpmock.features.tp;

import io.qkits.common.reflections.tpmock.annotation.Invoker;
import io.qkits.common.reflections.tpmock.features.BaseTPEntity;
import io.qkits.common.reflections.tpmock.features.DataPath;

@Invoker(serviceName = "xinyanBehaviorReportEntryService")
public class XinyanBehaviorReportEntryMock extends BaseTPEntity {
    private static final String LOAN_CNT_LAST_1MONTH = "xy_loan_cnt_lst1m";
    private static final String LOAN_CNT_LAST_3MONTH = "xy_loan_cnt_lst3m";
    private static final String DEDUCT_SUC_CNT_LAST_1MONTH = "xy_deduct_suc_cnt_lst1m";
    private static final String DEDUCT_FAIL_CNT_LAST_1MONTH = "xy_deduct_fail_cnt_lst1m";
    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(LOAN_CNT_LAST_1MONTH, DataPath.builder().build());
        dataPathMap.put(LOAN_CNT_LAST_3MONTH, DataPath.builder().build());
        dataPathMap.put(DEDUCT_SUC_CNT_LAST_1MONTH, DataPath.builder().build());
        dataPathMap.put(DEDUCT_FAIL_CNT_LAST_1MONTH, DataPath.builder().build());
    }
}

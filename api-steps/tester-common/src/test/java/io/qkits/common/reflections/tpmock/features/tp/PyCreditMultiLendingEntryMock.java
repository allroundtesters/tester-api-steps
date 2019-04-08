package io.qkits.common.reflections.tpmock.features.tp;

import io.qkits.common.reflections.tpmock.annotation.Invoker;
import io.qkits.common.reflections.tpmock.features.BaseTPEntity;
import io.qkits.common.reflections.tpmock.features.DataPath;

@Invoker(serviceName = "pyCreditMultiLendingEntryService")
public class PyCreditMultiLendingEntryMock extends BaseTPEntity {

    private static final String SERVICE_SOURCE_NAME = "PYCREDIT";

    private static final String SUCCESS_STATUS_CODE = "OK";

    private static final String INVOKE_STATUS_CODE = "status";

    private static final String CREDIT_TREAT_RESULT_PATH = "$.creditReportInfo.treatResult";

    private static final String OVERDUE_TREAT_RESULT_PATH = "$.overdueReportInfo.treatResult";

    private static final String TREAT_RESULT_FOR_SUCCESS = "1";

    private static final String TREAT_RESULT_FOR_NULL = "2";

    private static final String TREAT_RESULT_FOR_ERROR = "3";

    private static final String OVER_DUE_DETAILS = "overdueDetails";

    private static final String MORE_THAN_3M_QUERY_COUNT = "moreThan3MthsQueryCnt";

    private static final String UN_SETTLE_LOAN_COUNT = "unSettleLoanCnt";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put("totalQueryCnt", DataPath.builder()
                .path("$.creditReportInfo.applyMonitorInfo.totalQueryCnt")
                .resultPath(CREDIT_TREAT_RESULT_PATH)
                .defaultNullValue(0)
                .build());
        dataPathMap.put("loanOrderCnt", DataPath.builder()
                .path("$.creditReportInfo.behaviorMonitorInfo.loanOrderCnt")
                .resultPath(CREDIT_TREAT_RESULT_PATH)
                .defaultNullValue(0)
                .build());
        dataPathMap.put("loanOverdueCnt", DataPath.builder()
                .path("$.creditReportInfo.behaviorMonitorInfo.loanOverdueCnt")
                .resultPath(CREDIT_TREAT_RESULT_PATH)
                .defaultNullValue(0)
                .build());
        dataPathMap.put("orderCount", DataPath.builder()
                .path("$.overdueReportInfo.overdueStat.orderCount")
                .resultPath(OVERDUE_TREAT_RESULT_PATH)
                .defaultNullValue(0)
                .build());
        dataPathMap.put("creditLoanDur", DataPath.builder()
                .path("$.creditReportInfo.behaviorMonitorInfo.creditLoanDur")
                .resultPath(CREDIT_TREAT_RESULT_PATH)
                .defaultNullValue(0)
                .build());
        dataPathMap.put(OVER_DUE_DETAILS, DataPath.builder()
                .path("$.overdueReportInfo.overdueDetails")
                .resultPath(OVERDUE_TREAT_RESULT_PATH)
                .defaultNullValue(null)
                .build());

    }
}



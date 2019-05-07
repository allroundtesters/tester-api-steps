package io.qkits.testdata.mock.thirdparty.features.tp.py;

import com.google.common.collect.Lists;
import io.qkits.testdata.mock.base.annotation.MockEntity;
import io.qkits.testdata.mock.base.annotation.DataService;
import io.qkits.testdata.mock.base.BaseFeatureEntity;
import io.qkits.testdata.mock.base.FeatureDefinition;
import io.qkits.testdata.mock.base.FeatureTypeEnum;


import java.util.List;

@DataService(name = "pyCreditMultiLendingEntryService")
@MockEntity
public class PyCreditMultiLendingEntryMock extends BaseFeatureEntity {

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
        dataPathMap.put("totalQueryCnt", FeatureDefinition.builder()
                .possibleValues("0,1000").featureType(FeatureTypeEnum.Counter.name())
                .defaultValue("0")
                .build());
        dataPathMap.put("loanOrderCnt", FeatureDefinition.builder()
                .possibleValues("0,1000").featureType(FeatureTypeEnum.Counter.name())
                .defaultValue("0")
                .build());
        dataPathMap.put("loanOverdueCnt", FeatureDefinition.builder()
                .possibleValues("0,1000").featureType(FeatureTypeEnum.Counter.name())
                .defaultValue("0")
                .build());
        dataPathMap.put("orderCount", FeatureDefinition.builder()
                .possibleValues("0,1000").featureType(FeatureTypeEnum.Counter.name())
                .defaultValue("0")
                .build());
        dataPathMap.put("creditLoanDur", FeatureDefinition.builder()
                .possibleValues("0,1000").featureType(FeatureTypeEnum.Enum.name())
                .defaultValue("0")
                .build());
        dataPathMap.put(OVER_DUE_DETAILS, FeatureDefinition.builder()
                .possibleValues("0,1000").featureType(FeatureTypeEnum.Counter.name())
                .defaultValue("0")
                .build());
        dataPathMap.put(MORE_THAN_3M_QUERY_COUNT, FeatureDefinition.builder()
                .possibleValues("0,1000").featureType(FeatureTypeEnum.Counter.name())
                .defaultValue("0")
                .build());
        dataPathMap.put(UN_SETTLE_LOAN_COUNT, FeatureDefinition.builder()
                .possibleValues("0,1000").featureType(FeatureTypeEnum.Counter.name())
                .defaultValue("0")
                .build());
        dataPathMap.put("last6MthsQueryCnt", FeatureDefinition.builder()
                .possibleValues("0,1000").featureType(FeatureTypeEnum.Counter.name())
                .defaultValue("0")
                .build());

        List<String> features = Lists.newArrayList("queryOrgCnt", "queryOtherOrgCnt", "queryNetLoanOrgCnt");
        for (String feature : features) {
            dataPathMap.put(feature, FeatureDefinition.builder()
                    .possibleValues("0,1000").featureType(FeatureTypeEnum.Counter.name())
                    .defaultValue("0")
                    .build());
        }


    }
}



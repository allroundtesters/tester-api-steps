package io.qkits.testdata.riskmock.thirdparty.features.tp.py;


import io.qkits.testdata.riskmock.base.annotation.DataService;
import io.qkits.testdata.riskmock.base.BaseFeatureEntity;
import io.qkits.testdata.riskmock.base.FeatureDefinition;
import io.qkits.testdata.riskmock.base.FeatureTypeEnum;


import java.util.HashMap;
import java.util.Map;

@DataService(name = "pyAntifraudEntryService")
public class PyAntifraudEntryMock extends BaseFeatureEntity {

    private static final String ANTIFRAUD_RISK_SCORE = "antifraud_risk_score";
    private static final String HIT_ECONNOISSEUR_LIST = "hit_econnoisseur_list";
    private static final String HIT_FRAUD_RISK_LIST = "hit_fraud_risk_list";
    private static final String RISK_SUMMARY_TOTAL_COUNT = "risk_summary_total_count";
    private static final String OVERDUE_TOTAL_COUNT = "overdue_total_count";
    private static final String LOAN_ORG_COUNT = "loan_org_count";
    private static final String EXECUTE_COUNT = "execute_count";
    private static final String LAST_SIX_MONTHS_LOAN_COUNT = "last_6m_loan_count";
    private static Map<String, Object> resultMap = new HashMap<>();

    @Override
    protected void initStatusMap() {
        initResultMap();
    }

    @Override
    protected void initDataPath() {

        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            dataPathMap.put(entry.getKey(), FeatureDefinition.builder()
                    .possibleValues("0")
                    .featureType(FeatureTypeEnum.Counter.name()).build());
        }

    }

    private Map<String, Object> initResultMap() {
        resultMap.put(ANTIFRAUD_RISK_SCORE, -999);
        resultMap.put(HIT_ECONNOISSEUR_LIST, 0);
        resultMap.put(HIT_FRAUD_RISK_LIST, 0);
        resultMap.put(RISK_SUMMARY_TOTAL_COUNT, -999);
        resultMap.put(OVERDUE_TOTAL_COUNT, -999);
        resultMap.put(LOAN_ORG_COUNT, -999);
        resultMap.put(EXECUTE_COUNT, -999);
        resultMap.put(LAST_SIX_MONTHS_LOAN_COUNT, -999);
        return resultMap;
    }
}

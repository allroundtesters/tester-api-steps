package io.qkits.testdata.mock.thirdparty.features.tp;

import io.qkits.testdata.mock.base.annotation.MockEntity;
import io.qkits.testdata.mock.base.annotation.DataService;
import io.qkits.testdata.mock.base.BaseFeatureEntity;
import io.qkits.testdata.mock.base.FeatureDefinition;
import io.qkits.testdata.mock.base.FeatureTypeEnum;


import java.util.Map;

@DataService(name = "yfbDataAggregate")
@MockEntity
public class YfbDataAggregateMock extends BaseFeatureEntity {
    private static String LASTEST_REPAYMENT_STATUS = "lastestRepaymentStatus";
    private static String INTERVAL_DAYS = "intervalDays";
    private static String OVERDUE_DAYS = "overdueDays";
    private static String TOTAL_OVERDUE_TIMES = "totalOverdueTimes";
    private static String MAX_OVERDUE_TIMES = "maxOverdueTimes";
    private static String MAX_OVERDUE_TIMES_ABOVE_2_DAYS = "maxOverdueTimesAbove2Days";
    private static String TOTAL_OVERDUE_TIMES_ABOVE_2_DAYS = "totalOverdueTimesAbove2Days";
    private static String MAX_OVERDUE_TIMES_ABOVE_4_DAYS = "maxOverdueTimesAbove4Days";
    private static String TOTAL_OVERDUE_TIMES_ABOVE_4_DAYS = "totalOverdueTimesAbove4Days";
    private static String MAX_OVERDUE_TIMES_ABOVE_15_DAYS = "maxOverdueTimesAbove15Days";
    private static String TOTAL_OVERDUE_TIMES_ABOVE_15_DAYS = "totalOverdueTimesAbove15Days";
    private static String MAX_OVERDUE_TIMES_ABOVE_30_DAYS = "maxOverdueTimesAbove30Days";
    private static String TOTAL_OVERDUE_TIMES_ABOVE_30_DAYS = "totalOverdueTimesAbove30Days";

    @Override
    protected void initStatusMap() {
        resultMap.put(LASTEST_REPAYMENT_STATUS, -1);
        resultMap.put(INTERVAL_DAYS, -1);
        resultMap.put(OVERDUE_DAYS, 0);
        resultMap.put(TOTAL_OVERDUE_TIMES, 0);
        resultMap.put(MAX_OVERDUE_TIMES, 0);
        resultMap.put(MAX_OVERDUE_TIMES_ABOVE_2_DAYS, 0);
        resultMap.put(TOTAL_OVERDUE_TIMES_ABOVE_2_DAYS, 0);
        resultMap.put(MAX_OVERDUE_TIMES_ABOVE_4_DAYS, 0);
        resultMap.put(TOTAL_OVERDUE_TIMES_ABOVE_4_DAYS, 0);
        resultMap.put(MAX_OVERDUE_TIMES_ABOVE_15_DAYS, 0);
        resultMap.put(TOTAL_OVERDUE_TIMES_ABOVE_15_DAYS, 0);
        resultMap.put(MAX_OVERDUE_TIMES_ABOVE_30_DAYS, 0);
        resultMap.put(TOTAL_OVERDUE_TIMES_ABOVE_30_DAYS, 0);
    }

    @Override
    protected void initDataPath() {
        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            dataPathMap.put(entry.getKey(), FeatureDefinition.builder()
                    .possibleValues("0,300")
                    .featureType(FeatureTypeEnum.Counter.name()).build());
        }
        dataPathMap.put(LASTEST_REPAYMENT_STATUS, FeatureDefinition.builder()
                .possibleValues("1,2,3,4,5")
                .defaultValue("3")
                .featureType(FeatureTypeEnum.Enum.name()).build());
    }
}

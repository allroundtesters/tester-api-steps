package io.qkits.testdata.riskmock.thirdparty.features.tp;

import io.qkits.testdata.riskmock.base.annotation.MockEntity;
import io.qkits.testdata.riskmock.base.annotation.DataService;
import io.qkits.testdata.riskmock.base.BaseFeatureEntity;
import io.qkits.testdata.riskmock.base.FeatureDefinition;


import java.util.HashMap;
import java.util.Map;

@DataService(name = "reserveInternalProfileEntryService")
@MockEntity
public class ReserveInternalProfileEntryMock extends BaseFeatureEntity {

    private static final String DEGREE = "degree";
    private static final String MARRIAGE = "marriage";
    private static final String ON_JOB_MONTHS = "onJobMonths";
    private static final String ON_JOB_STATUS = "onJobStatus";
    private static final String JOB_LEVEL = "jobLevel";
    private static final int ON_THE_JOB = 1;


    @Override
    protected void initStatusMap() {
        Map<Object, Object> degreeStatusMapping = new HashMap<>();
        degreeStatusMapping.put("本科（统招）", 2);
        degreeStatusMapping.put("本科（非统招）", 2);
        degreeStatusMapping.put("硕士研究生（统招）", 3);
        degreeStatusMapping.put("专科（非统招）", 1);
        degreeStatusMapping.put("硕士研究生", 3);
        degreeStatusMapping.put("国外学历（本科）", 3);
        degreeStatusMapping.put("本科(非统招)", 2);
        degreeStatusMapping.put("本科（实习生）", 2);
        degreeStatusMapping.put("本科(统招)", 2);
        degreeStatusMapping.put("硕士研究生（非统招）", 3);
        degreeStatusMapping.put("国外学历（硕士）", 3);
        degreeStatusMapping.put("博士研究生", 3);
        degreeStatusMapping.put("专科（实习生）", 1);
        degreeStatusMapping.put("专科(统招)", 1);
        degreeStatusMapping.put("大专", 1);
        degreeStatusMapping.put("专科(实习生)", 1);
        degreeStatusMapping.put("专科（大专统招）", 1);
        degreeStatusMapping.put("国外学历(非统招)", 3);
        degreeStatusMapping.put("本科(实习生)", 2);
        degreeStatusMapping.put("本科", 2);
        degreeStatusMapping.put("硕士", 3);
        degreeStatusMapping.put("硕士研究生(非统招)", 3);
        degreeStatusMapping.put("硕士研究生(实习生)", 3);
        degreeStatusMapping.put("初中及以下", 1);
        degreeStatusMapping.put("专科", 1);
        degreeStatusMapping.put("硕士研究生(统招)", 3);
        degreeStatusMapping.put("国外学历(统招)", 3);
        degreeStatusMapping.put("本科（实习生)", 2);
        degreeStatusMapping.put("博士", 3);
        statusMap.put(DEGREE, degreeStatusMapping);

        Map<Object, Object> marriageStatusMapping = new HashMap<>();
        marriageStatusMapping.put("已婚", 1);
        marriageStatusMapping.put("未婚", 0);
        marriageStatusMapping.put("未知", -1);
        statusMap.put(MARRIAGE, marriageStatusMapping);

        Map<Object, Object> onJobStatusMapping = new HashMap<>();
        onJobStatusMapping.put("在职在岗", 1);
        onJobStatusMapping.put("离职", 0);
        onJobStatusMapping.put("未知", -1);
        statusMap.put(ON_JOB_STATUS, onJobStatusMapping);
    }

    @Override
    protected void initDataPath() {
        dataPathMap.clear();

        // 学历
        dataPathMap.put(DEGREE, FeatureDefinition.builder()
                .extractPath("$.degreeType")
                .defaultNullValue(-1)
                .build());

        // 婚姻状况
        dataPathMap.put(MARRIAGE, FeatureDefinition.builder()
                .extractPath("$.marriage")
                .defaultNullValue(-1)
                .build());

        // 在职期限
        dataPathMap.put(ON_JOB_MONTHS, FeatureDefinition.builder()
                .extractPath("$.entryDate")
                .defaultNullValue(-1)
                .build());

        // 在职状态
        dataPathMap.put(ON_JOB_STATUS, FeatureDefinition.builder()
                .extractPath("$.onJobStatus")
                .defaultNullValue(-1)
                .build());

        // 职级
        dataPathMap.put(JOB_LEVEL, FeatureDefinition.builder()
                .extractPath("$.ucJobLevelName")
                .defaultNullValue(1)
                .build());
    }


}

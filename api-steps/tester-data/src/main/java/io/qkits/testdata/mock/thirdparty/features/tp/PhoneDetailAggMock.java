package io.qkits.testdata.mock.thirdparty.features.tp;

import io.qkits.testdata.mock.base.annotation.MockEntity;
import io.qkits.testdata.mock.base.annotation.DataService;
import io.qkits.testdata.mock.base.BaseFeatureEntity;
import io.qkits.testdata.mock.base.FeatureDefinition;


import java.util.HashMap;
import java.util.Map;

@DataService(name = "jxlPhoneDetailAggregationEntryService")
@MockEntity
public class PhoneDetailAggMock extends BaseFeatureEntity {

    @Override
    protected void initStatusMap() {
    }

    @Override
    protected void initDataPath() {

        dataPathMap.put("phone_card_used_days", FeatureDefinition.builder()
                .extractPath("$")
                .defaultNullValue("")
                .build());
        dataPathMap.put("max_call_use_time_at_night_recent14days", FeatureDefinition.builder()
                .extractPath("$")
                .defaultNullValue("")
                .build());

        dataPathMap.put("callIn_dayCount_recent60days", FeatureDefinition.builder()
                .extractPath("$")
                .defaultNullValue("")
                .build());

        dataPathMap.put("callOut_phoneCount_at_night_recent180days", FeatureDefinition.builder()
                .extractPath("$")
                .defaultNullValue("")
                .build());

        dataPathMap.put("bill_percentage", FeatureDefinition.builder()
                .extractPath("$")
                .defaultNullValue("")
                .build());

    }

    private Map<String, Object> initResultMap() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("phone_card_used_days", 0);
        resultMap.put("max_call_use_time_at_night_recent14days", 0);
        resultMap.put("callIn_dayCount_recent60days", 0);
        resultMap.put("callOut_phoneCount_at_night_recent180days", 0);
        resultMap.put("bill_percentage", -999);

        return resultMap;
    }

}

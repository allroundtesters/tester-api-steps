package io.qkits.common.reflections.tpmock.features.tp;

import io.qkits.common.reflections.tpmock.annotation.Invoker;
import io.qkits.common.reflections.tpmock.features.BaseTPEntity;
import io.qkits.common.reflections.tpmock.features.DataPath;

import java.util.HashMap;
import java.util.Map;

@Invoker(serviceName = "jxlPhoneDetailAggregationEntryService")
public class PhoneDetailAggMock extends BaseTPEntity {

    protected void initStatusMap() {
    }

    protected void initDataPath() {
        dataPathMap.clear();
        dataPathMap.put("phone_card_used_days", DataPath.builder()
                .path("$")
                .defaultNullValue("")
                .build());
        dataPathMap.put("max_call_use_time_at_night_recent14days", DataPath.builder()
                .path("$")
                .defaultNullValue("")
                .build());

        dataPathMap.put("callIn_dayCount_recent60days", DataPath.builder()
                .path("$")
                .defaultNullValue("")
                .build());

        dataPathMap.put("callOut_phoneCount_at_night_recent180days", DataPath.builder()
                .path("$")
                .defaultNullValue("")
                .build());

        dataPathMap.put("bill_percentage", DataPath.builder()
                .path("$")
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

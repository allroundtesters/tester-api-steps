package io.qkits.common.reflections.tpmock.features.tp;

import io.qkits.common.reflections.tpmock.annotation.Invoker;
import io.qkits.common.reflections.tpmock.features.BaseTPEntity;
import io.qkits.common.reflections.tpmock.features.DataPath;

@Invoker(serviceName = "decorateOrderQueryService")
public class DecoratorOrderQueryMock extends BaseTPEntity {
    private static final String LAST_UPDATED_ORDER_UPDATE_TIME = "lastUpdatedOrderUpdateTime";
    private static final String LAST_UPDATED_ORDER_NO = "lastUpdatedOrderNo";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(LAST_UPDATED_ORDER_UPDATE_TIME, DataPath.builder()
                .path("$")
                .defaultNullValue("")
                .build());
        dataPathMap.put(LAST_UPDATED_ORDER_NO, DataPath.builder()
                .path("$")
                .defaultNullValue("")
                .build());
    }
}

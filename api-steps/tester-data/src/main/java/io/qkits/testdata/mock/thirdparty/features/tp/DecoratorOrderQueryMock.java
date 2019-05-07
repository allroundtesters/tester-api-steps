package io.qkits.testdata.mock.thirdparty.features.tp;

import io.qkits.testdata.mock.base.annotation.MockEntity;
import io.qkits.testdata.mock.base.annotation.DataService;
import io.qkits.testdata.mock.base.BaseFeatureEntity;
import io.qkits.testdata.mock.base.FeatureDefinition;


@DataService(name = "decorateOrderQueryService")
@MockEntity
public class DecoratorOrderQueryMock extends BaseFeatureEntity {
    private static final String LAST_UPDATED_ORDER_UPDATE_TIME = "lastUpdatedOrderUpdateTime";
    private static final String LAST_UPDATED_ORDER_NO = "lastUpdatedOrderNo";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(LAST_UPDATED_ORDER_UPDATE_TIME, FeatureDefinition.builder()
                .extractPath("$")
                .defaultNullValue("")
                .build());
        dataPathMap.put(LAST_UPDATED_ORDER_NO, FeatureDefinition.builder()
                .extractPath("$")
                .defaultNullValue("")
                .build());
    }
}

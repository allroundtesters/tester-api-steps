package io.qkits.common.reflections.tpmock.features.tp;

import io.qkits.common.reflections.tpmock.annotation.Invoker;
import io.qkits.common.reflections.tpmock.features.BaseTPEntity;
import io.qkits.common.reflections.tpmock.features.DataPath;

@Invoker(serviceName = "xinyanBlacklistEntryService")
public class XinyanBlacklistEntryMock extends BaseTPEntity {
    private static final String CURRENTLY_OVERDUE = "xy_blacklist_currently_overdue";
    private static final String MAX_OVERDUE_DAYS = "xy_blacklist_max_overdue_days";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(CURRENTLY_OVERDUE, DataPath.builder().build());
        dataPathMap.put(MAX_OVERDUE_DAYS, DataPath.builder().build());
    }
}

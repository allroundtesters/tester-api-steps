package io.qkits.common.reflections.tpmock.features.tp;

import io.qkits.common.reflections.tpmock.annotation.Invoker;
import io.qkits.common.reflections.tpmock.features.BaseTPEntity;
import io.qkits.common.reflections.tpmock.features.DataPath;

@Invoker(serviceName = "jdBlackListService")
public class JDBlacklistMock extends BaseTPEntity {
    private static final String JD_ZROBOT_BLACKLIST_ISTARGET = "jd_zrobot_blacklist_is_target";
    private static final String JD_ZROBOT_BLACKLIST_FIELD = "jd_zrobot_blacklist_field";
    private static final String JD_ZROBOT_BLACKLIST_TARGETLEVEL = "jd_zrobot_blacklist_targetlevel";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(JD_ZROBOT_BLACKLIST_ISTARGET, DataPath.builder()
                .path("$")
                .defaultNullValue("")
                .build());
        dataPathMap.put(JD_ZROBOT_BLACKLIST_FIELD, DataPath.builder()
                .path("$")
                .defaultNullValue("")
                .build());
        dataPathMap.put(JD_ZROBOT_BLACKLIST_TARGETLEVEL, DataPath.builder()
                .path("$")
                .defaultNullValue("")
                .build());
    }
}

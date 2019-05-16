package io.qkits.testdata.riskmock.thirdparty.features.tp;

import io.qkits.testdata.riskmock.base.annotation.MockEntity;
import io.qkits.testdata.riskmock.base.annotation.DataService;
import io.qkits.testdata.riskmock.base.BaseFeatureEntity;
import io.qkits.testdata.riskmock.base.FeatureDefinition;
import io.qkits.testdata.riskmock.base.FeatureTypeEnum;


@DataService(name = "jdBlackListService")
@MockEntity
public class JDBlacklistMock extends BaseFeatureEntity {
    private static final String JD_ZROBOT_BLACKLIST_ISTARGET = "jd_zrobot_blacklist_is_target";
    private static final String JD_ZROBOT_BLACKLIST_FIELD = "jd_zrobot_blacklist_field";
    private static final String JD_ZROBOT_BLACKLIST_TARGETLEVEL = "jd_zrobot_blacklist_targetlevel";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(JD_ZROBOT_BLACKLIST_ISTARGET, FeatureDefinition.builder()
                .possibleValues("0,1")
                .featureType(FeatureTypeEnum.Boolean.name()).build());

        dataPathMap.put(JD_ZROBOT_BLACKLIST_FIELD, FeatureDefinition.builder()
                .possibleValues("1,4").featureType(FeatureTypeEnum.Counter.name())
                .build());

        dataPathMap.put(JD_ZROBOT_BLACKLIST_TARGETLEVEL, FeatureDefinition.builder()
                .possibleValues("3").featureType(FeatureTypeEnum.Counter.name())
                .build());
    }
}

package io.qkits.testdata.mock.thirdparty.features.tp.py;

import io.qkits.testdata.mock.base.annotation.MockEntity;
import io.qkits.testdata.mock.base.annotation.DataService;
import io.qkits.testdata.mock.base.BaseFeatureEntity;
import io.qkits.testdata.mock.base.FeatureDefinition;
import io.qkits.testdata.mock.base.FeatureTypeEnum;


@DataService(name = "pyCorpCourtService")
@MockEntity
public class PyCorpCourtEntryMock extends BaseFeatureEntity {


    private static final String CORP_LIST = "corp_list";
    private static final String CORP_COUNT = "corp_count";
    private static final String HIT_CORP_LITIGATION = "hit_corp_litigation";
    private static final String HIT_ZXS_FIX = "hit_zxs_fix";
    private static final String HIT_SXS_FIX = "hit_sxs_fix";
    private static final String HIT_KTGGS_FIX = "hit_ktggs_fix";
    private static final String HIT_SPLCS_FIX = "hit_splcs_fix";
    private static final String HIT_SFGGS_FIX = "hit_sfggs_fix";
    private static final String HIT_CQS_FIX = "hit_cqs_fix";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(CORP_LIST, FeatureDefinition.builder().featureType(FeatureTypeEnum.LITERAL.name())
            .possibleValues("").build());

        dataPathMap.put(CORP_COUNT, FeatureDefinition.builder()
            .possibleValues("0")
            .featureType(FeatureTypeEnum.Counter.name())
            .build());

        dataPathMap.put(HIT_CORP_LITIGATION, FeatureDefinition.builder()
            .possibleValues("0")
            .featureType(FeatureTypeEnum.Counter.name())
            .build());

        dataPathMap.put(HIT_ZXS_FIX, FeatureDefinition.builder()
            .possibleValues("0")
            .featureType(FeatureTypeEnum.Counter.name())
            .build());

        dataPathMap.put(HIT_SXS_FIX, FeatureDefinition.builder()
            .possibleValues("0")
            .featureType(FeatureTypeEnum.Counter.name())
            .build());
        dataPathMap.put(HIT_ZXS_FIX, FeatureDefinition.builder()
            .possibleValues("0")
            .featureType(FeatureTypeEnum.Counter.name())
            .build());
        dataPathMap.put(HIT_ZXS_FIX, FeatureDefinition.builder()
            .possibleValues("0")
            .featureType(FeatureTypeEnum.Counter.name())
            .build());
        dataPathMap.put(HIT_KTGGS_FIX, FeatureDefinition.builder()
            .possibleValues("0")
            .featureType(FeatureTypeEnum.Counter.name())
            .build());
        dataPathMap.put(HIT_SPLCS_FIX, FeatureDefinition.builder()
            .possibleValues("0")
            .featureType(FeatureTypeEnum.Counter.name())
            .build());

        dataPathMap.put(HIT_SFGGS_FIX, FeatureDefinition.builder()
            .possibleValues("0")
            .featureType(FeatureTypeEnum.Counter.name())
            .build());

        dataPathMap.put(HIT_CQS_FIX, FeatureDefinition.builder()
            .possibleValues("0")
            .featureType(FeatureTypeEnum.Counter.name())
            .build());
    }
}



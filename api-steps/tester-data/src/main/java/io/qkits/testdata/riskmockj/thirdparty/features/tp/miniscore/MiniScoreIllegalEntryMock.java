package io.qkits.testdata.mock.thirdparty.features.tp.miniscore;

import io.qkits.testdata.mock.base.annotation.MockEntity;
import io.qkits.testdata.mock.base.annotation.DataService;
import io.qkits.testdata.mock.base.BaseFeatureEntity;
import io.qkits.testdata.mock.base.FeatureDefinition;
import io.qkits.testdata.mock.base.FeatureTypeEnum;


import java.util.Map;

@DataService(name = "miniScoresIllegalEntryService")
@MockEntity
public class MiniScoreIllegalEntryMock extends BaseFeatureEntity {

    private static final String FLAG_BAD_INFO = "flag_badinfo";
    private static final String ILLEGAL_CHECK = "illegal_check";
    private static final String FUGITIVE_CHECK = "fugitive_check";
    private static final String DRUG_RELATED_CHECK = "drug_related_check";
    private static final String DRUG_CHECK = "drug_check";

    @Override
    protected void initStatusMap() {

        initResultMap();
    }

    @Override
    protected void initDataPath() {
        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            dataPathMap.put(entry.getKey(), FeatureDefinition.builder()
                    .possibleValues("0")
                    .featureType(FeatureTypeEnum.Counter.name()).build());
        }
    }

    private Map<String, Object> initResultMap() {

        resultMap.put(ILLEGAL_CHECK, 0);
        resultMap.put(FUGITIVE_CHECK, 0);
        resultMap.put(DRUG_RELATED_CHECK, 0);
        resultMap.put(DRUG_CHECK, 0);
        resultMap.put(FLAG_BAD_INFO, 99);
        return resultMap;
    }
}

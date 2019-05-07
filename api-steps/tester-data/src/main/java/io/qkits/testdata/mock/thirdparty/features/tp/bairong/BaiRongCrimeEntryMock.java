package io.qkits.testdata.mock.thirdparty.features.tp.bairong;

import io.qkits.testdata.mock.base.annotation.MockEntity;
import io.qkits.testdata.mock.base.annotation.DataService;
import io.qkits.testdata.mock.base.BaseFeatureEntity;
import io.qkits.testdata.mock.base.FeatureDefinition;

@DataService(name = "baiRongCrimeEntryService")
@MockEntity
public class BaiRongCrimeEntryMock extends BaseFeatureEntity {

    private static final String ILLEGAL_CHECK = "illegal_check";
    private static final String FUGITIVE_CHECK = "fugitive_check";
    private static final String DRUG_RELATED_CHECK = "drug_related_check";
    private static final String DRUG_CHECK = "drug_check";
    private static final String CASE_TIME = "case_time";
    private static final String CASE_TYPE_CODE = "case_type_code";

    //0：调用成功_无数据
    //99：调用失败
    //1：调用成功_有数据
    private static final String FLAG_BAD_INFO = "flag_badinfo";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(ILLEGAL_CHECK, FeatureDefinition.builder().build());
        dataPathMap.put(FUGITIVE_CHECK, FeatureDefinition.builder().build());
        dataPathMap.put(DRUG_RELATED_CHECK, FeatureDefinition.builder().build());
        dataPathMap.put(DRUG_CHECK, FeatureDefinition.builder().build());
        dataPathMap.put(CASE_TIME, FeatureDefinition.builder().build());
        dataPathMap.put(CASE_TYPE_CODE, FeatureDefinition.builder().build());
        dataPathMap.put(FLAG_BAD_INFO, FeatureDefinition.builder().build());
    }


}

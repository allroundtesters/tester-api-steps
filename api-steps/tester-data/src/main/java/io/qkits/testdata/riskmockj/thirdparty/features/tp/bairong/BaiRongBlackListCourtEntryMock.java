package io.qkits.testdata.mock.thirdparty.features.tp.bairong;


import io.qkits.testdata.mock.base.annotation.DataService;
import io.qkits.testdata.mock.base.BaseFeatureEntity;
import io.qkits.testdata.mock.base.FeatureDefinition;

@DataService(name = "baiRongBlacklistCourtEntryService")
public class BaiRongBlackListCourtEntryMock extends BaseFeatureEntity {

    private static final String DISCREDIT_CASE_COUNT = "discredit_case_count";
    private static final String SUPREME_EXECUTING_CASE_COUNT = "supreme_executing_case_count";

    //0：调用成功_无数据
    //99：调用失败
    //1：调用成功_有数据
    private static final String FLAG_BAD_INFO = "flag_badinfo";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(DISCREDIT_CASE_COUNT, FeatureDefinition.builder().build());
        dataPathMap.put(SUPREME_EXECUTING_CASE_COUNT, FeatureDefinition.builder().build());
        dataPathMap.put(FLAG_BAD_INFO, FeatureDefinition.builder().build());
    }


}

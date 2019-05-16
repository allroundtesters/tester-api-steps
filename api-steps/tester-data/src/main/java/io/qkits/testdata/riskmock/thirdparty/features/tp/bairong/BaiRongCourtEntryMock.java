package io.qkits.testdata.riskmock.thirdparty.features.tp.bairong;


import io.qkits.testdata.riskmock.base.annotation.MockEntity;
import io.qkits.testdata.riskmock.base.annotation.DataService;
import io.qkits.testdata.riskmock.base.BaseFeatureEntity;
import io.qkits.testdata.riskmock.base.FeatureDefinition;


@DataService(name = "baiRongCourtEntryService")
@MockEntity
public class BaiRongCourtEntryMock extends BaseFeatureEntity {


    private static final String quotaKey = "quotaKey";
    private static final String loanNoClosedCnt = "loanNoClosedCnt";
    private static final String loanOrgCnt = "loanOrgCnt";

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {
        dataPathMap.put(quotaKey, FeatureDefinition.builder().possibleValues("0").build());
        dataPathMap.put(loanNoClosedCnt, FeatureDefinition.builder().possibleValues("0").build());
        dataPathMap.put(loanOrgCnt, FeatureDefinition.builder().possibleValues("0").build());
    }


}

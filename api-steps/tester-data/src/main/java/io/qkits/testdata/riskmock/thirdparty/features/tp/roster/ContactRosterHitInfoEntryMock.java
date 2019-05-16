package io.qkits.testdata.riskmock.thirdparty.features.tp.roster;
import io.qkits.testdata.riskmock.base.annotation.MockEntity;
import io.qkits.testdata.riskmock.base.annotation.DataService;
import io.qkits.testdata.riskmock.base.BaseFeatureEntity;
import io.qkits.testdata.riskmock.base.FeatureDefinition;
import io.qkits.testdata.riskmock.base.FeatureTypeEnum;


import java.util.ArrayList;
import java.util.List;

@DataService(name = "contactRosterHitInfoEntryService")
@MockEntity
public class ContactRosterHitInfoEntryMock extends BaseFeatureEntity {

    private static final String SUCCESS_STATUS_CODE = "OK";

    private static final String INVOKE_STATUS_CODE = "status";

    private static final String CONTACTS_PATH = "contacts";

    private static final String SUM_CONTACT_COUNT = "sumContactCount";

    private static final String HIT_GREY_LIST_COUNT_BY_NAME = "hitGrayListCountByName";

    private static final String HIT_BLACK_LIST_COUNT_BY_NAME = "hitBlackListCountByName";

    private static final String HIT_GREY_LIST_COUNT_BY_CELLPHONE = "hitGrayListCountByCellphone";

    private static final String HIT_BLACK_LIST_COUNT_BY_CELLPHONE = "hitBlackListCountByCellphone";

    private static final String ROSTER_SUCCESS_CODE = "0000";

    private static final String YFB_ROSTER_CODE = "yfb_contacts_roster";
    private static final List<String> featureNames = new ArrayList<>();

    static {
        featureNames.add(SUM_CONTACT_COUNT);
        featureNames.add(HIT_GREY_LIST_COUNT_BY_NAME);
        featureNames.add(HIT_BLACK_LIST_COUNT_BY_NAME);
        featureNames.add(HIT_GREY_LIST_COUNT_BY_CELLPHONE);
        featureNames.add(HIT_BLACK_LIST_COUNT_BY_CELLPHONE);
    }
    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {

        for (String featureName : featureNames) {
            dataPathMap.put(featureName, FeatureDefinition.builder()
                    .possibleValues("0")
                    .featureType(FeatureTypeEnum.Counter.name()).build());
        }

        dataPathMap.put(SUM_CONTACT_COUNT, FeatureDefinition.builder().defaultValue("100").possibleValues("0,1000")
        .featureType(FeatureTypeEnum.Counter.name()).build());


    }
}

package io.qkits.testdata.mock.thirdparty.features.tp.tongdun;

import io.qkits.testdata.mock.base.annotation.MockEntity;
import io.qkits.testdata.mock.base.annotation.DataService;
import io.qkits.testdata.mock.base.BaseFeatureEntity;
import io.qkits.testdata.mock.base.FeatureDefinition;
import io.qkits.testdata.mock.base.FeatureTypeEnum;


import java.util.Arrays;
import java.util.List;

@DataService(name = "tongDunAntifraudEntryService")
@MockEntity
public class TongDunAntiFraudEntryMock extends BaseFeatureEntity {

    private static final List<String> quotaKeys = Arrays.asList(
            "cellphone_blacklist", "ssn_blacklist", "ssn_hit_court_execute_list",
            "ssn_hit_court_credit_list", "cellphone_hit_communication_cellphone_library", "ssn_hit_overdue_list",
            "applicant_applied_loan_on_multiple_platforms_in7d", "applicant_applied_loan_on_multiple_platforms_in1m",
            "applicant_applied_loan_on_multiple_platforms_in3m", "ssn_bind_multiple_apply_info_in3m",
            "apply_info_bind_multiple_ssn_in3m", "applicant_cellphone_as_contact_phone_ge2_in3m",
            "sensitive_time_to_apply_for_1am_to_5am", "ssn_cellphone_or_platform_apply_too_many_times_in7d",
            "ssn_or_cellphone_or_device_apply_too_many_in1m", "apply_times_of_ssn_or_cellphone_ge3_in1h",
            "cellphone_rejected_ge4_times_in1m", "ssn_name_hit_court_to_implement_fuzzy_list",
            "applicant_shall_be_lent_exclude_partner_in3m", "ssn_apply_on_muli_platform_in1d",
            "ssn_apply_on_muli_platform_in7d", "ssn_apply_on_muli_platform_in1m", "apply_times_of_ssn_or_cellphone_lt3_in1h_ge5_in1d",
            "applicant_ssn_as_contact_ssn_ge2_in3m","ssn_hit_high_risk_concern_list","ssn_hit_middle_risk_concern_list","ssn_hit_low_risk_concern_list",
            "cellphone_hit_high_risk_concern_list","cellphone_hit_middle_risk_concern_list","cellphone_hit_low_risk_concern_list");

    @Override
    protected void initStatusMap() {

    }

    @Override
    protected void initDataPath() {

        for (String quotaKey : quotaKeys) {
            if(quotaKey.endsWith("list")){
                dataPathMap.put(quotaKey, FeatureDefinition.builder().possibleValues("1,0").defaultValue("0")
                        .featureType(FeatureTypeEnum.Enum.name()).build());
            }else{
                dataPathMap.put(quotaKey, FeatureDefinition.builder().possibleValues("1,1000")
                        .featureType(FeatureTypeEnum.Counter.name()).build());
            }

        }

    }
}

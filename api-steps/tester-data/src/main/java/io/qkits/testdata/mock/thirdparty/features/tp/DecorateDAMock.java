package io.qkits.testdata.mock.thirdparty.features.tp;

import io.qkits.testdata.mock.base.annotation.MockEntity;
import io.qkits.testdata.mock.base.annotation.DataService;
import io.qkits.testdata.mock.base.BaseFeatureEntity;
import io.qkits.testdata.mock.base.FeatureDefinition;


import java.util.HashMap;
import java.util.Map;

@DataService(name = "decorateDataAggregate")
@MockEntity
public class DecorateDAMock extends BaseFeatureEntity {

    @Override
    protected void initStatusMap() {
        Map<Object, Object> auditStatusMapping = new HashMap<>();
        auditStatusMapping.put(1, "5");
        auditStatusMapping.put(2, "4");
        auditStatusMapping.put(3, "1");
        auditStatusMapping.put(4, "2");
        auditStatusMapping.put(5, "3");
        statusMap.put("lastOrderTrialStatus", auditStatusMapping);

        Map<Object, Object> repayStatusMapping = new HashMap<>();
        repayStatusMapping.put(10, "1");
        repayStatusMapping.put(11, "2");
        repayStatusMapping.put(12, "2");
        repayStatusMapping.put(6, "3");
        repayStatusMapping.put(8, "3");
        repayStatusMapping.put(16, "3");
        repayStatusMapping.put(9, "1");
        repayStatusMapping.put(14, "1");
        repayStatusMapping.put(15, "1");
        statusMap.put("lastApprOrderRepayStatus", repayStatusMapping);
    }

    @Override
    protected void initDataPath() {
        dataPathMap.clear();
        // 上一笔装修订单风控审核结果
        dataPathMap.put("lastOrderTrialStatus", FeatureDefinition.builder()
                .extractPath("$.lastOrderAuditStatus")
                .defaultNullValue("")
                .build());

        // 上一笔审批通过装修订单还款情况
        dataPathMap.put("lastApprOrderRepayStatus", FeatureDefinition.builder()
                .extractPath("$.lastOrderAuditStatus")
                .defaultNullValue("")
                .build());

        // 上一笔审批通过装修订单放款金额
        dataPathMap.put("lastOrderLendAmount", FeatureDefinition.builder()
                .extractPath("$.lastApprOrderLoanAmt")
                .defaultNullValue(-1)
                .build());

        // 上一笔审批通过装修订单累计逾期天数
        dataPathMap.put("lastOrderOverdueDays", FeatureDefinition.builder()
                .extractPath("$.lastApprOrderOverdueDaysTotal")
                .defaultNullValue(-1)
                .build());

        // 最新更新装修订单订单编号
        dataPathMap.put("lastUpdatedOrderNo", FeatureDefinition.builder()
                .extractPath("$.lastestUpdateOrderCode")
                .defaultNullValue("")
                .build());

        // 最新更新装修订单更新时间
        dataPathMap.put("lastUpdatedOrderUpdateTime", FeatureDefinition.builder()
                .extractPath("$.lastestUpdateOrderUpdateTime")
                .defaultNullValue("")
                .build());
    }
}

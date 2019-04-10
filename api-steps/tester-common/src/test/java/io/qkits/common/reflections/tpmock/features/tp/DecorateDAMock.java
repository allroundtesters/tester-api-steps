package io.qkits.common.reflections.tpmock.features.tp;


import io.qkits.common.reflections.tpmock.annotation.Invoker;
import io.qkits.common.reflections.tpmock.features.BaseTPEntity;
import io.qkits.common.reflections.tpmock.features.DataPath;

import java.util.HashMap;
import java.util.Map;

@Invoker(serviceName = "decorateDataAggregate")
public class DecorateDAMock extends BaseTPEntity {


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

    protected void initDataPath() {
        dataPathMap.clear();
        // 上一笔装修订单风控审核结果
        dataPathMap.put("lastOrderTrialStatus", DataPath.builder()
                .path("$.lastOrderAuditStatus")
                .defaultNullValue("")
                .build());

        // 上一笔审批通过装修订单还款情况
        dataPathMap.put("lastApprOrderRepayStatus", DataPath.builder()
                .path("$.lastOrderAuditStatus")
                .defaultNullValue("")
                .build());

        // 上一笔审批通过装修订单放款金额
        dataPathMap.put("lastOrderLendAmount", DataPath.builder()
                .path("$.lastApprOrderLoanAmt")
                .defaultNullValue(-1)
                .build());

        // 上一笔审批通过装修订单累计逾期天数
        dataPathMap.put("lastOrderOverdueDays", DataPath.builder()
                .path("$.lastApprOrderOverdueDaysTotal")
                .defaultNullValue(-1)
                .build());

        // 最新更新装修订单订单编号
        dataPathMap.put("lastUpdatedOrderNo", DataPath.builder()
                .path("$.lastestUpdateOrderCode")
                .defaultNullValue("")
                .build());

        // 最新更新装修订单更新时间
        dataPathMap.put("lastUpdatedOrderUpdateTime", DataPath.builder()
                .path("$.lastestUpdateOrderUpdateTime")
                .defaultNullValue("")
                .build());
    }
}

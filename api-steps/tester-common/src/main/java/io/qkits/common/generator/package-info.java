package io.qkits.common.generator;

//0122:
//1）一次查重模块_借款人本人（姓名+身份证号）_借款人最近一次风控审批通过订单_还款中订单_当前逾期情况
//userType==1&&
//        Q0122_0000001.lastOrderTrialStatus==1&&
//        Q0122_0000001.lastOrderStatus==1&&
//        Q0122_0000001.lastOrderOverdueDays>30
//
//        2）一次查重模块_借款人本人（姓名+身份证号）_借款人最近一次风控审批通过订单_还款中订单_放款额度
//        userType==1&&
//        Q0122_0000001.lastOrderTrialStatus==1&&
//        Q0122_0000001.lastOrderStatus==1&&
//        Q0122_0000001.lastOrderLendAmount>=500000
//
//
//        3）一次查重模块_借款人本人（姓名+身份证号）_借款人最近一次风控审批通过订单_已结清订单_历史总逾期
//        userType==1&&
//        Q0122_0000001.lastOrderTrialStatus==1&&
//        Q0122_0000001.lastOrderStatus==2&&
//        Q0122_0000001.lastOrderOverdueDays>90
//
//
//0123:
//        装修金融_C端_用户申请进件阶段_反欺诈策略_三方数据反欺诈策略模块
//
//
//0124:
//
//        1）百融_法院被执行人_个人_借款人命中失信被执行人案件 - 直接黑名单
//
//        userType==1&&
//        Q0123_0000001.discredit_case_count>0
//        2）百融_法院被执行人_个人_借款人命中数据类型为“最高法执行”且案件状态为“执行中”的案件  - 直接黑名单
//        userType==1&&
//        Q0123_0000001.supreme_executing_case_count>0
//        3）同盾_贷前反欺诈_借款人反欺诈分值超过阈值
//
//        userType==1&&
//        Q0123_0000004.td_score>=80
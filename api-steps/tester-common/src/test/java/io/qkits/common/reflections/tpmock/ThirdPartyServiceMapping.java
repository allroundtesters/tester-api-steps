package io.qkits.common.reflections.tpmock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThirdPartyServiceMapping {
    public static enum TPProviderEnum {
        风控网关服务,同盾反欺诈查询服务,百融法院信息查询服务,冰鉴用户评分查询服务,聚信立运营商查询服务,百融违法信息查询服务,
        鹏元被执行人信息查询服务,鹏元公司诉讼信息查询服务,鹏元多头借贷信息查询服务,
        Whale贷款申请查询服务,Whale贷款放贷查询服务,Whale贷款逾期查询服务,
        京东黑名单信息查询服务,新颜负面拉黑信息查询服务,新颜行为雷达报告信息查询服务
    }

    private static Map<String,String> serviceMapping = new ConcurrentHashMap<>();
    static {
        serviceMapping.put(TPProviderEnum.风控网关服务.name(),"riskGatewayService");
        serviceMapping.put(TPProviderEnum.同盾反欺诈查询服务.name(),"tongDunAntifraudEntryService");
        serviceMapping.put(TPProviderEnum.百融法院信息查询服务.name(),"baiRongCourtEntryService");
        serviceMapping.put(TPProviderEnum.冰鉴用户评分查询服务.name(),"iceKreditScoreEntryService");
        serviceMapping.put(TPProviderEnum.聚信立运营商查询服务.name(),"jxlPhoneDetailAggregationEntryService");
        serviceMapping.put(TPProviderEnum.百融违法信息查询服务.name(),"baiRongCrimeEntryService");
        serviceMapping.put(TPProviderEnum.鹏元被执行人信息查询服务.name(),"pyCreditCourtDetailEntryService");
        serviceMapping.put(TPProviderEnum.鹏元公司诉讼信息查询服务.name(),"pyCorpCourtService");
        serviceMapping.put(TPProviderEnum.鹏元多头借贷信息查询服务.name(),"pyCreditMultiLendingEntryService");
        serviceMapping.put(TPProviderEnum.Whale贷款申请查询服务.name(),"whaleLoanApplicationEntryService");
        serviceMapping.put(TPProviderEnum.Whale贷款放贷查询服务.name(),"whaleLoanOriginationEntryService");
        serviceMapping.put(TPProviderEnum.Whale贷款逾期查询服务.name(),"whaleOverdueService");
        serviceMapping.put(TPProviderEnum.京东黑名单信息查询服务.name(),"jdBlackListService");
        serviceMapping.put(TPProviderEnum.新颜负面拉黑信息查询服务.name(),"xinyanBlacklistEntryService");
        serviceMapping.put(TPProviderEnum.新颜行为雷达报告信息查询服务.name(),"xinyanBehaviorReportEntryService");
    }

    //mapping: data: Mock Builder: service:feature: feature value/range/post: Mock Server
    //Test Case Builder
    //Expectation
    //Rule



}

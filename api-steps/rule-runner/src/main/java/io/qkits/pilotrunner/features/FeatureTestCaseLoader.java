//package io.qkits.pilotrunner.features;
//
//import lombok.Data;
//
//import java.io.IOException;
//import java.util.*;
//
//public class FeatureTestCaseLoader {
//    static int caseFromPosition = 6;
//
//    private static List<List<String>> loadExcel(String path) {
//
//        ExcelUtil util = ExcelUtil.getInstance(path);
//        return util.readAll();
//    }
//
//    public static Map<String, Map<String, Map<String, Object>>> loadTestCases(String path) throws IOException {
//
//        List<RowFeature> rowFeatures = new ArrayList<>();
//
//        List<List<String>> lines = loadExcel(path);
//        List<String> headers = lines.get(0);
//        for (List<String> line : lines.subList(1, lines.size())) {
//            for (int i = caseFromPosition; i < line.size(); i++) {
//                RowFeature feature = new RowFeature();
//                feature.serviceName = line.get(1);
//                feature.featureName = line.get(2);
//                feature.caseId = headers.get(i);
//                feature.value = line.get(i);
//                rowFeatures.add(feature);
//            }
//        }
//
//        System.out.println(rowFeatures);
//
//        //todo: caseId,serviceName,feature:value
//        Map<String, Map<String, Map<String, Object>>> caseServiceMockData =
//                new TreeMap<>();
//        for (RowFeature rawFeature : rowFeatures) {
//            if (caseServiceMockData.get(rawFeature.getCaseId()) == null) { // get ServiceData By Case Id
//                Map<String, Map<String, Object>> serviceMap = new HashMap<>();
//                Map<String, Object> mockData = createFeatureMock(rawFeature);
//                serviceMap.put(rawFeature.getServiceName(), mockData);
//                caseServiceMockData.put(rawFeature.getCaseId(),
//                        serviceMap);
//
//            } else {
//                Map<String, Map<String, Object>> serviceMap = caseServiceMockData.get(rawFeature.getCaseId());
//                Map<String, Object> mockData = serviceMap.get(rawFeature.getServiceName());
//                if (mockData == null) {
//                    mockData = createFeatureMock(rawFeature);
//                    serviceMap.put(rawFeature.getServiceName(), mockData);
//                } else {
//                    mockData.put("serviceName", rawFeature.getServiceName());
//                    mockData.put(rawFeature.getFeatureName(), rawFeature.getValue());
//                    serviceMap.put(rawFeature.getServiceName(), mockData);
//                }
//            }
//        }
////        System.out.println(caseServiceMockData);
//        return caseServiceMockData;
//    }
//
//    private static Map<String, Object> createFeatureMock(RowFeature rawFeature) {
//        Map<String, Object> mockData = new HashMap<>();
//        mockData.put("serviceName", rawFeature.getServiceName());
//        mockData.put(rawFeature.getFeatureName(), rawFeature.getValue());
//        return mockData;
//    }
//
//    @Data
//    public static class RowFeature {
//        private String caseId;
//        private String serviceName;
//        private String featureName;
//        private Object value;
//    }
//
//}

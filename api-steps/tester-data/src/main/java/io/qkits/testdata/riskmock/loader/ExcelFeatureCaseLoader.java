package io.qkits.testdata.riskmock.loader;

import cn.hutool.poi.excel.ExcelUtil;
import io.qkits.common.utils.QExcelUtils;

import java.util.*;

/**
 * @author patrick
 * @date created on 2019-05-10
 **/
public class ExcelFeatureCaseLoader implements FeatureCaseLoader {

    static int caseFromPosition = 6;

    @Override
    public Map<String, Map<String, Map<String, Object>>> loadTestCases(String path) {
        List<RowFeatureCase> rowFeatureCases = new ArrayList<>();

        List<List<String>>  lines = loadExcelFile(path);
        List<String> headers = lines.get(0);
        for (List<String> line : lines.subList(1, lines.size())) {
            for (int i = caseFromPosition; i < line.size(); i++) {
                RowFeatureCase feature = new RowFeatureCase();
                feature.setServiceName(line.get(1));
                feature.setFeatureName(line.get(2));
                feature.setCaseId(headers.get(i));
                feature.setValue(line.get(i));
                rowFeatureCases.add(feature);
            }
        }

        //todo: caseId,serviceName,feature:value
        Map<String, Map<String, Map<String, Object>>> caseServiceMockData =
            new TreeMap<>();
        for (RowFeatureCase rawFeature : rowFeatureCases) {
            // get ServiceData By Case Id
            if (caseServiceMockData.get(rawFeature.getCaseId()) == null) {
                Map<String, Map<String, Object>> serviceMap = new HashMap<>();
                Map<String, Object> mockData = createFeatureMock(rawFeature);
                serviceMap.put(rawFeature.getServiceName(), mockData);
                caseServiceMockData.put(rawFeature.getCaseId(),
                    serviceMap);

            } else {
                Map<String, Map<String, Object>> serviceMap = caseServiceMockData.get(rawFeature.getCaseId());
                Map<String, Object> mockData = serviceMap.get(rawFeature.getServiceName());
                if (mockData == null) {
                    mockData = createFeatureMock(rawFeature);
                    serviceMap.put(rawFeature.getServiceName(), mockData);
                } else {
                    mockData.put("serviceName", rawFeature.getServiceName());
                    mockData.put(rawFeature.getFeatureName(), rawFeature.getValue());
                    serviceMap.put(rawFeature.getServiceName(), mockData);
                }
            }
        }
        return caseServiceMockData;
    }

    private List<List<String>>  loadExcelFile(String path) {
        return QExcelUtils.loadExcel(path);
    }

    private Map<String, Object> createFeatureMock(RowFeatureCase rawFeature) {
        Map<String, Object> mockData = new HashMap<>(50);
        mockData.put("serviceName", rawFeature.getServiceName());
        mockData.put(rawFeature.getFeatureName(), rawFeature.getValue());
        return mockData;
    }
}

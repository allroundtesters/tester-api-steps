package io.qkits.common.utils;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class QExcelUtilsTest {

    @Test
    void excelToBean() {
    }

    @Test
    void loadExcel() {
        List<List<String>> result = QExcelUtils.loadExcel("feature_testcases.xls");
        System.out.println(result);
    }

    @Test
    void loadExcelFile() {
        List<Map<String,Object>> result = QExcelUtils.loadExcelFileToList("feature_testcases.xls");

        System.out.println(result);
    }
}

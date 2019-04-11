package io.qkits.common.dataprovider.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelHelper {

    public static <T> List<T> excelToBean(String excelPath, Class clazz) {

        return ExcelImportUtil.importExcel(new File(excelPath), clazz, new ImportParams());
    }

    public static <T>  void toExcelFile(String excelPath, Class clazz, List<T> beans) {

        File file = new File(excelPath);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), clazz, beans);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

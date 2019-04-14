package io.qkits.common.dataprovider.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
public class ExcelHelper {

    @SuppressWarnings(value = "unchecked")
    public static <T> T excelToBean(String excelPath, Class clazz){
      return (T) ExcelImportUtil.importExcel(
              new File(excelPath),
                clazz,new ImportParams());
    }


    public static <T> void beanToExcelFile(String filePath, Class clazz,
                                           List<T> entites){
        File file = new File(filePath);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(),
                clazz,entites);

        try(FileOutputStream fos = new FileOutputStream(file)){
            workbook.write(fos);
        } catch (IOException e) {
            log.error("write excel failed for {},error=",filePath,e);
        }
    }
}

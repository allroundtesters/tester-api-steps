package io.qkits.common.utils;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author patrick
 * @date created on 2019-05-07
 **/
@Slf4j
public class QExcelUtils extends ExcelUtil {

    private static final String EXCELT_XLS = ".xls";
    private static final String EXCELT_XLSX = ".xlsx";

    private QExcelUtils() {
    }

    private static final String EMPTY = "EMPTY";
    private HSSFSheet sheet;

    public static <T> List<T> excelToBean(String excelPath, Class clazz) {
        ExcelReader reader = ExcelUtil.getReader(excelPath);
        return reader.readAll(clazz);
    }

    public static QExcelUtils getInstance(String path, String sheetName) {
        QExcelUtils helper = new QExcelUtils();
        helper.sheet = helper.getSheet(path, sheetName);
        return helper;
    }

    public static QExcelUtils getInstance(String path) {
        QExcelUtils helper = new QExcelUtils();
        helper.sheet = helper.getSheet(path, "");
        return helper;
    }

    public static List<List<String>> loadExcel(String path) {

        QExcelUtils util = QExcelUtils.getInstance(path);
        return util.readAll();
    }

    public static List<Map<String,Object>> loadExcelFileToList(String excelPath){
        ExcelReader reader = ExcelUtil.getReader(excelPath);
        return reader.readAll();
    }

    /**
     * 获取excel sheet
     *
     * @param path
     * @param sheetName
     * @return HSSFSheet
     */
    private HSSFSheet getSheet(String path, String sheetName) {
        checkIfSuitableFile(path, EXCELT_XLS, EXCELT_XLSX);
        HSSFWorkbook wb;
        POIFSFileSystem fs;
        try {
            fs = new POIFSFileSystem(new File(path));
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            log.error("error_happened,e={}", e);
            throw new RuntimeException("EXCEL 文件有问题,请检查你的文件是否真的是EXCEL文件,EXCEL目前只支持2003,不支持XLSX格式,文件在:" + path);
        }

        if (StringUtils.isNotBlank(sheetName)) {
            return wb.getSheet(sheetName);
        } else {
            return wb.getSheetAt(0);
        }
    }

    public static void checkIfSuitableFile(String path, String... fileSuffix) {

        for (String s : fileSuffix) {
            if (path.endsWith(s)) {
                return;
            }
        }
        throw new RuntimeException(path + " ,File suffix is not correct,please check the file");

    }

    public List<List<String>> readAll() {
        List<List<String>> result = Lists.newArrayList();
        HSSFRow header = sheet.getRow(0);
        int cellIndex = 0;
        List<String> headerList = Lists.newArrayList();
        while (header.getCell(cellIndex) != null) {
            String cellValue = getStringCellValue(header.getCell(cellIndex));
            headerList.add(cellValue);
            cellIndex++;
        }
        result.add(headerList);

        int rowIndex = 1;
        HSSFRow currentRow = sheet.getRow(rowIndex);
        while (currentRow != null) {
            List<String> currentLine = Lists.newArrayList();
            for (int i = 0; i < headerList.size(); i++) {
                currentLine.add(getStringCellValue(currentRow.getCell(i)));
            }
            result.add(currentLine);
            currentRow = sheet.getRow(++rowIndex);
        }

        return result;

    }

    /**
     * 获取单元格数据内容为字符串类型的数据
     *
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    private String getStringCellValue(HSSFCell cell) {

        String strCell = EMPTY;
        if (cell == null) {
            return strCell;
        }

        switch (cell.getCellType()) {
            case STRING:
                strCell = cell.getStringCellValue();
                break;
            case NUMERIC:
                strCell = String.valueOf(cell.getNumericCellValue());
                break;
            case BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case BLANK:
                strCell = EMPTY;
                break;
            default:
                strCell = EMPTY;
                break;
        }
        return strCell.replaceAll("”", "\"").
            replaceAll("“", "\"").replaceAll("：", ":");
    }

    public static <T> void toExcelFile(String excelPath, Class clazz, List<T> beans) {
//        todo:
//        ExcelWriter writer = getWriter(excelPath);
//
//        File file = new File(excelPath);
//        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), clazz, beans);
//        try (FileOutputStream fos = new FileOutputStream(file)) {
//            workbook.write(fos);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}

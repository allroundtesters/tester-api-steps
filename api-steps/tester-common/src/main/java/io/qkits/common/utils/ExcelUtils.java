package io.qkits.common.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import io.qkits.common.exception.TestDataException;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author patrick
 */
@Slf4j
public class ExcelUtils {
    private static final String EXCELT_XLS = ".xls";
    private static final String EXCELT_XLSX = ".xlsx";

    private ExcelUtils() {
    }

    private static final String EMPTY = "EMPTY";
    private HSSFSheet sheet;

    public static <T> List<T> excelToBean(String excelPath, Class clazz) {

        return ExcelImportUtil.importExcel(new File(excelPath), clazz, new ImportParams());
    }

    public static <T> void toExcelFile(String excelPath, Class clazz, List<T> beans) {

        File file = new File(excelPath);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), clazz, beans);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param path      文件路径
     * @param sheetName excel sheet 名字
     * @return ExcelUtil
     */
    public static ExcelUtils getInstance(String path, String sheetName) {
        ExcelUtils helper = new ExcelUtils();
        helper.sheet = helper.getSheet(path, sheetName);
        return helper;
    }


    /**
     * @param path
     * @return
     */
    public static ExcelUtils getInstance(String path) {
        ExcelUtils helper = new ExcelUtils();
        helper.sheet = helper.getSheet(path,"");
        return helper;
    }

    public static ExcelUtils getInstance() {
        return new ExcelUtils();
    }


    /**
     * 转换excel数据到 object[],作为数据驱动入口
     *
     * @param header
     * @param data
     * @param clazzMap
     * @return Object[]
     * @throws Exception
     */
    private Object[] convertToObjectArray(List<String> header, List<String> data,
                                                Map<String, Class> clazzMap) {
        //可能的空行特殊处理
        List<String> realData = new ArrayList<>();
        for (int i = 0; i < header.size(); i++) {
            realData.add(data.get(i));
        }

        if (header.size() != realData.size()) {
            throw new RuntimeException(data
                    + " 数据不对,请检查excel文件,数据的描述头和实际的数据不匹配");
        }
        List<Object> objs = new ArrayList();

        Map<String, Object> mappedInstanceHolder
                = new HashMap<>();

        // 开始解析excel
        for (int i = 0; i < realData.size(); i++) {
            int pos = header.get(i).indexOf(".");
            String className, fieldName;
            //not run here right now
            if (pos > 0) {
                className = header.get(i).substring(0, pos);
                fieldName = header.get(i).substring(pos + 1);
                fieldName = fieldName.replaceAll("\\(", "[").replaceAll("\\)", "]");
                if (null == clazzMap.get(className)) { //no mapping class defined
                    objs.add(realData.get(i));
                }
//                else { //mapping class defined
//                    Object o = mappedInstanceHolder.get(className);
//                    if (null == o) {
//                        o = WReflection.newInstance(clazzMap.get(className));
//                        mappedInstanceHolder.put(className, o);
//                        objs.add(o);
//                    }
//                    if (StringUtils.isNotBlank(realData.get(i))) {
//                        if (EMPTY.equalsIgnoreCase(realData.get(i).trim())) {
//                            BeanUtil.setPropertyForced(o, fieldName, "");
//                        } else {
//                            BeanUtil.setPropertyForced(o, fieldName, realData.get(i).trim());
//                        }
//                    }
//                }
            } else {// no class defined
                objs.add(realData.get(i));
            }
        }
        //process after bean process
//        objs.stream().filter(obj -> obj instanceof BaseTestData).forEach(obj -> {
//            ((BaseTestData) obj).compose();
//            //add test data to thread local web test context
////            DriverFactory.getThreadLevelTestContext().addTestData((TestData)obj);
//        });
        return objs.toArray();
    }


    /**
     * Excel的第一列表述字段描述
     * 第二列开始表示数据
     * testng 数据驱动入口
     *
     * @param classMap
     * @return
     * @throws Exception
     */
    public Iterator<Object[]> toIteratorInColMode(Map<String, Class> classMap) {
        List<String> headers = buildFirstColumnAsHeader();
        Map<Integer, List<String>> allData = getColumnData();
        List<Object[]> values = Lists.newArrayList();
        for (Map.Entry<Integer, List<String>> entry : allData.entrySet()) {
            try {
                values.add(convertToObjectArray(headers, entry.getValue(), classMap));
            } catch (Exception e) {
                throw new TestDataException(e);
            }
        }
        return values.iterator();
    }

    /**
     * 获取所有的测试数据
     *
     * @return
     */
    private Map<Integer, List<String>> getColumnData() {
        int size = sheet.getRow(0).getPhysicalNumberOfCells();
        if (size == 1) throw new RuntimeException("请确保您的第一行测试数据是有数据的");
        Map<Integer, List<String>> allData = Maps.newHashMap();
        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int cellNumber = 0; cellNumber < size - 1; cellNumber++) {
            for (int rowNumber = 0; rowNumber < rowNum; rowNumber++) {
                MapUtils.put(allData, cellNumber, getCellFormatValue(sheet.getRow(rowNumber).getCell(cellNumber + 1)));
            }
        }
        return allData;
    }

    /**
     * 获取列模式下的头
     *
     * @return
     */
    private List<String> buildFirstColumnAsHeader() {
        List<String> headers = Lists.newArrayList();
        for (int rowNumber = 0; rowNumber < sheet.getPhysicalNumberOfRows(); rowNumber++) {
            try {
                if (!StringsUtils.isBlank(getStringCellValue(sheet.getRow(rowNumber).getCell(0)))) {
                    headers.add(getStringCellValue(sheet.getRow(rowNumber).getCell(0)));
                }
            } catch (Exception e) {
                //donothing to avoid null exception for some empty row existing in excel
                log.warn("可以忽略以下错误:" + e);
            }

        }
        return headers;
    }

    /**
     * 获取header
     *
     * @return
     */
    private List<String> getHeaders() {
        return getData(0);
    }

    /**
     * 读取Excel某行数据
     *
     * @param rowNum
     * @return List<String>
     */
    private List<String> getData(int rowNum) {
        HSSFRow row = sheet.getRow(rowNum);
        List<String> data = Lists.newArrayList();
        for (int i = 0; i < row.getLastCellNum(); i++) {
            data.add(getCellFormatValue(row.getCell(i)));
        }

        return data;
    }

    /**
     * 获取excel sheet
     *
     * @param path
     * @param sheetName
     * @return HSSFSheet
     */
    private HSSFSheet getSheet(String path, String sheetName) {
        FileUtils.checkIfSuitableFile(path, EXCELT_XLS, EXCELT_XLSX);
        HSSFWorkbook wb;
        POIFSFileSystem fs;
        try {
            fs = new POIFSFileSystem(new File(path));
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            log.error("error_happened,e={}",e);
            throw new RuntimeException("EXCEL 文件有问题,请检查你的文件是否真的是EXCEL文件,EXCEL目前只支持2003,不支持XLSX格式,文件在:" + path);
        }

        if (StringsUtils.isNotBlank(sheetName)) {
            return wb.getSheet(sheetName);
        } else {
            return wb.getSheetAt(0);
        }
    }


    /**
     * 获取单元格数据内容为字符串类型的数据
     *
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    private String getStringCellValue(HSSFCell cell) {

        String strCell = StringsUtils.EMPTY;
        if (cell == null) {
            return strCell;
        }
        switch (cell.getCellType()) {
            case HSSFCell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue();
                break;
            case HSSFCell.CELL_TYPE_NUMERIC:
                strCell = String.valueOf(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case HSSFCell.CELL_TYPE_BLANK:
                strCell = StringsUtils.EMPTY;
                break;
            default:
                strCell = StringsUtils.EMPTY;
                break;
        }
        return strCell.replaceAll("”", "\"").replaceAll("“", "\"").replaceAll("：", ":");
    }

    /**
     * 根据HSSFCell类型设置数据
     *
     * @param cell
     * @return
     */
    private String getCellFormatValue(HSSFCell cell) {
        if (cell == null) return StringsUtils.EMPTY;
        String cellValue = StringsUtils.EMPTY;

        if (cell.getCellType() == 0) cell.setCellType(1);
        // 判断当前Cell的Type
        switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC
            case HSSFCell.CELL_TYPE_NUMERIC:
                cellValue = String.valueOf(cell.getNumericCellValue());
                break;
            case HSSFCell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 如果是Date类型则，转化为Data格式

                    //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                    //cellvalue = cell.getDateCellValue().toLocaleString();
                    //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellValue = sdf.format(date);
                }
                // 如果是纯数字
                else {
                    // 取得当前Cell的数值
                    cellValue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            // 如果当前Cell的Type为STRIN
            case HSSFCell.CELL_TYPE_STRING:
                // 取得当前的Cell字符串
                cellValue = cell.getRichStringCellValue().getString();
                break;
            // 默认的Cell值
            case HSSFCell.CELL_TYPE_BOOLEAN:
                cellValue = cell.getBooleanCellValue() ? "true" : "false";
                break;
            default:
                cellValue = StringsUtils.EMPTY;
        }
//        return cellValue.replaceAll("”", "\"").replaceAll("“", "\"").replaceAll("：", ":");
        return cellValue;

    }


    /**
     * read all excel file to List, excel row as an element in list
     *
     * @return
     */
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
}

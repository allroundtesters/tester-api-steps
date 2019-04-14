package io.qkits.common.dataprovider.excel;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import io.qkits.common.mock.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ExcelHelperTest {

    @Test
    public void beanToExcel() throws IOException {

        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setUserName("userName"+i);
            user.setTest("A");
            users.add(user);
        }

        File file = new File("result.xls");
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(),User.class,users);
        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);
        fos.close();
    }

    @Test
    public void excelToBean(){
      List<User> result = ExcelHelper.excelToBean("result.xls",User.class);
      System.out.println(result);
    }
}
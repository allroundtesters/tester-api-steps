//package io.qkits.common.dataprovider.excel;
//
//import io.qkits.common.mock.User;
//import org.junit.Test;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public class ExcelHelperTest {
//    @Test
//    public void excelToBean(){
//        List<User> result = ExcelHelper.excelToBean("result.xls",User.class);
//        System.out.println(result);
//    }
//    @Test
//    public void beanToExcel() throws IOException {
//
//        List<User> users = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            User user = new User();
//            user.setUserName("userName"+i);
//            user.setTest("A");
//            users.add(user);
//        }
//
//        ExcelHelper.toExcelFile("result.xls",User.class,users);
//    }
//
//}
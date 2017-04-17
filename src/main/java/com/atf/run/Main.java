package com.atf.run;

import com.atf.Interface.MyInterface;
import com.atf.pageElement.ConnectExcel;
import com.atf.pageElement.DriverTest;
import com.atf.pageElement.ExcelDate;
import org.apache.xpath.operations.String;

import java.util.List;

/**
 * Created by ice on 2017/2/13.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //环境初始化，驱动浏览器
        MyInterface init = new DriverTest();
        init.InitEnvironment();
        //执行用例
        List<ExcelDate> list = ConnectExcel.getExcelData();
        for (int i = 0; i < list.size(); i++) {
            ExcelDate data = list.get(i);
            if (data.getFlag() != true) {
                init.workFlow(data);
            } else {
                init.writeResult(data.getSheetNumber());
            }
        }



    }

}

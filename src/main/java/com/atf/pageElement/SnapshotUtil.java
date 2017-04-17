package com.atf.pageElement;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

/**
 * Created by ice on 2017/2/17.
 */
public class SnapshotUtil {

    /**
     * 错误截图
     * @param drivername
     * @param data
     * @param flag
     */
    public static void getSnapshot(TakesScreenshot drivername, ExcelDate data, Boolean flag) {
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        if (flag == true) {
            ConnectExcel.writeResultToList(flag);
        } else {
            try {
                String fileName = data.getId() + "--" + TimeUtil.getCurrentDate();
                String path = NoneKeys.picturePath + "/" + fileName + ".png";
                FileUtils.copyFile(scrFile, new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                ConnectExcel.writeResultToList(flag);
            }
        }
    }

}

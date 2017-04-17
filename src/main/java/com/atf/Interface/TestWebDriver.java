package com.atf.Interface;


import com.atf.pageElement.ExcelDate;
import org.openqa.selenium.WebDriver;

/**
 * Created by ice on 2017/2/15.
 */
public interface TestWebDriver {

    void get(WebDriver webDriver, ExcelDate data);

    void click(WebDriver webDriver, ExcelDate data);

    void operateInput(WebDriver webDriver, ExcelDate data);

    void operateSelectByIndex(WebDriver webDriver, ExcelDate data);

    void operateSelectByText(WebDriver webDriver, ExcelDate data);

    void operateUploadFile(WebDriver webDriver, ExcelDate data);

    void operateJsDialogClose(WebDriver webDriver, ExcelDate data);

    void operateMouseWait(WebDriver webDriver, ExcelDate data);

    void operateWebElementExists(WebDriver webDriver, ExcelDate data);

    void operateSwitchFrameByID(WebDriver webDriver, ExcelDate data);

    void operateSwitchFrameDefault(WebDriver webDriver, ExcelDate data);

    void operateClearInput(WebDriver webDriver, ExcelDate data);
}

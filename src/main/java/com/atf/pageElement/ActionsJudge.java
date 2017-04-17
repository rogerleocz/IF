package com.atf.pageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by ice on 2017/2/17.
 */
public class ActionsJudge {

    public static String getAttributeValue(WebDriver webDriver, ExcelDate data) {

        String value = null;
        String type = "value";
        if ("id".equalsIgnoreCase(data.getOperateType())) {
            value = webDriver.findElement(By.id(data.getPropertyValue())).getAttribute(type);
        } else if ("name".equalsIgnoreCase(data.getOperateType())) {
            value = webDriver.findElement(By.name(data.getPropertyValue())).getAttribute(type);
        } else if ("xpath".equalsIgnoreCase(data.getOperateType())) {
            value = webDriver.findElement(By.xpath(data.getPropertyValue())).getAttribute(type);
        } else if ("cssSelector".equalsIgnoreCase(data.getOperateType())) {
            value = webDriver.findElement(By.cssSelector(data.getPropertyValue())).getAttribute(type);
        }
        return value;
    }

}

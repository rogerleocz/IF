package com.atf.pageElement;

import com.atf.Interface.OperateType;
import com.atf.Interface.TestWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ice on 2017/1/16.
 */
public class ActionsTest implements TestWebDriver {
/**
 * 元素操作
 */
public void get(WebDriver webDriver, ExcelDate data) {
    try {
        String expectUrl = data.getTestData();
        webDriver.get(expectUrl);
        String actualUrl = webDriver.getCurrentUrl();
        if (actualUrl.indexOf(expectUrl) >= 0) {
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagTrue);
        } else {
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
        }
    } catch (Exception e) {
        SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
        e.printStackTrace();
    }
}

    /**
     * 点击元素操作
     *
     * @param webDriver
     * @param data      测试数据
     */
    public void click(WebDriver webDriver, ExcelDate data) {

        String type = data.getOperateType();
        String value = data.getPropertyValue();
        try {
            if (type.equalsIgnoreCase(OperateType.typeID)) {
                webDriver.findElement(By.id(value)).click();
            } else if (type.equalsIgnoreCase(OperateType.typeName)) {
                webDriver.findElement(By.name(value)).click();
            } else if (type.equalsIgnoreCase(OperateType.typeXPath)) {
                webDriver.findElement(By.xpath(value)).click();
            } else if (type.equalsIgnoreCase(OperateType.typeCssSelector)) {
                webDriver.findElement(By.cssSelector(value)).click();
            }
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagTrue);
        } catch (Exception e) {
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
            e.printStackTrace();
        }
    }

    /**
     * 输入普通测试数据
     *
     * @param webDriver
     * @param data
     */
    public void operateInput(WebDriver webDriver, ExcelDate data) {

        String type = data.getOperateType();
        String value = data.getPropertyValue();
        String testData = data.getTestData();

        try {
            if (type.equalsIgnoreCase(OperateType.typeID)) {
                webDriver.findElement(By.id(value)).sendKeys(testData);
            } else if (type.equalsIgnoreCase(OperateType.typeName)) {
                webDriver.findElement(By.name(value)).sendKeys(testData);
            } else if (type.equalsIgnoreCase(OperateType.typeXPath)) {
                webDriver.findElement(By.xpath(value)).sendKeys(testData);
            } else if (type.equalsIgnoreCase(OperateType.typeCssSelector)) {
                webDriver.findElement(By.cssSelector(value)).sendKeys(testData);
            }
            if (testData.equalsIgnoreCase(ActionsJudge.getAttributeValue(webDriver, data))) {
                SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagTrue);
            } else {
                SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
            }
        } catch (Exception e) {
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
            e.printStackTrace();
        }
    }

    /**
     * 通过下拉列表的索引来选择select
     *
     * @param webDriver
     * @param data
     */
    public void operateSelectByIndex(WebDriver webDriver, ExcelDate data) {

        String type = data.getOperateType();
        String value = data.getPropertyValue();
        int index = Integer.parseInt(data.getTestData());
        Select select = null;
        try {
            if (type.equalsIgnoreCase(OperateType.typeID)) {
                select = new Select(webDriver.findElement(By.id(value)));
            } else if (type.equalsIgnoreCase(OperateType.typeName)) {
                select = new Select(webDriver.findElement(By.name(value)));
            } else if (type.equalsIgnoreCase(OperateType.typeXPath)) {
                select = new Select(webDriver.findElement(By.xpath(value)));
            } else if (type.equalsIgnoreCase(OperateType.typeCssSelector)) {
                select = new Select(webDriver.findElement(By.cssSelector(value)));
            }
            select.selectByIndex(index);
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagTrue);
        } catch (Exception e) {
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {e.printStackTrace();}
    }

    /**
     * 通过下拉列表的名称来选择select
     *
     * @param webDriver
     * @param data
     */
    public void operateSelectByText(WebDriver webDriver, ExcelDate data) {
        String type = data.getOperateType();
        String value = data.getPropertyValue();
        String text = data.getTestData();
        Select select = null;
        try {
            if (type.equalsIgnoreCase(OperateType.typeID)) {
                select = new Select(webDriver.findElement(By.id(value)));
            } else if (type.equalsIgnoreCase(OperateType.typeName)) {
                select = new Select(webDriver.findElement(By.name(value)));
            } else if (type.equalsIgnoreCase(OperateType.typeXPath)) {
                select = new Select(webDriver.findElement(By.xpath(value)));
            } else if (type.equalsIgnoreCase(OperateType.typeCssSelector)) {
                select = new Select(webDriver.findElement(By.cssSelector(value)));
            }
            select.selectByVisibleText(text);
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagTrue);
        } catch (Exception e) {
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
            e.printStackTrace();
        }
    }

    /**
     * 通过下拉列表的名称来选择select
     *
     * @param webDriver
     * @param data
     */
    public void operateUploadFile(WebDriver webDriver, ExcelDate data) {

        String type = data.getOperateType();
        String value = data.getPropertyValue();
        String filepath = data.getTestData();

        try {
            if (type.equalsIgnoreCase(OperateType.typeID)) {
                webDriver.findElement(By.id(value)).sendKeys(filepath);
            } else if (type.equalsIgnoreCase(OperateType.typeName)) {
                webDriver.findElement(By.name(value)).sendKeys(filepath);
            } else if (type.equalsIgnoreCase(OperateType.typeXPath)) {
                webDriver.findElement(By.xpath(value)).sendKeys(filepath);
            } else if (type.equalsIgnoreCase(OperateType.typeCssSelector)) {
                webDriver.findElement(By.cssSelector(value)).sendKeys(filepath);
            }
            if (filepath.equalsIgnoreCase(ActionsJudge.getAttributeValue(webDriver, data))) {
                SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagTrue);
            } else {
                SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
            }
        } catch (Exception e) {
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
            e.printStackTrace();
        }
    }

    /**
     * 点击js弹出的提示框中的确定按钮
     *
     * @param webDriver
     * @param data
     */
    public void operateJsDialogClose(WebDriver webDriver, ExcelDate data) {
        try {
            Alert alert = webDriver.switchTo().alert();
            alert.accept();
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagTrue);
        } catch (Exception e) {
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
            e.printStackTrace();
        }
    }

    /**
     * 把鼠标移动到指定的元素上面
     *
     * @param webDriver
     * @param data
     */
    public void operateMouseWait(WebDriver webDriver, ExcelDate data) {
        WebElement webElement = null;
        String type = data.getOperateType();
        String value = data.getPropertyValue();
        try {
            if (type.equalsIgnoreCase(OperateType.typeID)) {
                webElement = webDriver.findElement(By.id(value));
            } else if (type.equalsIgnoreCase(OperateType.typeName)) {
                webElement = webDriver.findElement(By.name(value));
            } else if (type.equalsIgnoreCase(OperateType.typeXPath)) {
                webElement = webDriver.findElement(By.xpath(value));
            } else if (type.equalsIgnoreCase(OperateType.typeCssSelector)) {
                webElement = webDriver.findElement(By.cssSelector(value));
            }
            Actions action = new Actions(webDriver);
            action.moveToElement(webElement).perform();
            action.release();
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagTrue);
        } catch (Exception e) {
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
            e.printStackTrace();
        }
    }

    /**
     * 检查当前页面元素存在
     *
     * @param webDriver
     * @param data
     */
    public void operateWebElementExists(WebDriver webDriver, ExcelDate data) {

        String type = data.getOperateType();
        String value = data.getPropertyValue();
        try {
            if (type.equalsIgnoreCase(OperateType.typeID)) {
                webDriver.findElement(By.id(value));
            } else if (type.equalsIgnoreCase(OperateType.typeName)) {
                webDriver.findElement(By.name(value));
            } else if (type.equalsIgnoreCase(OperateType.typeXPath)) {
                webDriver.findElement(By.xpath(value));
            } else if (type.equalsIgnoreCase(OperateType.typeCssSelector)) {
                webDriver.findElement(By.cssSelector(value));
            }
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagTrue);
        } catch (Exception e) {
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
            e.printStackTrace();
        }

    }

    /**
     * 通过ID 切换到指定frame
     *
     * @param webDriver
     * @param data
     */
    public void operateSwitchFrameByID(WebDriver webDriver, ExcelDate data) {

        String value = data.getPropertyValue();
        try {
            webDriver.switchTo().frame(value);
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagTrue);
        } catch (Exception e) {
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
            e.printStackTrace();
        }
    }

    /**
     * 切换frame 到默认状态
     *
     * @param webDriver
     * @param data
     */
    public void operateSwitchFrameDefault(WebDriver webDriver, ExcelDate data) {
        try {
            webDriver.switchTo().defaultContent();
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagTrue);
        } catch (Exception e) {
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
            e.printStackTrace();
        }
    }

    /**
     * 清空输入框的内容
     *
     * @param webDriver
     * @param data
     */
    public void operateClearInput(WebDriver webDriver, ExcelDate data) {

        String type = data.getOperateType();
        String value = data.getPropertyValue();
        String content = null;
        try {
            if (type.equalsIgnoreCase(OperateType.typeID)) {
                webDriver.findElement(By.id(value)).click();
                webDriver.findElement(By.id(value)).clear();
                content =  webDriver.findElement(By.id(value)).getAttribute("value");
            } else if (type.equalsIgnoreCase(OperateType.typeName)) {
                webDriver.findElement(By.name(value)).click();
                webDriver.findElement(By.name(value)).clear();
                content =  webDriver.findElement(By.name(value)).getAttribute("value");
            } else if (type.equalsIgnoreCase(OperateType.typeXPath)) {
                webDriver.findElement(By.xpath(value)).click();
                webDriver.findElement(By.xpath(value)).clear();
                content =  webDriver.findElement(By.xpath(value)).getAttribute("value");
            }else if (type.equalsIgnoreCase(OperateType.typeCssSelector)) {
                webDriver.findElement(By.cssSelector(value)).click();
                webDriver.findElement(By.cssSelector(value)).clear();
                content =  webDriver.findElement(By.cssSelector(value)).getAttribute("value");
            }
            if(content.length()==0){
                SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagTrue);
            }else{
                SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
            }
        } catch (Exception e) {
            SnapshotUtil.getSnapshot((TakesScreenshot) webDriver, data, NoneKeys.flagFalse);
            e.printStackTrace();
        }
    }
}


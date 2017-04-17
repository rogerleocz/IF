package com.atf.pageElement;

import com.atf.Interface.ConstantKeys;
import com.atf.Interface.TestWebDriver;
import com.atf.Interface.MyInterface;
import com.atf.Interface.OperateType;

import java.util.List;

import static com.atf.pageElement.InitBrowser.webDriver;
/**
 * Created by ice on 2017/2/15.
 */
public class DriverTest implements MyInterface {

//    private WebDriver webDriver;
    private TestWebDriver testWebDriver;

    public DriverTest() {
        testWebDriver = new ActionsTest();
    }

    public void InitEnvironment() {
        InitProcess.init(); //环境初始化
        webDriver = InitBrowser.browserinit();//驱动浏览器
        NoneKeys.resultList = null;
    }

    public void workFlow(ExcelDate data) {


        //判断是否是 打开网址
        if (data.getOperate().equalsIgnoreCase(OperateType.operateBrowserOpen)) {
            testWebDriver.get(webDriver, data);
        }

        //判断是否是 点击
        if (data.getOperate().equalsIgnoreCase(OperateType.operateClick)) {
            testWebDriver.click(webDriver, data);
        }

        // 判断是否是 输入测试数据
        if (data.getOperate().equalsIgnoreCase(OperateType.operateInput)) {
            testWebDriver.operateInput(webDriver, data);
        }

        // 判断是否是 文件上传
        if (data.getOperate().equalsIgnoreCase(OperateType.operateUploadFile)) {
            testWebDriver.operateUploadFile(webDriver, data);
        }

        // 判断是否是通过下拉列表的索引来选择
        if (data.getOperate().equalsIgnoreCase(OperateType.operateSelectByIndex)) {
            testWebDriver.operateSelectByIndex(webDriver, data);
        }

        // 判断是否是通过下拉列表的名称来选择
        if (data.getOperate().equalsIgnoreCase(OperateType.operateSelectByText)) {
            testWebDriver.operateSelectByText(webDriver, data);
        }

        // 判断是否是关闭js 提示框(既点击确定) 比如添加成功,失败
        if (data.getOperate().equalsIgnoreCase(OperateType.operateJSDialogClose)) {
            testWebDriver.operateSelectByText(webDriver, data);
        }

        // 判断是否是关闭js 提示框(既点击确定) 比如添加成功,失败
        if (data.getOperate().equalsIgnoreCase(OperateType.operateJSDialogClose)) {
            testWebDriver.operateJsDialogClose(webDriver, data);
        }

        // 判断鼠标悬停,把鼠标移动到元素上面并释放
        if (data.getOperate().equalsIgnoreCase(OperateType.operateMouseWait)) {
            testWebDriver.operateMouseWait(webDriver, data);
        }

        // 判断当前页面的元素存在
        if (data.getOperate().equalsIgnoreCase(OperateType.operateWebElementExist)) {
            testWebDriver.operateWebElementExists(webDriver, data);
        }

        // 判断是否通过ID 切换frame
        if (data.getOperate().equalsIgnoreCase(OperateType.operateSwitchFrameByID)) {
            testWebDriver.operateSwitchFrameByID(webDriver, data);
        }

        // 判断是否切换frame到默认状态
        if (data.getOperate().equalsIgnoreCase(OperateType.operateSwitchFrameDefault)) {
            testWebDriver.operateSwitchFrameDefault(webDriver, data);
        }

        // 判断是否清空输入框
        if (data.getOperate().equalsIgnoreCase(OperateType.operateClearInput)) {
            testWebDriver.operateClearInput(webDriver, data);
        }
    }

    /**
     * 写操作结果到文件
     *
     * @param sheetNumber 既case的编号
     */
    public void writeResult(int sheetNumber) {
        List<Boolean> list = NoneKeys.resultList;
        int reportValue = Integer.parseInt(new LoadProperties().getConfigByKey(ConstantKeys.ReportKey));
        try{
            if (reportValue == 1) {
                ConnectExcel.writeResult(sheetNumber, list);
            } else if (reportValue == 2 ) {
                ConnectExcel.writeResultToHtml(sheetNumber,list);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            NoneKeys.resultList = null;
        }
    }

}

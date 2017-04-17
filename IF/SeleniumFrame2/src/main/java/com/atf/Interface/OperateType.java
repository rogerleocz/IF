package com.atf.Interface;

/**
 * Created by ice on 2017/2/16.
 */
public interface OperateType {

    String operateBrowserOpen = "打开网址";
    String operateInput = "输入普通数据";
    String operateInputDate = "输入日期数据";
    String operateClearInput = "清空输入数据";
    String operateSelectByIndex = "通过序号进行下拉选择";
    String operateSelectByText = "通过名称进行下拉选择";
    String operateJSDialogClose = "提示框关闭";
    String operateUploadFile = "文件上传";
    String operateClick = "点击";
    String operateMouseWait = "鼠标悬停";
    String operateWebElementExist = "判断元素存在";
    String operateSwitchWindow = "切换窗口";
    String operateSwitchFrameByID = "通过ID切换指定IFrame";
    String operateSwitchFrameDefault = "IFrame恢复默认";
    String typeID = "ID";
    String typeName = "Name";
    String typeXPath = "XPath";
    String typeCssSelector =  "Css";
}

package com.atf.Interface;

import com.atf.pageElement.ExcelDate;

/**
 * Created by ice on 2017/2/14.
 */
public interface MyInterface {

    void InitEnvironment();

    void workFlow(ExcelDate data);

    void writeResult(int sheetNumber);
}

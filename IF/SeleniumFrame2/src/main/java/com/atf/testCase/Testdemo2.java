package com.atf.testCase;

/**
 * Created by ice on 2017/2/22.
 */
public class Testdemo2 {
    public void printBugInfo(){

        try {
            int x =100;
            int y =0;
            int z =x/y;
            System.out.println(z);
        }catch (Exception ex){
            //输入异常到标准错误流
            ex.printStackTrace();

//            //使用getMessage()方法输出异常信息
            System.out.println(ex.getMessage());
//
//            //
            System.out.println(ex.getLocalizedMessage());
//
//            //
            System.out.println(ex.toString());

        }

    }

    public static void main(String[] args) {
        Testdemo2 testdemo2 = new Testdemo2();
        testdemo2.printBugInfo();
    }
}

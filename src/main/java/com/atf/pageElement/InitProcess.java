package com.atf.pageElement;

import com.atf.Interface.ConstantKeys;

/**
 * Created by ice on 2017/2/13.
 */
public class InitProcess {

    /**
     * 初始化环境杀进程关掉浏览器等等
     * 在指定的目录下创建错误图片存放的文件夹
     */

        public static  void init() {

            //获取配置文件中初始化的值
            String initConfig = new LoadProperties().getConfigByKey(ConstantKeys.InitEnvKey);
            //上边的值与true对比
            if (initConfig.equalsIgnoreCase("true")) {
                try {
                    //清理进程，关闭浏览器
                    Runtime.getRuntime().exec("taskkill /f /t /im chrome.exe");
                    Runtime.getRuntime().exec("taskkill /f /t /im iexplore.exe");
//                    Runtime.getRuntime().exec("taskkill /f /t /im firefox.exe");
                    Runtime.getRuntime().exec("taskkill /f /t /im chromedriver.exe");
                    Runtime.getRuntime().exec("taskkill /f /t /im IEDriverServer.exe");
                    Runtime.getRuntime().exec("taskkill /f /t /im geckodriver.exe");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


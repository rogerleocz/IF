package com.atf.pageElement;

import com.atf.Interface.ConstantKeys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by ice on 2017/2/13.
 */
public class InitBrowser {

    public static WebDriver webDriver = null;


    public static WebDriver browserinit() {

        /**
         *驱动浏览器设置
         */

        int initConfig = Integer.parseInt(new LoadProperties().getConfigByKey(ConstantKeys.BrowserKey));

        //这段代码意义不明
        if (webDriver != null) {
            return webDriver;
        }
        if (initConfig == 1) {
            //设置Firefox 驱动
            System.setProperty("webdriver.gecko.driver", "G:\\study soft\\drivers\\geckodriver.exe");
            webDriver = new FirefoxDriver();
        } else if (initConfig == 2) {
            //设置Chrome 驱动
            System.setProperty("webdriver.chrome.driver", "G:\\study soft\\drivers\\chromedriver.exe");
            webDriver = new ChromeDriver();
        } else if (initConfig == 3) {
            //设置IE 驱动
            System.setProperty("webdriver.ie.driver", "G:\\study soft\\drivers\\IEDriverServer.exe");
            webDriver = new InternetExplorerDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return webDriver;

    }

}

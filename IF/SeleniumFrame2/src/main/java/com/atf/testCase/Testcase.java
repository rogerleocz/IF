package com.atf.testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Set;

import static com.atf.pageElement.InitBrowser.webDriver;

/**
 * Created by ice on 2017/2/20.
 */
public class Testcase {

    Actions actions = new Actions(webDriver);
    String baidu = "https://www.baidu.com/";
    String email = "http://mail.163.com/";

    public void do1(){

        /**
         * 京东首页，电脑-笔记本
         */

        webDriver.get("http://www.jd.com");
        WebElement webElement = webDriver.findElement(By.cssSelector("[href*=diannao]"));

        if(webElement.isDisplayed()){
            System.out.println("found it!");
            actions.moveToElement(webElement).build().perform();
            webDriver.findElement(By.cssSelector(".cate_detail_con_lk[href*=\"671,672\"]")).click();
        }else{
            System.out.println("nothing");
        }

    }

    public void do2(){

        /**
         * 返回信息
         */
        webDriver.get("http://www.baidu.com");
        System.out.println(webDriver.findElement(By.cssSelector("#kw")).getAttribute("type"));

    }

    public void do3(){

        /**
         * 鼠标右键
         */

        webDriver.get("https://www.baidu.com");
        actions.contextClick(webDriver.findElement(By.cssSelector("#kw"))).perform();

    }

    public void do4(){
        /**
         * 模拟键盘操作
         */
        webDriver.get("https://www.baidu.com/");
        webDriver.findElement(By.cssSelector("#kw")).sendKeys("selenium");
        webDriver.findElement(By.cssSelector("#kw")).sendKeys(Keys.CONTROL,"a");
        webDriver.findElement(By.cssSelector("#kw")).sendKeys(Keys.CONTROL,"x");
        webDriver.findElement(By.cssSelector("#kw")).sendKeys(Keys.CONTROL,"v");

    }

    public void do5() throws InterruptedException {


        /**
         * 用数组获取页面信息，并选择打印
         */
        webDriver.get("https://www.baidu.com/");
        webDriver.findElement(By.cssSelector("#kw")).sendKeys("selenium");
        webDriver.findElement(By.cssSelector("#kw")).submit();
        Thread.sleep(2000);
        List<WebElement> result1 = webDriver.findElements(By.xpath("//div/div/h3"));
        System.out.println(result1.size());

        for (WebElement result: result1){
            System.out.println(result.getText());
        }
        System.out.println("---------------------------------------");
        System.out.println(result1.get(result1.size()-1).getText());

    }

    public void do6(){
        webDriver.get(email);
        webDriver.switchTo().frame(webDriver.findElement(By.cssSelector("#x-URS-iframe")));
        webDriver.findElement(By.cssSelector("[name=email]")).sendKeys("rogerleocz");
        webDriver.findElement(By.cssSelector("[name=password]")).sendKeys("rogerleo220513");
        webDriver.findElement(By.cssSelector("#dologin")).click();
        webDriver.switchTo().defaultContent();

        //验证码获取



    }//验证码获取未做完（图片）

    public void do7() throws InterruptedException {

    webDriver.get(baidu);
    String search_handle = webDriver.getWindowHandle();
    Thread.sleep(3000);
    webDriver.findElement(By.cssSelector("#u1 > a:nth-child(7)")).click();
    //获取所有句柄
        Set<String> handles = webDriver.getWindowHandles();

        for (String handle : handles){
            if (handle.equalsIgnoreCase(search_handle)==false){
                webDriver.switchTo().window(handle);
                System.out.println("Now register Windows");

                Thread.sleep(2000);
                webDriver.findElement(By.cssSelector("[name=userName")).sendKeys("userName");
                webDriver.findElement(By.cssSelector("[name=phone")).sendKeys("10010");
                Thread.sleep(2000);

            }
        }

    }

    public void do8(){

        webDriver.get("file:///C:/Users/roger/Desktop/log.htm");
        WebElement webElement = webDriver.findElement(By.xpath("//div[1]/div/button"));
        if(webElement.isDisplayed()){
            System.out.println("found it!");
//            actions.moveToElement(webElement).build().perform();
            webDriver.findElement(By.xpath("//div[1]/div/button")).click();
        }else{
            System.out.println("nothing");
        }


    }


}

package com.soft.day03;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JsTest {
    WebDriver driver;
    @BeforeMethod
    public void OpenChrome(){
        //设置浏览器的地址
        System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        //打开浏览器
         driver = new ChromeDriver();


    }

    /*
    * 在百度的输入栏输入value值
     */
    @Test
    public void JsTest() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //把driver转化成JavascriptExecutor类型
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //执行js
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"执行js\")");
        //停留时间
        Thread.sleep(3000);

    }
    @AfterMethod
    public void Closs(){
        driver.quit();
    }
}

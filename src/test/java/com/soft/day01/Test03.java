package com.soft.day01;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test03 {

    @Test
    public void OpenChrome() throws InterruptedException {
        //设置谷歌浏览器路径
        System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        //打开浏览器
        WebDriver driver = new ChromeDriver();
        //打开百度浏览器
        driver.get("https://www.baidu.com");
        //设置停留时间
        Thread.sleep(5000);
        //设置浏览器大小
        Dimension dimension = new Dimension(600,400);
        driver.manage().window().setSize(dimension);
        //设置停留时间
        Thread.sleep(5000);
        //设置浏览器最大
        driver.manage().window().maximize();
        //设置停留时间
        Thread.sleep(5000);
        //刷新
        driver.navigate().refresh();
        //设置停留的时间
        Thread.sleep(5000);
        //后退
        driver.navigate().back();
        //设置停留的时间
        Thread.sleep(5000);
        //前进
        driver.navigate().forward();
        //设置停留的时间
        Thread.sleep(5000);
        //获取当前浏览器的url
        driver.getCurrentUrl();
        //设置停留时间
        Thread.sleep(5000);
       //退出，关闭浏览器
        driver.quit();

    }

}

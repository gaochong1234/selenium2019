package com.soft.day01;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test02 {
    @Test
    public void OpenChrome02() throws InterruptedException {
        //设置浏览器的路径
        System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        //打开火狐浏览器
        WebDriver webDriver03 = new ChromeDriver();
        //打开地址
        webDriver03.get("http//www.baidu.com");
        //设置等待时间
        Thread.sleep(5000);
        //设置浏览器大小
        //  Dimension dimension = new Dimension(700,700);
        // webDriver03.manage().window().setSize(dimension);
        //设置等待时间
        // Thread.sleep(5000);
        //使浏览器最大化
        webDriver03.manage().window().maximize();
        //设置等待时间
        Thread.sleep(300);
        //后退
        webDriver03.navigate().back();
        //设置等待时间
        Thread.sleep(300);
        //前进
        webDriver03.navigate().forward();
        //设置等待时间
        Thread.sleep(200);
        //刷新浏览器
        webDriver03.navigate().refresh();
        //退出
        webDriver03.quit();
    }

}

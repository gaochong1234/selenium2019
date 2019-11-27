package com.soft.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class mailresgit {
    /*
     * 注册邮箱
     * 打开Chrome浏览器，登录mail.163.com邮箱
     * 点击注册新账号，进行注册
     */
 WebDriver driver;

    @BeforeMethod
    public void OpenChrome() {
        //设置浏览器的地址
      //  System.setProperty("webdriver.chrome.driver", "D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        //打开浏览器
        System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //使浏览器最大化
        driver.manage().window().maximize();
    }

    @Test
    public void Regit() throws InterruptedException {
        //登录mail.163.com邮箱
        driver.get("https://mail.163.com");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
      //点击注册新账号的链接，先定位到这个元素
        driver.findElement(By.xpath("//*[@id=\"commonOperation\"]/a[2]")).click();
        //创建handle实例判断当前页
        String handle = driver.getWindowHandle();
        //判断handle是否在注册页
        for (String handles: driver.getWindowHandles()){
            if (handles.equals(handle)) {
                continue;
            }else {
                driver.switchTo().window(handles);
            }
        }
        //定位邮箱
        driver.findElement(By.id("nameIpt")).sendKeys("gc12335665556");
        //定位密码并输入
        driver.findElement(By.id("mainPwdIpt")).sendKeys("112223333 ");
        //定位确认密码并输入
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("112223333");
        //定位验证码并输入,验证码随意输
        driver.findElement(By.id("vcodeIpt")).sendKeys("kjjll");
        //定位手机号码并输入
        driver.findElement(By.id("mainMobileIpt")).sendKeys("13215115535");
        Thread.sleep(3000);
        //定位同意服务条例
        driver.findElement(By.id("mainAcceptIpt")).click();
        //定位立即注册按钮
        driver.findElement(By.id("mainRegA")).click();

    }

}

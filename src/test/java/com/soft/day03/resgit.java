package com.soft.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 * 注册邮箱
 * 打开Chrome浏览器，登录mail.163.com邮箱
 * 点击注册新账号，进行注册
 */
public class resgit {
    WebDriver webDriver;
    @BeforeMethod
    public void OpenChrom(){
        System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
        //设置浏览器最大化
        webDriver.manage().window().maximize();
    }
    @Test
    public void reg(){
        //打开163邮箱
        webDriver.get("https://mail.163.com");
        //定位注册新账号元素，点击
        webDriver.findElement(By.xpath("//*[@id=\"commonOperation\"]/a[2]")).click();
        //判断在哪个页面，并把driver交给Handle
        String handle = webDriver.getWindowHandle();
        for (String handles : webDriver.getWindowHandles()){
            if (handles.equals(handle)){
                continue;
            }else{
                webDriver.switchTo().window(handles);
            }
        }
        //定位邮件地址的文本框并输入账号
        webDriver.findElement(By.id("nameIpt")).sendKeys("gcw123456789");
        //定位密码文本框并输入密码
        webDriver.findElement(By.id("mainPwdIpt")).sendKeys("123456789");
        //定位确认密码文本框并输入密码
        webDriver.findElement(By.id("mainCfmPwdIpt")).sendKeys("123456789");
        //定位验证码元素输入jkjh
        webDriver.findElement(By.id("vcodeIpt")).sendKeys("jkjh");

        //定位手机号码文本框并输入1531355682
        webDriver.findElement(By.id("mainMobileIpt")).sendKeys("1526720145");
        //定位同意单选框并打钩
        webDriver.findElement(By.id("mainAcceptIpt")).click();
        webDriver.findElement(By.id("mainRegA")).click();
        //设置一个全局等待
        WebDriverWait wait = new WebDriverWait(webDriver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"m_mainMobile\"]/span")));
        String err = webDriver.findElement(By.xpath("//*[@id=\"m_mainMobile\"]/span")).getText();
        Assert.assertEquals(err,"  请填写正确的手机号");
    }
}

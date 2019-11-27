package com.soft.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class youxiang {
    WebDriver driver;
    @BeforeTest
    public void OpenChrom(){
        //设置driver的地址
        System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        //创建实例
        driver = new ChromeDriver();
        //设置浏览器为最大值
        driver.manage().window().maximize();
        //打开测试的地址
        driver.get("https://mail.163.com/index_alternate.htm");
    }
    /*
    * 登录邮箱
     */
    @BeforeMethod
    public void DengLu(){
        //把driver转交给iframe
        //driver.switchTo().frame();
        //把元素定位到邮箱账号登录
        driver.findElement(By.id("lbNormal")).click();
        //定位账号并输入
        driver.findElement(By.id("idInput")).sendKeys("gc15189837170");
        //定位密码并输入
        driver.findElement(By.id("pwdInput")).sendKeys("15189837170");
        //定位登录按钮并点击
        driver.findElement(By.id("loginBtn")).click();
    }
    @Test
    public void YouX(){
        //定位写信并点击
        driver.findElement(By.xpath(".//*[@id='_mail_component_24_24']/span[2]")).click();
        //定位收件人并写入
        driver.findElement(By.xpath(".//*[@aria-label=\"收件人地址输入框，请输入邮件地址，多人时地址请以分号隔开\"]")).sendKeys("gc456@163.com");
        //定位主题
        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("cesehi");
        //定位添加附件按钮并穿上次的地址
       driver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input")).sendKeys("C:\\Users\\Administrator\\Desktop\\测试上次.txt");
        //定位iframe
        WebElement el = driver.findElement(By.className("APP-editor-iframe"));
        //把driver的控制权交给iframe
        driver.switchTo().frame(el);
        driver.findElement(By.xpath("/html/body")).sendKeys("测试邮件");
         //把driver的控制权叫回来
        driver.switchTo().defaultContent();
        //定位发送按钮并点击
        driver.findElement(By.xpath(".//*[text()='发送']")).click();
        //校验是否发送成功
      // Boolean ELS = driver.findElement(By.xpath("//*[text()=\"发送成功\"]")).isDisplayed();
       //Assert.assertTrue(ELS);
    }


}


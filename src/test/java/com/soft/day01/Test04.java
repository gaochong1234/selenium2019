package com.soft.day01;


import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Test04 {
    WebDriver drive;
    @BeforeMethod
    public void OpenChorme(){
        //设置谷歌浏览器的路径
        System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        drive= new ChromeDriver();
    }
    @Test
    public void Oprnbaidu(){
        //打开百度
        drive.get("https://www.baidu.com");
      //  drive.findElement(By.id("kw"));
       // drive.findElement(By. ("新闻"));
        drive.findElement(By.partialLinkText("新"));
    }
    @AfterMethod
    public void quit(){
        drive.quit();
    }

}

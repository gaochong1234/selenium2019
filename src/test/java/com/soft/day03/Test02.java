package com.soft.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test02 {
    WebDriver driver;
    @BeforeMethod
    public void OpenChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
         driver = new ChromeDriver();
    }
    @Test
    public void IsSelect(){
        driver.get("file:///D:/BaiduNetdiskDownload/selenium_html/index.html");
        driver.findElement(By.className("Volvo")).isSelected();
    }
}

package com.soft.day04;

/*
* 登录QQ邮箱，验证是否有退出按钮
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class denglu {
    WebDriver driver;
    @BeforeMethod
    public void OpenChrome(){
        System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.qq.com");
    }
    @Test
    public void dengl()throws InterruptedException{
        driver.switchTo().frame("login_frame");
        driver.findElement(By.xpath("//*[@id=\"u\"]")).sendKeys("gc15189837170");
        driver.findElement(By.id("p")).sendKeys("15189837170");
        driver.findElement(By.id("p_low_login_enable")).click();
        driver.findElement(By.id("login_button")).click();
        //driver.switchTo().defaultContent();
        Thread.sleep(3000);
    }
    @Test
    public static void FengZ(WebDriver driver,String name,String pwd){
        driver.switchTo().frame("login_frame");
        driver.findElement(By.id("u")).sendKeys(name);
        driver.findElement(By.id("p")).sendKeys(pwd);
        driver.findElement(By.id("login_button")).click();
    }
    @Test
    public void dd(){
        FengZ(driver,"870235832","gh521521gc");
    }
}

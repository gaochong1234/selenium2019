package com.soft.day04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
*邮箱登录
 */
public class denglu01 {
    WebDriver driver;
    @BeforeMethod
    public void OpenChrome(){
        //设置浏览器地址
        System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        //创建浏览器实例
        driver = new ChromeDriver();
        driver.get("https://mail.163.com/index_alternate.htm");
        //浏览器放大
        driver.manage().window().maximize();
    }
    @Test
    public void YouXiang(WebDriver driver, String zhanghao,String pwd){
        //把driver转交给iframe
        //driver.switchTo().frame("loginjustnowiframe");
        //点击邮箱账号登录
        driver.findElement(By.id("lbNormal")).click();
        //定位账号
        driver.findElement(By.id("idInput")).sendKeys(zhanghao);
        //定位密码
        driver.findElement(By.id("pwdInput")).sendKeys(pwd);
        driver.findElement(By.id("loginBtn")).click();
    }
    @Test
    public void test(){
        YouXiang(driver,"gc15189837170","15189837170");
    }

}

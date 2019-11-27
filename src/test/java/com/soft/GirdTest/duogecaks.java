package com.soft.GirdTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class duogecaks {
    WebDriver driver;
    @BeforeMethod
    public void OpenChrome(){
        //设置浏览器地址
        System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        //打开浏览器
        this.driver = new ChromeDriver();
        this.driver.get("https://mail.163.com/index_alternate.htm");
        this.driver.manage().window().maximize();

    }
    @Test
    public void denglu(WebDriver driver, String user, String pwd){
        driver.findElement(By.id("idInput")).sendKeys(user);
        driver.findElement(By.id("pwdInput")).sendKeys(pwd);
        driver.findElement(By.id("loginBtn")).click();
    }

    @DataProvider(name = "date4")
    public Object[][] test(){
        return new Object[][]{
                {"user01","123456"},
                {"user02","1234"}
        };
        }

    @Test(dataProvider = "date4")
    public void tes(String user,String pwd){
        denglu(driver,user,pwd);

    }
}

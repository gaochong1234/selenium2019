package com.soft.day02;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test03 {
    //全局变量
    WebDriver driver01;
    @BeforeMethod
    public void OpenChorme(){
        //设置谷歌浏览器地址
        System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        //打开浏览器
        driver01 = new ChromeDriver();
    }
    /*
    *  打开测试界面
    *  点击百度链接
     */
    @Test
    public void BaiDuL() throws InterruptedException {
        //打开测试界面
        driver01.get("file:///D:/BaiduNetdiskDownload/selenium_html/index.html");
        //转交给ifram
        //driver01.switchTo().frame("aa");
        //通过元素定位
        WebElement iframe = driver01.findElement(By.tagName("iframe"));
        driver01.switchTo().frame(iframe);
        //通过class的属性来定位
        driver01.findElement(By.className("baidu")).click();
        //定位百度链接的元素
       // driver01.findElement(By.linkText("baidu")).click();
        Thread.sleep(3000);
    }
    /*
    * 打开我们的测试界面
    * 下拉框选择vivo
    * 第二次选择华为
    * 第三选择iPhone
     */
    @Test
    public void SelectK() throws InterruptedException {
        //打开测试界面
        driver01.get(" file:///D:/BaiduNetdiskDownload/selenium_html/index.html");
        //点击测试选择按钮
       WebElement select01 =  driver01.findElement(By.id("moreSelect"));
        Select select02 = new Select(select01);
        Thread.sleep(3000);
        select02.selectByIndex(2);
        Thread.sleep(3000);
        select02.selectByValue("huawei");
        Thread.sleep(3000);
        select02.selectByVisibleText("iphone");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void Closs(){
        driver01.quit();
    }
}

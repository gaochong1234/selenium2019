package com.soft.day02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test02 {
    /*
    * 打开谷歌浏览器
     */
    //属性全局变量
    WebDriver driver;
    WebDriver webDriver;
    @BeforeMethod
    public void OpenChrome(){
        //设置谷歌浏览器的地址
      System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        //打开谷歌浏览器
        driver = new ChromeDriver();
    }
    /*
     打开百度首页
     判断百度一下是否展示，展示的结果为true
     */
    @Test
    public void IsDispayed(){
        //打开百度首页
        driver.get("https://www.baidu.com");
        //定位百度一下的元素，看百度一下的按钮是否展示
        boolean zhanshi = driver.findElement(By.id("su")).isDisplayed();
        //判断是否为true
        Assert.assertTrue(zhanshi);
    }
    /*
    * 打开百度页面
    * 通过文本判断是否正确
     */
    @Test
    public void BaiDu(){
        //打开百度浏览地址
        driver.get("https://www.baidu.com");
        //定位百度的文本框
        String name = driver.findElement(By.id("su")).getAttribute("value");

        Assert.assertEquals(name,"百度一下");
    }
    /*
    * 打开界面自动化测试用例界面
    * 点击alert,点确定，点击取消

     */
    @Test
    public void OpenTest() throws InterruptedException {
        //打开界面自动化测试页面
        driver.get("file:///D:/BaiduNetdiskDownload/selenium_html/index.html");
        //定位alert按钮元素，点击确定
        driver.findElement(By.className("confirm")).click();
        //转交给弹出的页面
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        //点击确定
        alert.accept();
        Thread.sleep(3000);
        //再次点击确定
        alert.accept();
        Thread.sleep(3000);
        //定位alert按钮元素，点击确定
        driver.findElement(By.className("confirm")).click();
        //点击取消
        //转交给弹出的页面
        Alert alert01 = driver.switchTo().alert();
        Thread.sleep(3000);
        alert01.dismiss();
        Thread.sleep(3000);
        //再次确定
        alert01.accept();
        Thread.sleep(3000);
    }
    /*
    * 获取弹出框的文档
     */
    @Test
    public void HuoQu() throws InterruptedException {
        //打开网页
        driver.get("file:///D:/BaiduNetdiskDownload/selenium_html/index.html");
        driver.findElement(By.className("alert")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(3000);
        String text = alert.getText();
        alert.accept();
        Thread.sleep(3000);
        Assert.assertEquals(text,"请点击确定");


    }
    /*
    * 点击Prompt按钮
    * 在prom中输入“这个是prompt"
    * 点击确实
    * 再次确定
     */
    @Test
    public void Prompt()throws InterruptedException{

        //打开地址
        webDriver.get("file:///D:/BaiduNetdiskDownload/selenium_html/index.html");
        //定位prom按钮
        webDriver.findElement(By.className("prompt")).click();
        Thread.sleep(3000);
        //driver转交给弹框
        Alert alert = webDriver.switchTo().alert();
        alert.sendKeys("这是个是pamt");
        Thread.sleep(2000);
        //点击确定
        alert.accept();
        Thread.sleep(3000);
        //再次确定
        alert.accept();
        Thread.sleep(3000);
    }
    @AfterMethod
    public void Close(){
        driver.quit();
    }
}

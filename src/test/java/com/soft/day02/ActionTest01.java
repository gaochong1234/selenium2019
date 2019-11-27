package com.soft.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionTest01 {
    WebDriver driver;
    /*
    * 打开谷歌浏览器
     */
    @BeforeMethod
    public void OpenChrome(){
        //设置谷歌浏览器
        System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
         driver = new ChromeDriver();
    }
    /*
    * 打开百度浏览器
    * 点击百度一下右键
     */
    @Test
    public void BaiDuY() throws InterruptedException {
        driver.get("https://www.baidu.com");
        WebElement element = driver.findElement(By.id("su"));
        //实例化一个Action
        Actions action = new Actions(driver);
        //鼠标右键点击
        action.contextClick(element).perform();
        Thread.sleep(3000);
    }
    /*
    * 点击百度一下双击
     */
    @Test
    public void ShuangJi() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement els = driver.findElement(By.id("su"));
        Thread.sleep(3000);
        //创建Action实例化
        Actions action01 = new Actions(driver);
        //双击点击百度一下
        action01.doubleClick(els).perform();
        Thread.sleep(3000);
    }
    /*
    * 打开百度
    * 鼠标移动到action上
    * 判读是否是Hele world
     */
    @Test
    public void ShuBiaoYd() throws InterruptedException {
        driver.get("file:///D:/BaiduNetdiskDownload/selenium_html/index.html");
        //定位Action元素
        WebElement element = driver.findElement(By.xpath("//*[@id=\"action\"]/input"));
        Thread.sleep(3000);
        //创建Action实例化
        Actions actions = new Actions(driver);
        //鼠标移动到Action按钮上
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
        //判读显示的文字是否正确
        //首先要点位到Hello World
        String text = driver.findElement(By.xpath(".//*[text()='Hello World!']")).getText();
        //判断是否是Hello Woeld
        Assert.assertEquals(text,"Hello World!");
        Thread.sleep(3000);
    }
    /*
    * 把元素拖拽到位置为500.600
     */
    @Test
    public void TuoZ() throws InterruptedException {
        driver.get("file:///D:/BaiduNetdiskDownload/selenium_html/dragAndDrop.html");
        //定位元素
        WebElement element = driver.findElement(By.xpath("//*[@id=\"drag\"]"));
        Thread.sleep(3000);
        //创建Actions
        Actions actions = new Actions(driver);
        //把元素拖拽到500.600
        actions.dragAndDropBy(element,300,300).perform();
        Thread.sleep(3000);
    }
    /*
    * 退出浏览器
     */
    @AfterMethod
    public void Closs(){
        driver.quit();
    }
}

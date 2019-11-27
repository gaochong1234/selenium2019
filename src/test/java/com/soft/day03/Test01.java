package com.soft.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class Test01 {
    WebDriver driver;
    /*
    * 打开谷歌浏览器
     */
    @BeforeMethod
    public void OpenChrome(){
        //设置浏览器
        System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    /*移动到某个元素上
     */
    @Test
    public void Moven() throws InterruptedException {
        //打开地址
         driver.get("file:///D:/BaiduNetdiskDownload/selenium_html/dragAndDrop.html");
         //定位需要移动的元素
       WebElement els =  driver.findElement(By.id("drag"));
       //定位被移动的元素
       WebElement els01 = driver.findElement(By.xpath("/html/body/h1"));
       Thread.sleep(3000);
       //创建Action类
        Actions actions = new Actions(driver);
        Thread.sleep(3000);
        //按住鼠标、移动元素、释放
        actions.clickAndHold(els).moveToElement(els01).release(els).perform();
        Thread.sleep(3000);
    }
    /*
    * 按住Ctrl进行多选
     */
    @Test
    public void DuoSelect() throws InterruptedException {
        //打开链接
        driver.get("file:///D:/BaiduNetdiskDownload/selenium_html/index.html");
        //定位多选框的元素
        WebElement el = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        //定位到多选框下面选择元素
        List<WebElement> els = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Actions acti = new Actions(driver);
        acti.keyDown(Keys.CONTROL).click(els.get(2)).keyUp(Keys.CONTROL).perform();
        Thread.sleep(3000);
    }
    @Test
    public void DuoSelect01() throws InterruptedException {
        //打开链接
        driver.get("file:///D:/BaiduNetdiskDownload/selenium_html/index.html");
        //定位多选框的元素
        driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        //定位多选框下的元素
        List<WebElement> ls = driver.findElements(By.xpath("//*[@id=\"selectWithMultipleEqualsMultiple\"]/option"));
        Thread.sleep(3000);
        //创建Action实例
        Actions at = new Actions(driver);
        at.keyDown(Keys.SHIFT).click(ls.get(0)).click(ls.get(2)).keyUp(Keys.SHIFT).perform();
        Thread.sleep(3000);
    }
    /*
    *快捷键
     */
    @Test
    public void Robit() throws AWTException, InterruptedException {
        //打开地址
        driver.get("https://www.baidu.com");
        //创建robit实例
        Robot robot = new Robot();
        //按Ctrl键
        robot.keyPress(KeyEvent.VK_CONTROL);robot.keyPress(KeyEvent.VK_CONTROL);
        //按s键
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    }
    /*
    * 上传
     */
    @Test
    public void Shangchuan() throws InterruptedException {
        //打开地址
        driver.get("file:///D:/BaiduNetdiskDownload/selenium_html/index.html");
        driver.findElement(By.id("load")).sendKeys( "C:\\Users\\Administrator\\Desktop\\新建文本文档.txt");
         Thread.sleep(3000);
    }
    /*
    * 关闭浏览器
     */
    @AfterMethod
    public void Closs(){
        driver.quit();
    }
}

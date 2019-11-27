package com.soft.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test04 {
    /*
    * 打开谷歌浏览器
    */
    WebDriver webDriver;
    @BeforeMethod
    public void OpenChrome(){
        //设置谷歌浏览器的路径
        System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        //打开浏览器
        webDriver = new ChromeDriver();

    }

    /*
     * 打开测试页面
     * 点击 open new Windows
     * 点击百度
     */
    @Test
    public void DuoChuang() throws InterruptedException {
        webDriver.get("file:///D:/BaiduNetdiskDownload/selenium_html/index.html");
        Thread.sleep(3000);
        //元素定位
        webDriver.findElement(By.linkText("Open new window")).click();
        Thread.sleep(3000);
        //定位到第二层弹窗
        //获取当前窗口
        String Handle = webDriver.getWindowHandle();
        //判断是哪个Handle
        for(String handles:webDriver.getWindowHandles()){
            if (handles.equals(Handle)){
                continue;
            }else{
                webDriver.switchTo().window(handles);
            }
        }
        webDriver.findElement(By.className("baidu")).click();
        Thread.sleep(3000);
    }
    /*
    * 点击wait按钮
    * 判断wait for display验证是否正确
     */
    @Test
    public void Wait() throws InterruptedException {
        webDriver.get("file:///D:/BaiduNetdiskDownload/selenium_html/index.html");

        webDriver.findElement(By.xpath("//*[@id=\"wait\"]/input")).click();

        String wait01 = webDriver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        Assert.assertEquals(wait01,"wait for display");


    }
    /*
    *关闭浏览器
     */
    @AfterMethod
    public void closs(){
        webDriver.quit();
    }
}

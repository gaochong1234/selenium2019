package com.soft.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

public class phantomjs {
    //s设置地址
    @Test
    public void PhanJs() throws InterruptedException {
        //设置地址
        System.setProperty("phantomjs.binary.path","D:\\idealU\\SeleniumDemo1910\\drivers\\phantomjs.exe");
        //创建实例或者打开phantomjs
        WebDriver driver = new PhantomJSDriver();
        //打开浏览
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
        //定位元素
        driver.findElement(By.id("kw")).sendKeys("phantomjs");
        //输出头文件
        String title = driver.getTitle();
        System.out.print(title);
        //设置时间
        Thread.sleep(3000);
        driver.quit();
    }
}

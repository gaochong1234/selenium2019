package com.soft.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test01 {
    WebDriver driver;
    @BeforeMethod
    public void OpenChrome() {
        //设置浏览器地址
        System.setProperty("webdriver.chrome.driver", "D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
        //打开谷歌浏览器
        driver = new ChromeDriver();
    }
    /*
    * 打开百度首页
    *  输入关键字selenium
    *  点击百度搜索
    *  校验第一行搜索的内容显示："selenium的方法 从入门到精通selenium"
     */
    @Test
    public void YamZhen(){
        //打开百度首页
        driver.get("https://www.baidu.com");
        //定位百度的输入框
        WebElement kw = driver.findElement(By.id("kw"));
        kw.sendKeys("selenium");
        //定位百度搜索按钮
        WebElement su = driver.findElement(By.id("su"));
        //点击百度搜索按钮
        su.click();
        //等到300秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //获取当文本
        String title = driver.getTitle();
        Assert.assertEquals(title,"selenium_百度搜索");
        //获取当前页面的url
       //String ur = driver.getCurrentUrl();
       //Assert.assertEquals(ur,":https://www.baidu.com/s?ie=utf-8&f=8&rsv_bp=1&rsv_idx=1&tn=baidu&wd=selenium&rsv_pq=d0a9985100007edf&rsv_t=38c3q8yAKDnXW%2BdESTdbIdAeMm0VjapN4agYbjEZ4IjCO40%2B%2B4dwCy2hXhk&rqlang=cn&rsv_enter=0&rsv_dl=tb&rsv_sug3=8&inputT=341&rsv_sug4=341");
    }
    /*
        //打开百度首页，点击新闻按钮
    校验新闻的地址是否是http://news.baidu.com
      */
    @Test
//   public void DingWei(){
//        //打开百度地址
//        driver.get("https://www.baidu.com");
//        //通过名称定位元素
//        WebElement element = driver.findElement(By.name("tj_trnews"));
//        //点击新闻按钮
//        element.click();
//        //获取当前页面的url
//        String url = driver.getCurrentUrl();
//        //校验新闻的链接地址是否是news.baidu.com
//       Assert.assertEquals(url,"http://news.baidu.com/");
//    }
    @AfterMethod
    public void Quit(){
        driver.quit();
    }
}
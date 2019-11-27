package com.soft.day01;

import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Test01 {

@Test
public void OpenHuoFF(){
  //指定火狐浏览器安装路径
     System.setProperty("webdriver.firefox.bin","D:\\浏览器\\fire\\firefox.exe");
//        //启动火狐浏览器
      WebDriver driver = new FirefoxDriver();
        // driver.get("https//www.baidu.com");

  }
   @Test
  public void OpenChrom() throws InterruptedException {
//定谷歌浏览器的安装路径
  System.setProperty("webdriver.chrome.driver","D:\\idealU\\SeleniumDemo1910\\drivers\\chromedriver.exe");
    WebDriver webdriver = new ChromeDriver();
       webdriver.get("https//www.baidu.com");
       Thread.sleep(5000);
       webdriver.quit();
}


}
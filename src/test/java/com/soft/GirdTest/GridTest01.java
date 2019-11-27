package com.soft.GirdTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest01 {
   @Test
    public void testChrom() throws MalformedURLException {
        //创建一个 DesiredCapabilites
        DesiredCapabilities ds = DesiredCapabilities.firefox();
        //实例化一个driver
        WebDriver driver = new RemoteWebDriver(new URL("http://10.0.0.104:6666/wd/hub"),ds);
        driver.get("http://www.baidu.com");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
    @DataProvider(name = "date4")
    public Object[][] test1(){
      return new Object[][]{
            {"Firefox"},
            {"chrome"}
        };
        }
     @Test(dataProvider = "date4")
    public void testliuqi(String br) throws MalformedURLException {
       DesiredCapabilities ds = null;
       if (br.equals("Firefox")){
           ds=DesiredCapabilities.firefox();
       }else if (br.equals("chrome")){
           ds=DesiredCapabilities.chrome();
       }
       WebDriver driver =new RemoteWebDriver(new URL("http://10.0.0.104:4444/wd/hub"),ds);
        driver.get("http://www.baidu.com");
   }

    }


package com.soft.GirdTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class test01 {

    @DataProvider(name = "date4")
        public Object[][] test(){
        return new Object[][]{
                {"FireFox","http://10.0.0.104:5555"},
                {"chrome","http://10.0.0.104:6666"}
        };
    }
    @Test(dataProvider = "date4")
    public void test1(String na,String url) throws InterruptedException, MalformedURLException {
        DesiredCapabilities ds = null;
        if (na.equals("Firefox")){
            ds = DesiredCapabilities.firefox();
        }else if (na.equals("chrome")){
            ds = DesiredCapabilities.chrome();
        }
        WebDriver driver = new RemoteWebDriver(new URL(url+"/wd/hub"),ds);
        driver.get("https://www.baidu.com");
        Thread.sleep(3000);
    }
}

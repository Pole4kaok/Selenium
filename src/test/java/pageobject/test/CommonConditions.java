package pageobject.test;

import driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageobject.page.*;
import util.TestListener;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = DriverSingleton.getDriver();
      /*  ChromeOptions options= new ChromeOptions();
        //capabilities.setPlatform(Platform.WINDOWS);
        try{
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }*/
      /*  FirefoxOptions options = new FirefoxOptions();
        try{
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
    }


    @AfterMethod(alwaysRun = true)
    public void browserClose(){
       DriverSingleton.closeDriver();
    }
}

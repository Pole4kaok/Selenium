package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeCreator implements DriverSingleton {
    public WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        return new ChromeDriver();
    }
}

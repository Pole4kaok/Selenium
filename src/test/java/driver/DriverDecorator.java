package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class DriverDecorator implements WebDriver {
    protected WebDriver driver;

    public DriverDecorator(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void get(String s) { driver.get(s); }

    @Override
    public String getCurrentUrl() { return driver.getCurrentUrl(); }

    @Override
    public String getTitle() { return driver.getTitle(); }

    @Override
    public List<WebElement> findElements(By by) { return driver.findElements(by); }

    @Override
    public WebElement findElement(By by) {
        WebElement webElement = driver.findElement(by);
        if(driver instanceof JavascriptExecutor){
            ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", webElement);
        }
        return webElement;
    }

    @Override
    public String getPageSource() { return driver.getPageSource(); }

    @Override
    public void close() { driver.close(); }

    @Override
    public void quit() { driver.quit(); }

    @Override
    public Set<String> getWindowHandles() { return driver.getWindowHandles(); }

    @Override
    public String getWindowHandle() { return driver.getWindowHandle(); }

    @Override
    public TargetLocator switchTo() { return driver.switchTo(); }

    @Override
    public Navigation navigate() { return driver.navigate(); }

    @Override
    public Options manage() { return driver.manage(); }
}

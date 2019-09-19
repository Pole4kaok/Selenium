package pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver){this.driver = driver;}

    public void waitElementClickable(By locator){
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitElementInvisible(By locator){
        new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

}

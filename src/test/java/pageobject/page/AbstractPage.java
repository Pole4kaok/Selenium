package pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void waitRulesEngineComplete(By locator, String text){
        new WebDriverWait(driver,20).until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
    }
    public void waitElementVisible(By locator){
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void customWait(final WebElement element1){
        new WebDriverWait(driver, 10).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {

                WebElement element = ExpectedConditions.visibilityOf(element1).apply(driver);
                try {
                    if (element != null)
                    {
                        element.isEnabled();
                    }
                    element.click();
                    return element;
                } catch (ElementClickInterceptedException e) {
                    return null;
                }
            }
            public String toString() {
                return "element to be clickable: ";
            }
        });
    }

}

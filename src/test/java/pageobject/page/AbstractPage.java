package pageobject.page;

import org.openqa.selenium.*;
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

    public void waitAjaxFinished(){
        new WebDriverWait(driver, 2000).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }
    public WebElement findElement(By by){
        WebElement webElement = driver.findElement(by);
        if(driver instanceof JavascriptExecutor){
            ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", webElement);
        }
        return webElement;
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

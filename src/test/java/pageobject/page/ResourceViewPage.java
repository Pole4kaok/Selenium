package pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ResourceViewPage extends AbstractPage {
    protected static final By DRAGGEDELEMENT_LOCATOR = By.xpath("//*[@id=\"ganttChart\"]/div/div[2]/div[3]/div[10]/div");
    protected static final By DROPPEDELEMENT_LOCATOR = By.xpath("//*[@id=\"ganttChart\"]/div/div[2]/div[2]/div[11]/div[4]");
    protected static final By POPUP_LOCATOR = By.id("ui-dialog-title-1");
    protected static final By OKBTN_LOCATOR = By.id("ct-button");
    public ResourceViewPage(WebDriver driver){super(driver);}
    public ResourceViewPage dragAndDrop(){
        WebElement element = driver.findElement(DRAGGEDELEMENT_LOCATOR);
        WebElement position = driver.findElement(DROPPEDELEMENT_LOCATOR);
        new Actions(driver).dragAndDrop(element, position);
        waitElementVisible(POPUP_LOCATOR);
        driver.findElement(OKBTN_LOCATOR).click();


        return this;
    }
}

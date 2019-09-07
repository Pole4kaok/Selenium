package pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage {
     new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("menuItem-10000-0-main")));
    WebElement casemenu = driver.findElement(By.id("menuItem-10000-0-main"));
    WebElement hiddenmenu = driver.findElement(By.xpath("//*[@id=\"menuItem-10047-0-sub\"]"));

    Actions builder = new Actions(driver);
        builder.moveToElement(casemenu).click(hiddenmenu);
    Action mouseOverandClick = builder.build();
        mouseOverandClick.perform();

    WebElement caseclass = driver.findElement(By.id("select2-chosen-1"));
        caseclass.click();
    WebElement typeAhead = driver.findElement(By.id("s2id_autogen1_search"));

        typeAhead.sendKeys("@@@");
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className("select2-searching")));

    WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]"));
    List<WebElement> options = dropdown.findElements(By.tagName("li"));
        for(WebElement option : options)
    {
        if(option.getText().equals("Business - N8 - Arbitration")){
            new WebDriverWait(driver,10)
                    .until(ExpectedConditions.elementToBeClickable(option));
            option.click();
            break;
        }
    }


    final WebElement saveBtn = driver.findElement(By.name("save"));

        new WebDriverWait(driver, 5).until(new ExpectedCondition<WebElement>() {
        public WebElement apply(WebDriver driver) {
            WebElement element = ExpectedConditions.visibilityOf(saveBtn).apply(driver);

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

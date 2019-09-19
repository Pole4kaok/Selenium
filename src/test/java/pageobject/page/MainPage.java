package pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class MainPage extends AbstractPage {
    private static final By CASEMENU_LOCATOR = By.id("menuItem-10000-0-main");
    private static final By CREATECASE_LOCATOR = By.xpath("//*[@id=\"menuItem-10047-0-sub\"]");
    private static final By FIELD_LOCATOR = By.id("select2-chosen-1");
    private static final By TYPEAHEAD_LOCATOR = By.id("s2id_autogen1_search");
    private static final By INVISIBLE_LOCATOR = By.className("select2-searching");
    private static final By CLASSDROPDOWN_LOCATOR = By.xpath("//*[@id=\\\"select2-results-1\\\"]");
    public MainPage (WebDriver driver){super(driver);}

    public MainPage openCreateCase(){
        waitElementClickable(CASEMENU_LOCATOR);
        driver.findElement(CASEMENU_LOCATOR).click();
        driver.findElement(CREATECASE_LOCATOR).click();
        return this;
    }

    public MainPage fillInCaseClassification(String classification){
        driver.findElement(FIELD_LOCATOR).click();
        driver.findElement(TYPEAHEAD_LOCATOR).sendKeys(classification);
        waitElementInvisible(INVISIBLE_LOCATOR);
        return this;
    }

    public MainPage chooseCaseClassification(String caseClass){
        WebElement drodown = driver.findElement(CLASSDROPDOWN_LOCATOR);
        List<WebElement> options = drodown.findElements(By.tagName("li"));
        for (WebElement option: options){
            if(option.getText().equals(caseClass)){
                new WebDriverWait(driver,10)
                    .until(ExpectedConditions.elementToBeClickable(option));
                option.click();
                break;
            }
        }
        return this;
    }
}

     /*new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("menuItem-10000-0-main")));
    WebElement casemenu = driver.findElement(By.id("menuItem-10000-0-main"));
    WebElement hiddenmenu = driver.findElement(By.xpath("//*[@id=\"menuItem-10047-0-sub\"]"));

    Actions builder = new Actions(driver);
        builder.moveToElement(casemenu).click(hiddenmenu);
    Action mouseOverandClick = builder.build();
        mouseOverandClick.perform();*/
     /*

    WebElement caseclass = driver.findElement(By.id("select2-chosen-1"));
        caseclass.click();
    WebElement typeAhead = driver.findElement(By.id("s2id_autogen1_search"));

        typeAhead.sendKeys("@@@");
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.className("select2-searching")));*/
     /*

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

         //ГДЕ ЛУЧШЕ РАЗМЕСТИТЬ КАСТОМНЫЙ ВЕЙТЕР
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
    });*/


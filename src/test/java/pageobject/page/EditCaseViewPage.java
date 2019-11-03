package pageobject.page;

import model.CaseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static pageobject.page.MainPage.SAVEBTN_LOCATOR;

public class EditCaseViewPage extends AbstractPage {
   // protected static final By CASECAPTIONMENU_LOCATOR = By.xpath("//*[@id=\"checkInstanceRow35\"]");
    protected static final By CASEVIEW_LOCATOR = By.id("menuItem-10044-1-main");
    protected static final By CASECAPTION_FIELD_LOCATOR = By.id("caseCaption");
    protected static final By CASETITLE_FIELD_LOCATOR = By.id("caseTitle");
    protected static final By EDITLINK_LOCATOR = By.xpath("//*[@id=\"caseInformation\"]/table/tbody/tr[10]/td/a");
    public EditCaseViewPage(WebDriver driver){super(driver);}

    public EditCaseViewPage addCaseCaptionAndTitle(CaseModel newCase){
        waitElementVisible(CASEVIEW_LOCATOR);
        driver.findElement(CASEVIEW_LOCATOR).click();
        waitElementVisible(EDITLINK_LOCATOR);
        driver.findElement(EDITLINK_LOCATOR).click();
        waitElementClickable(CASECAPTION_FIELD_LOCATOR);
        driver.findElement(CASECAPTION_FIELD_LOCATOR).sendKeys(newCase.getcaseCaption());
        addCaseTitle(newCase.getcaseTitle());
        driver.findElement(SAVEBTN_LOCATOR).click();
        return this;
    }

    public EditCaseViewPage addCaseTitle(String caseTitle){
        WebElement caseTitleField = driver.findElement(CASETITLE_FIELD_LOCATOR);
        caseTitleField.sendKeys(caseTitle);
        return this;
    }
}

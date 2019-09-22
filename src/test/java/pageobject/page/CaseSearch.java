package pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

public class CaseSearch extends AbstractPage{
    protected static final By CASENUMBER_FIELD_LOCATOR = By.xpath("//*[@id=\"caseSection\"]/table/tbody/tr[1]/td[2]/input");
    protected static final By SEARCHBTN_LOCATOR = By.xpath("//input[@value='Search']");
    protected static final By SEARCHRESULT_LOCATOR = By.xpath("//*[@id=\"caseSearchResultsTable\"]/table/tbody/tr/td[1]");
    public CaseSearch(WebDriver driver){super(driver);}

    public CaseSearch caseSearch(String caseNumber){
        driver.findElement(MainPage.CASEMENU_LOCATOR).click();
        waitElementClickable(MainPage.CASE_SEARCH_LOCATOR);
        driver.findElement(MainPage.CASE_SEARCH_LOCATOR).click();
        driver.findElement(CASENUMBER_FIELD_LOCATOR).sendKeys(caseNumber);
        driver.findElement(SEARCHBTN_LOCATOR).click();
        waitElementClickable(SEARCHRESULT_LOCATOR);
        driver.findElement(SEARCHRESULT_LOCATOR).click();
        return this;
    }

}

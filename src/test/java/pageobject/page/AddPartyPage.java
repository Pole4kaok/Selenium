package pageobject.page;

import model.PersonModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static pageobject.page.MainPage.SAVEBTN_LOCATOR;

public class AddPartyPage extends AbstractPage {
    protected static final By PARTY_MENU_LOCATOR = By.id("menuItem-10045-1-main");
    protected static final By ADDNEWBNT_LOCATOR = By.xpath("//*[@id=\"searchSection\"]/table[2]/tbody/tr/td[2]/input[2]");
    protected static final By PARTYTYPE_SELECT_LOCATOR = By.id("partyTypeSelect");
    protected static final By PARTYROLE_SELECT_LOCATOR = By.id("partySubTypeSelect");
    protected static final By LASTNAME_LOCATOR = By.name("person.lastName");
    protected static final By FIRSTNAME_LOCATOR = By.name("person.firstName");
    protected static final By LINE1_LOCATOR = By.name("actorInstance.addresses[0].line1");
    protected static final By COUNTRY_LOCATOR = By.name("actorInstance.addresses[0].country.countryID");
    protected static final By ADDLEGAL_LINK_LOCATOR = By.xpath("//*[@id=\"casePartyID\"]/div[2]/a");
    public AddPartyPage(WebDriver driver){super(driver);}

    public AddPartyPage addPartyRoleType(String type, String role){
        driver.findElement(PARTY_MENU_LOCATOR).click();
        driver.findElement(ADDNEWBNT_LOCATOR).click();
        waitElementClickable(PARTYTYPE_SELECT_LOCATOR);

        WebElement partyTypeDropdown = driver.findElement(PARTYTYPE_SELECT_LOCATOR);
        customWait(partyTypeDropdown);
        partyTypeDropdown.sendKeys(type);

        WebElement partyRoleDropdown = driver.findElement(PARTYROLE_SELECT_LOCATOR);
        partyRoleDropdown.click();
        partyRoleDropdown.sendKeys(role);
        driver.findElement(SAVEBTN_LOCATOR).click();
        return this;
    }

    public AddPartyPage addPerson(PersonModel person){
        waitElementClickable(LASTNAME_LOCATOR);
        driver.findElement(LASTNAME_LOCATOR).sendKeys(person.getLastName());
        driver.findElement(FIRSTNAME_LOCATOR).sendKeys(person.getFirstName());
        driver.findElement(LINE1_LOCATOR).sendKeys(person.getLine1());
        driver.findElement(COUNTRY_LOCATOR).sendKeys(person.getCountry());
        driver.findElement(SAVEBTN_LOCATOR).click();
        return this;
    }

    public AddPartyPage addLegalRep(){
        waitElementClickable(ADDLEGAL_LINK_LOCATOR);
        driver.findElement(SAVEBTN_LOCATOR).click();
        return this;
    }

}

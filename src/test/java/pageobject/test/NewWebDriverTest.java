package pageobject.test;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.page.*;

import java.util.List;

public class NewWebDriverTest {

    private WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver", "D:\\ATM\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test(description = "Creating and searching case")
    public void createCase(){
        driver.get("https://qa-cms.cefile-app.com");
        LoginPage loginPage = new LoginPage(driver).open().login("opsmanager","clerkfull");
        MainPage mainPage = new MainPage(driver).openCreateCase().fillInCaseClassification("@@@").chooseCaseClassification("Business - N8 - Arbitration");
    }
    public void createAndSearchCase() {
       /* driver.get("https://qa-cms.cefile-app.com");
        LoginPage loginPage = new LoginPage(driver).open().login("opsmanager","clerkfull");
        MainPage mainPage = new MainPage(driver).openCreateCase().fillInCaseClassification("@@@").chooseCaseClassification("Business - N8 - Arbitration");*/
        createCase();
        String createdCaseNumber = new CaseView(driver).getCaseNumber();
        CaseSearch caseSearch = new CaseSearch(driver).caseSearch(createdCaseNumber);
        String foundCaseNumber = new CaseView(driver).getFoundCaseNumber();

        Assert.assertEquals(createdCaseNumber,foundCaseNumber,"Failed");
    }
   @Test(description = "complete checklist")
   public void completeChecklist(){
        createCase();
       AddPartyPage addPartyPage = new AddPartyPage(driver).addPartyRoleType("Party","Defendant")
               .addPerson("Last","First","Liiiine","Wales").addLegalRep();
       CaseEvent caseEvent = new CaseEvent(driver).chooseCaseEventClass("Filing - Bundle").saveCaseEvent();
       EditCaseViewPage editCaseViewPage = new EditCaseViewPage(driver).addCaseCaptionAndTitle("Caption","Title");
       WebElement checklist = driver.findElement(By.xpath("//*[@id=\"leftNav\"]/div[2]/div/div"));
       Boolean isHere = checklist.isSelected();

       // HELP1!1!1!!!1!
        //Assert.assertTrue((checklist.getAttribute("style").equals("display: none")),"It is visible. Or not. Maybe wrong selector");
       System.out.println(isHere);

   }


    @AfterMethod(alwaysRun = true)
    public void browserClose(){
        driver.quit();
        driver = null;
    }
}

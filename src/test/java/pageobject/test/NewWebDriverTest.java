package pageobject.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
       // LoginPage loginPage = new LoginPage(driver).open().login("opsmanager","clerkfull");
        MainPage mainPage = new MainPage(driver).openCreateCase().fillInCaseClassification("@@@").chooseCaseClassification("Business - N8 - Arbitration");
    }

    @Test (description = "create and search for a case")
    public void createAndSearchCase() {
        createCase();
        String createdCaseNumber = new CaseViewPage(driver).getCaseNumber();
        CaseSearchPage caseSearch = new CaseSearchPage(driver).caseSearch(createdCaseNumber);
        String foundCaseNumber = new CaseViewPage(driver).getFoundCaseNumber();
        Assert.assertEquals(createdCaseNumber,foundCaseNumber,"Failed");
    }

   @Test(description = "complete checklist")
   public void completeChecklist(){
        createCase();
       AddPartyPage addPartyPage = new AddPartyPage(driver).addPartyRoleType("Party","Defendant")
               .addPerson("Last","First","Liiiine","Wales").addLegalRep();
       CaseEventPage caseEvent = new CaseEventPage(driver).chooseCaseEventClass("Filing - Bundle").saveCaseEvent();
       EditCaseViewPage editCaseViewPage = new EditCaseViewPage(driver).addCaseCaptionAndTitle("Caption","Title");
       List checklist = driver.findElements(By.cssSelector(".cc-checklistTable"));
       Assert.assertTrue(checklist.size()==0,"It is visible. Or not. Maybe wrong selector");
   }

   @Test(description = "create resource schedule")
   public void createResourceScheduleSession(){
       driver.get("https://qa-cms.cefile-app.com");
       MainPage mainPage = new LoginPage(driver).open().login("sccomanager","clerkfull");
       mainPage.openCalendar();
       String sessionName = "Mein Session 2";
//       CalendarPage calendarPage = new CalendarPage(driver).createNewResSchedule(sessionName, "Charles");
       String createdSessionName = new CalendarPage(driver).checkCreatedSession();
       Assert.assertEquals(sessionName,createdSessionName);

   }

   @Test(description = "drag and drop try")
   public void dragAndDropResource(){
       driver.get("https://qa-cms.cefile-app.com");
       LoginPage loginPage = new LoginPage(driver);
       loginPage.open().login("sccomanager","clerkfull");
       MainPage resourceView = new MainPage(driver).openResourceView();
       ResourceViewPage resourceViewPage = new ResourceViewPage(driver).dragAndDrop();
       String newDate = resourceViewPage.getNewDateValue();
       String getNewDate = resourceViewPage.verifyNewDate();
       Assert.assertEquals(newDate,getNewDate);

   }


    @AfterMethod(alwaysRun = true)
    public void browserClose(){
        driver.quit();
        driver = null;
    }
}

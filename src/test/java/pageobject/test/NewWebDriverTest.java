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
import pageobject.page.CaseView;
import pageobject.page.LoginPage;

import java.util.List;

public class NewWebDriverTest {

    private WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver", "D:\\ATM\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test(description = "Creating and searching case")
    public void createAndSearchCase() {
        driver.get("https://qa-cms.cefile-app.com");
        /*WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("opsmanager");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("clerkfull");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
        loginBtn.click();*/

       /* new WebDriverWait(driver, 10).until( ExpectedConditions.elementToBeClickable(By.id("menuItem-10000-0-main")));
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
        });*/

      /*  new WebDriverWait(driver, 20)
                .until(ExpectedConditions.textToBePresentInElementLocated((By.xpath("//*[@id=\"caseRulesEnginePolling\"]/td/div/span[2]/span")),"Rules Engine Complete"));
        WebElement caseInfo = driver.findElement(By.xpath("//td/span[@class='ct-content']"));
        String caseNumber = caseInfo.getText();

        WebElement caseMenu = driver.findElement(By.id("menuItem-10000-0-main"));
        caseMenu.click();


        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.id("menuItem-10053-0-sub")));
        WebElement caseSearch = driver.findElement(By.id("menuItem-10053-0-sub"));
        caseSearch.click();

        WebElement caseNumberField = driver.findElement(By.xpath("//*[@id=\"caseSection\"]/table/tbody/tr[1]/td[2]/input"));
      // элемент не находится по этому класс нейм WebElement caseNumberField = driver.findElement(By.className("ct-input ct-inputText"));
        caseNumberField.sendKeys(caseNumber);

        WebElement searchBtn = driver.findElement(By.xpath("//input[@value='Search']"));
        searchBtn.click();

        new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"caseSearchResultsTable\"]/table/tbody/tr/td[1]")));
        WebElement searchRslt = driver.findElement(By.xpath("//*[@id=\"caseSearchResultsTable\"]/table/tbody/tr/td[1]"));
        searchRslt.click();*/

       // int caseNumber = new CaseView().getCaseNumber();
        //int foundCase = new CaseView().getCaseNumber();
       /* WebElement foundCaseNumber = driver.findElement(By.xpath("//td/span[@class='ct-content']"));
        String foundCase = foundCaseNumber.getText();*/

      //  Assert.assertEquals(caseNumber,foundCase,"Search not done");
        LoginPage loginPage = new LoginPage(driver).open().login("opsmanager","clerkfull");

    }
    @AfterMethod(alwaysRun = true)
    public void browserClose(){
        driver.quit();
        driver = null;
    }
}

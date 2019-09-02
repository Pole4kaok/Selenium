import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import  org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NewWebDriver {
    public static void main(String[] args)throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\ATM\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-cms.cefile-app.com");
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("opsmanager");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("clerkfull");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
        loginBtn.click();

       // Thread.sleep(2000);
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
        Thread.sleep(1000);
       /* new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"select2-results-1\"]")));*/
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]"));
        List<WebElement> options = dropdown.findElements(By.tagName("li"));
        for(WebElement option : options)
        {
            if(option.getText().equals("Business - N8 - Arbitration")){
                option.click();
                break;
            }
        }

        WebElement saveBtn = driver.findElement(By.name("save"));
        saveBtn.click();
       // Thread.sleep(2000);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElementLocated((By.xpath("//*[@id=\"caseRulesEnginePolling\"]/td/div/span[2]/span")),"Rules Engine Complete"));
        WebElement caseInfo = driver.findElement(By.xpath("//td/span[@class='ct-content']"));
        String caseNumber = caseInfo.getText();
        //System.out.println(getCaseNumber);
        WebElement caseMenu = driver.findElement(By.id("menuItem-10000-0-main"));
        caseMenu.click();

        Thread.sleep(2000);
        WebElement caseSearch = driver.findElement(By.id("menuItem-10053-0-sub"));
        caseSearch.click();

        WebElement caseNumberField = driver.findElement(By.xpath("//*[@id=\"caseSection\"]/table/tbody/tr[1]/td[2]/input"));
        caseNumberField.sendKeys(caseNumber);

        WebElement searchBtn = driver.findElement(By.xpath("//input[@value='Search']"));
        searchBtn.click();

        Thread.sleep(2000);
        WebElement searchRslt = driver.findElement(By.xpath("//*[@id=\"caseSearchResultsTable\"]/table/tbody/tr/td[1]"));
        searchRslt.click();

        WebElement foundCaseNumber = driver.findElement(By.xpath("//td/span[@class='ct-content']"));
        String foundCase = foundCaseNumber.getText();

        if(caseNumber.equals(foundCase))
            System.out.println("Success");
        else
            System.exit(-1);

        driver.quit();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import  org.openqa.selenium.support.ui.Select;

import java.util.List;

public class NewWebDriver {
    public static void main(String[] args)throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\ATM\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-cms.cefile-app.com");
        WebElement username = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input"));
        username.sendKeys("opsmanager");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("clerkfull");
        WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/table/tbody/tr/td/div/table/tbody/tr/td/input"));
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
        WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"select2-results-1\"]"));
        List<WebElement> options = dropdown.findElements(By.tagName("li"));
        for(WebElement option : options)
        {
            if(option.getText().equals("Business - N8 - Arbitration")){
                option.click();
                break;
            }
        }
              // WebElement randomClass = driver.findElement(By.id("select2-result-label-90"));

       /* WebElement randomClass = driver.findElement(By.xpath("//*[@id=\"s2id_autogen1_search\"]"));
        builder.moveToElement(randomClass).click(randomClass);
        Action move = builder.build();
        move.perform();*/

        Thread.sleep(2000);
        WebElement saveBtn = driver.findElement(By.name("save"));
        saveBtn.click();
        Thread.sleep(2000);

        WebElement caseInfo = driver.findElement(By.xpath("//*[@id=\"leftNav\"]/div[1]/div/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/span"));
        String caseNumber = caseInfo.getText();
        //System.out.println(getCaseNumber);
        WebElement caseMenu = driver.findElement(By.id("menuItem-10000-0-main"));
        caseMenu.click();
       // WebElement caseSearch = driver.findElement(By.xpath("//*[@id=\"menuItem-10053-0-sub\"]"));
        Thread.sleep(2000);
        WebElement caseSearch = driver.findElement(By.id("menuItem-10053-0-sub"));
        caseSearch.click();

        WebElement caseNumberField = driver.findElement(By.xpath("//*[@id=\"caseSection\"]/table/tbody/tr[1]/td[2]/input"));
        caseNumberField.sendKeys(caseNumber);

        WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"caseSearchForm\"]/table[3]/tbody/tr/td/input"));
        searchBtn.click();

        Thread.sleep(2000);
        WebElement searchRslt = driver.findElement(By.xpath("//*[@id=\"caseSearchResultsTable\"]/table/tbody/tr/td[1]"));
        searchRslt.click();



        driver.quit();
    }
}

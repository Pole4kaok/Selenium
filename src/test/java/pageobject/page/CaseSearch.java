package pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CaseSearch {
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
        searchRslt.click();
}

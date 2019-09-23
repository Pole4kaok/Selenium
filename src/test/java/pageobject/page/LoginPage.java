package pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends AbstractPage {
    public LoginPage (WebDriver driver) { super(driver);}
    private static final By USERNAME_LOCATOR = By.name("username");
    private static final By PASSWORD_LOCATOR = By.name("password");
    private static final By LOGINBTN_LOCATOR = By.xpath("//input[@value='Login']");

        public LoginPage login(String username, String password){
            new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(USERNAME_LOCATOR));
            driver.findElement(USERNAME_LOCATOR).sendKeys(username);
            driver.findElement(PASSWORD_LOCATOR).sendKeys(password);
            driver.findElement(LOGINBTN_LOCATOR).click();
            return this;
        }

        public LoginPage open(){
            driver.get("https://qa-cms.cefile-app.com");
            return this;
        }
}

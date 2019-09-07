package pageobject.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    driver.get("https://qa-cms.cefile-app.com");
    WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("opsmanager");
    WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("clerkfull");
    WebElement loginBtn = driver.findElement(By.xpath("//input[@value='Login']"));
        loginBtn.click();
}

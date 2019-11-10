package pageobject.page;

import org.openqa.selenium.WebDriver;

public class AddCaseEventPage extends AbstractPage {
    public AddCaseEventPage(WebDriver driver){super(driver);}

    public AddCaseEventPage addDescription(String description){
        return this;
    };

}

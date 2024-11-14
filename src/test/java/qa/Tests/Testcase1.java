package qa.Tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class Testcase1 extends BaseTest {
    ElementFetch ele=new ElementFetch();
    HomePageEvents home=new HomePageEvents();
    LoginPageEvents login=new LoginPageEvents();
    @Test
    public void sampleMethodForEnteringCredential()
    {
        home.startHereButton();
        //login.verifyIfLoginPageIsLoaded();
        waitForElementToBeVisible(By.xpath(LoginPageElements.loginText));
        login.enterCredential();
    }
}

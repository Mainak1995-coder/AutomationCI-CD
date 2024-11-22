package pageEvents;

import org.testng.Assert;
import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {
    ElementFetch ele=new ElementFetch();
    public void verifyIfLoginPageIsLoaded()
    {
        Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.emailAddress).size()>0,"Element Not Found");
    }
    public void login()
    {
        ele.getWebElement("ID",LoginPageElements.emailAddress).sendKeys("sayan@gmail.com");
        ele.getWebElement("ID",LoginPageElements.passwordField).sendKeys("Sayan@12345");
        ele.getWebElement("ID",LoginPageElements.loginButton).click();
    }
}

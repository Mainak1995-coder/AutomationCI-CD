package pageEvents;

import base.BaseTest;
import org.testng.Assert;
import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {
    ElementFetch ele=new ElementFetch();
    public void verifyIfLoginPageIsLoaded()
    {
        Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.loginText).size()>0,"Element Not Found");


    }
    public void enterCredential()
    {
        ele.getWebElement("NAME",LoginPageElements.emailAddress).sendKeys("abc@gmail.com");
        ele.getWebElement("NAME",LoginPageElements.passwordField).sendKeys("TEST");
    }
}

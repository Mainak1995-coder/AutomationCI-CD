package qa.Tests;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class Testcase1 extends BaseTest {
    ElementFetch ele=new ElementFetch();
    LoginPageEvents loginP=new LoginPageEvents();

    @Test
    public void loginToWebsite()
    {
        loginP.login();
    }
}

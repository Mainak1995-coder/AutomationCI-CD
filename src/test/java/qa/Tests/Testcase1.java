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
    LoginPageEvents loginP=new LoginPageEvents();

    @Test(dataProvider = "loginData",dataProviderClass = LoginPageEvents.class)
    public void loginToWebsite(String username,String password) throws InterruptedException {
        loginP.login(username, password);

    }
}

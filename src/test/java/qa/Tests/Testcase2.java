package qa.Tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.HomePageEvents;
import pageEvents.SignUpPageEvents;
import utils.ElementFetch;

public class Testcase2 extends BaseTest {
    ElementFetch ele=new ElementFetch();
    HomePageEvents home=new HomePageEvents();
    SignUpPageEvents signup=new SignUpPageEvents();
    @Test
    public void signUpProcess()
    {
        home.startHereButton();
        signup.enterEmailCheckBoxClick();
    }
}

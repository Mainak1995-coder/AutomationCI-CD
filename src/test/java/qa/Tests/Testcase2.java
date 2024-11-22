package qa.Tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.HomePageEvents;
import pageEvents.RegisterPageEvents;
import utils.ElementFetch;

public class Testcase2 extends BaseTest {
    ElementFetch ele=new ElementFetch();
    HomePageEvents home=new HomePageEvents();
    RegisterPageEvents signup=new RegisterPageEvents();

    @Test
    public void registerProcess() throws InterruptedException {
        home.registerButton();
        signup.fillSignupClick();
    }
}

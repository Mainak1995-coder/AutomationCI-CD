package pageEvents;

import pageObjects.HomePageElements;
import utils.ElementFetch;

public class HomePageEvents {
    ElementFetch ele=new ElementFetch();

    public void registerButton()
    {
        ele.getWebElement("XPATH", HomePageElements.registerButton).click();
    }
}

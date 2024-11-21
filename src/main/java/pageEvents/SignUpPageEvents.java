package pageEvents;

import pageObjects.SignUpPageElements;
import utils.ElementFetch;

public class SignUpPageEvents {
    ElementFetch ele=new ElementFetch();
    public void enterEmailCheckBoxClick()
    {
        ele.getWebElement("NAME", SignUpPageElements.emailAddress).sendKeys("abc@gmail.com");
        ele.getWebElement("NAME",SignUpPageElements.terms).click();
        //ele.getWebElement("XPATH",SignUpPageElements.reCaptcha).click();
    }
}

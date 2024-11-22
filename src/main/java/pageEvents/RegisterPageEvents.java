package pageEvents;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.RegisterPageElements;
import utils.ElementFetch;

import java.time.Duration;

public class RegisterPageEvents {
    ElementFetch ele=new ElementFetch();
    public void fillSignupClick() throws InterruptedException {
        ele.getWebElement("ID",RegisterPageElements.firstName).sendKeys("Rahul");
        ele.getWebElement("ID",RegisterPageElements.lastName).sendKeys("Kumar");
        ele.getWebElement("ID", RegisterPageElements.emailAddress).sendKeys("rahul@gmail.com");
        ele.getWebElement("ID",RegisterPageElements.phoneNumber).sendKeys("123456789");
        WebElement Occupation=ele.getWebElement("XPATH",RegisterPageElements.occupation);
        Occupation.click();
        Thread.sleep(2000);
        Select occuDropdown=new Select(Occupation);
        occuDropdown.selectByVisibleText("Engineer");
        ele.getWebElement("XPATH",RegisterPageElements.genderMale).click();
        ele.getWebElement("ID",RegisterPageElements.passWord).sendKeys("Test");
        ele.getWebElement("ID",RegisterPageElements.confirmPassword).sendKeys("Test");
        ele.getWebElement("XPATH",RegisterPageElements.ageCheckBox).click();
        ele.getWebElement("ID",RegisterPageElements.registerButton).click();




    }
}

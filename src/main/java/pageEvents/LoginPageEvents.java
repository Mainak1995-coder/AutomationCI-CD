package pageEvents;

import base.BaseTest;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPageElements;
import pageObjects.SearchPageElements;
import utils.Constants;
import utils.ElementFetch;
import utils.ExcelUtils;

import java.io.IOException;

public class LoginPageEvents extends BaseTest {
    ElementFetch ele=new ElementFetch();
    public void verifyIfLoginPageIsLoaded()
    {
        Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.emailAddress).size()>0,"Element Not Found");
    }

        @DataProvider(name = "loginData")
        public Object[][] loginDataProvider() throws IOException {
            String filePath= Constants.excelPath;
            String sheetName="Sheet1";
            return ExcelUtils.getExcelData(filePath, sheetName);
        }
    @Test(dataProvider = "loginData")
    public void login(String username, String password) throws InterruptedException {
        ele.getWebElement("ID",LoginPageElements.emailAddress).sendKeys(username);
        ele.getWebElement("ID",LoginPageElements.passwordField).sendKeys(password);
        ele.getWebElement("ID",LoginPageElements.loginButton).click();
        //waitForElementToBeVisible(By.name("search"));
        Thread.sleep(3000);
        // Validate login success or failure
        boolean isLoginSuccessful=ele.getWebElements("NAME", SearchPageElements.searchBox).size()>0;
        Assert.assertTrue(isLoginSuccessful,"Login failed for user: " + username);
    }


}

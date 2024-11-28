package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.Constants;

import java.time.Duration;

public class BaseTest {
    public static  WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    @Parameters("browser")
    public void browserInvoke(@Optional("chrome") String browser)
    {
        setupDriver(browser);
        driver.manage().window().maximize();
        driver.get(Constants.url);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait  wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

    public void setupDriver(String browser){
        if (browser.equalsIgnoreCase("chrome"))
        {
            driver=new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge"))
        {
            driver=new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            driver=new FirefoxDriver();
        }

    }
    public void waitForElementToBeVisible(By locator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForElementToBeClickable(By locator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}

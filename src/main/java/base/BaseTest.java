package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import utils.Constants;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    ExtentReports extentReports;
    ExtentSparkReporter extentSparkReporter;
public static  WebDriver driver;
    WebDriverWait wait;
    ExtentTest logger;
    ITestResult result;
    @BeforeTest
    public void beforeTestMethod()
    {
        extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        //configuration items to change the look and feel
        //add content, manage tests etc
        extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
        extentSparkReporter.config().setReportName("Free CRM Project");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentReports.setSystemInfo("Tester","Mainak Kundu");
    }
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethodMethod(String browser, Method testMethod)
    {
        logger=extentReports.createTest(testMethod.getName());
        setupDriver(browser);
        driver.manage().window().maximize();
        driver.get(Constants.url);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));

    }
    @AfterMethod
    public void afterMethod()
    {
        result= Reporter.getCurrentTestResult();
        switch (result.getStatus())
        {
            case ITestResult.SUCCESS:
                System.out.println("---PASS---");
                break;
            case ITestResult.FAILURE:
                System.out.println("---FAIL---");
                break;
            case ITestResult.SKIP:
                System.out.println("---SKIP---");
                break;

        }
        driver.quit();
    }
    @AfterTest
    public void afterTest()
    {
        extentReports.flush();
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

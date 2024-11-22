package utils;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;


public class SuitListener implements ITestListener, IAnnotationTransformer {

    ExtentReports extentReports;
    ExtentSparkReporter extentSparkReporter;
    ExtentTest logger;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        //configuration items to change the look and feel
        extentSparkReporter.config().setDocumentTitle("Simple Automation Report");
        extentSparkReporter.config().setReportName("Free CRM Project");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentReports.setSystemInfo("Tester","Mainak Kundu");

    }
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test=extentReports.createTest(result.getMethod().getMethodName());
        extentTest.set(test);

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        extentTest.get().fail("Test Failed" + result.getThrowable());
        String fileName=System.getProperty("user.dir")+ File.separator+"screenshots"+File.separator+result.getMethod().getMethodName();
        File f1=((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(f1,new File(fileName+ ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip("Test Skipped" + result.getThrowable());
    }



    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}

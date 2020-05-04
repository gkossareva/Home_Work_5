package com.vytrack.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtilities;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Actions;
import java.io.IOException;

public class AbstractBaseTests {
    protected WebDriver driver;
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;

    @BeforeTest
    public void beforeTest() {
        extentReports = new ExtentReports();
        String reportPath = "";

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\report.html";
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/report.html";
        }
        extentHtmlReporter = new ExtentHtmlReporter(reportPath);
        extentReports.attachReporter(extentHtmlReporter);
        extentHtmlReporter.config().setReportName("WebOrders Automation");

    }

    @AfterTest
    public void afterTest() {
        extentReports.flush();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional String browser) {
        System.out.println("Browser type: " + browser);
        driver = browser == null ? Driver.getDriver() : Driver.getDriver(browser);
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().window().maximize();
        Actions actions = new Actions(Driver.getDriver());
        LoginPage loginPage=new LoginPage();
        loginPage.login();
        loginPage.navigateTo("Activities","Calendar Events");
    }

    @AfterMethod
    public void teardown(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            String screenshotLocation = BrowserUtilities.getScreenshot(testResult.getName());
            try {
                extentTest.fail(testResult.getName());//test name that failed
                extentTest.addScreenCaptureFromPath(screenshotLocation);//screenshot as an evidence
                extentTest.fail(testResult.getThrowable());//error message
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to attach screenshot");
            }
        } else if (testResult.getStatus() == ITestResult.SUCCESS) {
            extentTest.pass(testResult.getName());
        } else if (testResult.getStatus() == ITestResult.SKIP) {
            extentTest.skip(testResult.getName());
        }
        BrowserUtilities.wait(3);
        Driver.closeDriver();
    }
}
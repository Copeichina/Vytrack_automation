package com.vytrack.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vytrack.pages.*;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected Random random;
    protected LoginPage loginPage;
    protected AccountsPage accountsPage;
    protected DashboardPage dashboardPage;
    protected CarsPage carsPage;
    protected ContactsPage contactsPage;
    protected CalendarEventsPage calendarEventsPage;
    protected WebDriverWait wait;
    protected VehiclePage vehiclePage;
    protected VehicleContractsPage vehicleContractsPage;


    protected  ExtentReports report;
    private ExtentHtmlReporter htmlReporter;
    protected static ExtentTest test;

    @BeforeSuite
    public void setUpSuite(){
        report=new ExtentReports();
        String path=System.getProperty("user.dir")+"/test-output/report.html";
        htmlReporter=new ExtentHtmlReporter(path);
        htmlReporter.config().setReportName("Vytrack Automated Tests Report");
        report.attachReporter(htmlReporter);
        report.setSystemInfo("Environment","QA");
            }

            @AfterSuite
            public void tearDownSuite(){
        report.flush();
            }

     @Parameters("url")
    @BeforeMethod
    public void setUpMethod(@Optional String url){
        random=new Random();
        driver= Driver.getDriver();
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        carsPage=new CarsPage();
        contactsPage=new ContactsPage();
        vehicleContractsPage=new VehicleContractsPage();
        accountsPage=new AccountsPage();
        calendarEventsPage=new CalendarEventsPage();
        vehiclePage=new VehiclePage();
        wait=new WebDriverWait(Driver.getDriver(),5);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().window().maximize();

        if(url==null){
            driver.get(ConfigurationReader.getProperty("url"));
        }else{
            driver.get(url);
        }

    }

    @AfterMethod
    public void tearDownMethod(ITestResult iTestResult) throws InterruptedException, IOException {
        // ITestResult gives information about current test: name, status
        // check if the test failed
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            // tell extent report that the test failed
            test.fail(iTestResult.getName());

            // take screen shot of the screen and save location
            String screenshot = BrowserUtils.getScreenshot(iTestResult.getName());
            // show path to screenshot
            test.addScreenCaptureFromPath(screenshot);
        }


//        Thread.sleep(3000);
      //  Driver.closeDriver();

    }




}

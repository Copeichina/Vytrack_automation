package com.vytrack.base;

import com.vytrack.pages.*;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected AccountsPage accountsPage;
    protected DashboardPage dashboardPage;
    protected ContactsPage contactsPage;
    protected CalendarEventsPage calendarEventsPage;
    protected WebDriverWait wait;
    protected VehiclePage vehiclePage;

    @BeforeMethod
    public void setUpMethod(){
        driver= Driver.getDriver();
        loginPage=new LoginPage();
        dashboardPage=new DashboardPage();
        contactsPage=new ContactsPage();
        accountsPage=new AccountsPage();
        calendarEventsPage=new CalendarEventsPage();
        vehiclePage=new VehiclePage();
        wait=new WebDriverWait(Driver.getDriver(),5);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.getProperty("url"));

    }
    @AfterMethod
    public void cleanUpMethod()
    {
       // Driver.closeDriver();
    }



}

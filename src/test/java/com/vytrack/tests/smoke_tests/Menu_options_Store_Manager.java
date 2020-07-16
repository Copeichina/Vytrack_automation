package com.vytrack.tests.smoke_tests;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class Menu_options_Store_Manager extends TestBase {

    @Test
    public void test() throws InterruptedException {
        //STEP - 1
        loginPage.login(ConfigurationReader.getProperty("managerUserName"),
                ConfigurationReader.getProperty("password"));

        //TODO step 2. navigate to Dashboard-->Dashboards
        dashboardPage.changeMenu("Dashboards", "Dashboard");
        //verify title
        String expectedTitle = "Dashboard - Dashboards";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        assertEquals(driver.getTitle(), expectedTitle);

        //verify page name
        String expectedPageName = "Dashboard";
        assertEquals(dashboardPage.pageHeader.getText(), expectedPageName);


        //TODO step 3 Navigate to Fleet-->Vehicles
        //STEP - 3
        dashboardPage.changeMenu("Fleet", "Vehicles");

        //verify title
        expectedTitle = "Car - Entities - System - Car - Entities - System";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        assertEquals(driver.getTitle(), expectedTitle);

        //verify page name
        expectedPageName = "All Cars";
        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader, expectedPageName));
        assertEquals(dashboardPage.pageHeader.getText(), expectedPageName);

        //STEP - 4
        dashboardPage.changeMenu("Customers", "Accounts");

        //verify title
        expectedTitle = "All - Accounts - Customers";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        assertEquals(driver.getTitle(), expectedTitle);

        //verify page name
        expectedPageName = "All Accounts";
        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader, expectedPageName));
        assertEquals(dashboardPage.pageHeader.getText(), expectedPageName);

        //STEP - 5
        dashboardPage.changeMenu("Customers", "Contacts");

        //verify title
        expectedTitle = "All - Accounts - Customers";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        assertEquals(driver.getTitle(), expectedTitle);

        //verify page name
        expectedPageName = "All Contacts";
        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader, expectedPageName));
        assertEquals(dashboardPage.pageHeader.getText(), expectedPageName);

        //STEP - 6
        dashboardPage.changeMenu("Sales", "Opportunities");

        //verify title
        expectedTitle = "Open Opportunities - Opportunities - Sales";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        assertEquals(driver.getTitle(), expectedTitle);

        //verify page name
        expectedPageName = "Open Opportunities";
        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader, expectedPageName));
        assertEquals(dashboardPage.pageHeader.getText(), expectedPageName);

        //STEP - 7
        dashboardPage.changeMenu("Activities", "Calls");

        //verify title
        expectedTitle = "All - Calls - Activities";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        assertEquals(driver.getTitle(), expectedTitle);

        //verify page name
        expectedPageName = "All Calls";
        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader, expectedPageName));
        assertEquals(dashboardPage.pageHeader.getText(), expectedPageName);

        //STEP - 8
        dashboardPage.changeMenu("Activities", "Calendar Events");

        //verify title
        expectedTitle = "All - Calendar Events - Activities"; //homework assignment has a typo in this step
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        assertEquals(driver.getTitle(), expectedTitle);

        //verify page name
        expectedPageName = "All Calendar Events";
        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader, expectedPageName));
        assertEquals(dashboardPage.pageHeader.getText(), expectedPageName);

    }

}

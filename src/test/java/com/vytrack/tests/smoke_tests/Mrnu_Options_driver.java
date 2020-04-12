package com.vytrack.tests.smoke_tests;

import com.vytrack.base.TestBase;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.VehiclePage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class Mrnu_Options_driver extends TestBase {

    @Test
    public void test() throws InterruptedException {
       loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));

        //step 2 Navigate to Fleet->Vehicles
         dashboardPage.changeMenu("Fleet","Vehicles");

       Actions actions=new Actions(driver);

       //Verify the Title
       wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//h1)[2]"))));
       String expectedTitle="Car - Entities - System - Car - Entities - System";
       wait.until(ExpectedConditions.titleIs(expectedTitle));
       String actualTitle=driver.getTitle().trim();

        assertEquals(actualTitle,expectedTitle);

        //Verify Page name
        String expectedPageName="Cars";
       String actualPageName=vehiclePage.pageHeader.getText();

       assertEquals(actualPageName,expectedPageName);

        //STEP - 3
        dashboardPage.changeMenu("Customers", "Accounts");

        //verify title
        expectedTitle = "Accounts - Customers";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        assertEquals(driver.getTitle(), expectedTitle);

        //verify page name
        expectedPageName = "Accounts";
        assertEquals(accountsPage.pageHeader.getText(), expectedPageName);

        //STEP - 4
        dashboardPage.changeMenu("Customers", "Contacts");

        //verify title
        expectedTitle = "Accounts - Customers";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        assertEquals(driver.getTitle(), expectedTitle);

        //verify page name
        expectedPageName = "Contacts";
        wait.until(ExpectedConditions.textToBePresentInElement(contactsPage.pageHeader, expectedPageName));
        assertEquals(contactsPage.pageHeader.getText(), expectedPageName);

        //STEP - 5
        dashboardPage.changeMenu("Activities", "Calendar Events");

        //verify title
        expectedTitle = "Calendar Events - Activities";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        assertEquals(driver.getTitle(), expectedTitle);

        //verify page name
        expectedPageName = "Calendar Events";
        wait.until(ExpectedConditions.textToBePresentInElement(calendarEventsPage.pageHeader, expectedPageName));
        assertEquals(calendarEventsPage.pageHeader.getText(), expectedPageName);

    }
}

package com.vytrack.tests.smoke_tests;

import com.vytrack.base.TestBase;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.VehiclePage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
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
//       test=report.createTest("Smoke Test for Driver role");
//       test.info("User logIn ");
        loginPage.login(ConfigurationReader.getProperty("driver_username"), ConfigurationReader.getProperty("driver_password"));

        //step 2 Navigate to Fleet->Vehicles
     //   test.info("Change menu from Fleet to Vehicles");
         Thread.sleep(1000);
        dashboardPage.changeMenu("Fleet", "Vehicles");

//        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),5);
//      wait.until(ExpectedConditions.alertIsPresent());

       //Verify the Title
    //    test.info("Verify the title on Vehicle page");
        String expectedTitle = "Car - Entities - System - Car - Entities - System";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        assertEquals(driver.getTitle(), expectedTitle);


        //Verify Page name
     //   test.info("Verifying the page name on Vehicle page");
        String expectedPageName="Cars";
       String actualPageName=vehiclePage.pageHeader.getText();

       assertEquals(actualPageName,expectedPageName);

        //STEP - 3
     //   test.info("Change menu from Customer to Accounts");

        dashboardPage.changeMenu("Customers", "Accounts");

        //verify title
       // test.info("Verifying title in Customers page");
        expectedTitle = "Accounts - Customers";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        assertEquals(driver.getTitle(), expectedTitle);

        //verify page name
       // test.info("Verifying page name on Accounts page");
        expectedPageName = "Accounts";
        assertEquals(accountsPage.pageHeader.getText(), expectedPageName);

        //STEP - 4
      //  test.info("Change menu from Customer to Contacts");
        dashboardPage.changeMenu("Customers", "Contacts");

        //verify title
        expectedTitle = "Accounts - Customers";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        assertEquals(driver.getTitle(), expectedTitle);

        //verify page name
        expectedPageName = "Contacts";
        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader, expectedPageName));
        assertEquals(dashboardPage.pageHeader.getText(), expectedPageName);

        //STEP - 5
        dashboardPage.changeMenu("Activities", "Calendar Events");

        //verify title
        expectedTitle = "Calendar Events - Activities";
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        assertEquals(driver.getTitle(), expectedTitle);

        //verify page name
        expectedPageName = "Calendar Events";
        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader, expectedPageName));
        assertEquals(dashboardPage.pageHeader.getText(), expectedPageName);
    }
}

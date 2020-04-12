package com.vytrack.tests.component_tests.login_navigation;

import com.vytrack.base.TestBase;
import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends TestBase {

    @Test
     public void loginTest(){
        driver.get(ConfigurationReader.getProperty("url"));
        String username= ConfigurationReader.getProperty("managerUserName");
        String password=ConfigurationReader.getProperty("password");
        loginPage.login(username,password);

        wait.until(ExpectedConditions.visibilityOf(dashboardPage.accountHolderName));
        String actual=dashboardPage.accountHolderName.getText();
        assertEquals(actual,"Karine Mohr");

        //TODO verify Dashboard page is open
        assertEquals(dashboardPage.pageHeader.getText(),"Dashboard");

        //TODO step 4 Log out
        wait.until(ExpectedConditions.elementToBeClickable(dashboardPage.dropDownlogOut));
        dashboardPage.dropDownlogOut.click();
        dashboardPage.logOut.click();

        //TODO step 5 Login as Sales Manager
       loginPage.login(ConfigurationReader.getProperty("sales_manager_username"),
               ConfigurationReader.getProperty("sales_manager_password"));

       //TODO step 6 Verify Dashboard page is open
        assertEquals(dashboardPage.pageHeader.getText(),"Dashboard");

        //TODO step 7 a different name should display on top right
        String acctHoldNameSM=dashboardPage.accountHolderName.getText();
      assertNotEquals(actual,dashboardPage.accountHolderName.getText());

      //TODO LogOut
        dashboardPage.dropDownlogOut.click();
        dashboardPage.logOut.click();

        //TODO Login as a driver
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));

        //TODO Verify Dashboard/Quick Launchpad page is open
        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader,"Quick Launchpad"));
        assertEquals(dashboardPage.pageHeader.getText(),"Quick Launchpad");

        String accHolderNameDR=dashboardPage.accountHolderName.getText();

        //TODO step 11 a different name should be displayed on top right
        assertNotEquals(accHolderNameDR,acctHoldNameSM);
    }

   // @DataProvider(name="user")



}

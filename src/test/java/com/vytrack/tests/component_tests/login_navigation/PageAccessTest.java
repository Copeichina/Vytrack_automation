package com.vytrack.tests.component_tests.login_navigation;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class PageAccessTest extends TestBase {
    public void VehicleContractsTestForStoreManager(){
        loginPage.login(ConfigurationReader.getProperty("store_manager_username"),
                ConfigurationReader.getProperty("store_manager_password"));

        wait.until(ExpectedConditions.titleIs("All Vehicle Contract"));
        dashboardPage.changeMenu("Fleet", "Vehicle Contracts");

        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader,"All Vehicle Contract"));
        Assert.assertEquals(dashboardPage.pageHeader.getText(), "All Vehicle Contract");
    }

    @Test
    public void VehicleContractsTestForSalesManager(){
        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"), ConfigurationReader.getProperty("sales_manager_password"));

        wait.until(ExpectedConditions.visibilityOf(dashboardPage.pageHeader));
        dashboardPage.changeMenu("Fleet", "Vehicle Contracts");

        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader,"All Vehicle Contract"));
        Assert.assertEquals(dashboardPage.pageHeader.getText(), "All Vehicle Contract");
    }

    @Test
    public void VehicleContractsTestForDriver(){
        loginPage.login(ConfigurationReader.getProperty("driver_username"), ConfigurationReader.getProperty("driver_password"));

        dashboardPage.changeMenu("Fleet", "Vehicle Contracts");

        Assert.assertTrue(vehicleContractsPage.alertMessage.isDisplayed());
    }


//    @Test   //(dataProvider = "users")
//    public void vehicleContractsTestStoreManager(String username,String password){
//        loginPage.login(username,password);
//        wait.until(ExpectedConditions.visibilityOf(dashboardPage.pageHeader));
//        dashboardPage.changeMenu("Fleet","Vehicle Contracts");
//        wait.until(ExpectedConditions.textToBePresentInElement(dashboardPage.pageHeader,"All Vehicle Contract"));
//        assertEquals(vehicleContractsPage.pageHeader.getText(),"All Vehicle Contract");

    //}


    @DataProvider(name="users")
    public Object[][]getUsers(){
        return new Object[][]{
                {ConfigurationReader.getProperty("store_manager_username"),
                ConfigurationReader.getProperty("store_manager_password")},
                {ConfigurationReader.getProperty("sales_manager_username"),
                        ConfigurationReader.getProperty("sales_manager_password")},
                {ConfigurationReader.getProperty("driver_username"),
                        ConfigurationReader.getProperty("driver_password")}
        };
    }
}

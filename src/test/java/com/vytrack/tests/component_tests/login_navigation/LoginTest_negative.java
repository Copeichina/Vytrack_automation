package com.vytrack.tests.component_tests.login_navigation;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTest_negative extends TestBase {

    @Test
    public void negativeLoginTest(){
        loginPage.login(ConfigurationReader.getProperty("username"),
                "InvalidPassword");

        String expectedErrorMessage = "Invalid user name or password.";
        assertTrue(loginPage.errorMessage.isDisplayed()&&loginPage.errorMessage.getText().equals(expectedErrorMessage));
        //step 5
        Assert.assertEquals(driver.getCurrentUrl(), ConfigurationReader.getProperty("url"));
    }


}

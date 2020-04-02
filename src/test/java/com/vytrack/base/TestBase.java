package com.vytrack.base;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    protected WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        driver= Driver.getDriver();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void cleanUpMethod()
    {
       // Driver.closeDriver();
    }


}

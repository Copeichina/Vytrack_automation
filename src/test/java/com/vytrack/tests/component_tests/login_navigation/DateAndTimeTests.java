package com.vytrack.tests.component_tests.login_navigation;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class DateAndTimeTests extends TestBase {

    @Test
    public void autoAdjust() throws InterruptedException {
        //STEP 1
        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"),
                ConfigurationReader.getProperty("sales_manager_password"));

        //STEP 2
        dashboardPage.changeMenu("Activities","Calendar Events");

        //STEP 3
        calendarEventsPage.createCalendarEventBtn.click();

        //STEP 4
        calendarEventsPage.startDate.clear();
        String futureDate = Integer.toString(LocalDate.now().getDayOfMonth() + 1);
        calendarEventsPage.selectDate(futureDate);

        //STEP 5
        assertEquals(calendarEventsPage.startDate.getText(),calendarEventsPage.endDate.getText());

        //STEP 6

        calendarEventsPage.todayBtn.click();

        //STEP 7
        assertEquals(calendarEventsPage.startDate.getText(),calendarEventsPage.endDate.getText());

        }

        @Test
    public void endTimeAutoAdjust(){
        //STEP 1
        loginPage.login("driver");

        //STEP 2
       dashboardPage.changeMenu("Activities","Calendar Events");

        //STEP 3
       calendarEventsPage.createCalendarEventBtn.click();

       //STEP 4
            calendarEventsPage.startTime.click();
            calendarEventsPage.selectTime("10:30 AM");

       //STEP 5
           calendarEventsPage.startDate.clear();
            String futureDate = Integer.toString(LocalDate.now().getDayOfMonth() + 1); //cheap logic
            selectDate(futureDate);






        }
    public void selectDate(String day){
        driver.findElement(By.xpath("//a[.="+day+"]")).click();
    }
           }


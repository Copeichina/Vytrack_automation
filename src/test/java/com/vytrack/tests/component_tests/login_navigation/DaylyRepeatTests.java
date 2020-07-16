package com.vytrack.tests.component_tests.login_navigation;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.AssertJUnit.*;

public class DaylyRepeatTests extends TestBase {
    Select dropdown;
    @Test
    public void summary(){
        //STEP 1
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));

        //STEP 2
        dashboardPage.changeMenu("Activities","Calendar Events");

        //STEP 3
        calendarEventsPage.createCalendarEventBtn.click();

        //STEP 4
        calendarEventsPage.repeatCheckbox.click();

        //STEP 5
        dropdown=new Select(calendarEventsPage.repeatsDropdown);
        assertEquals(dropdown.getFirstSelectedOption().getText(),"Daily");

        //STEP 6
        assertTrue(calendarEventsPage.daysCheckbox.isSelected());
        assertEquals(calendarEventsPage.numberOfDays.getAttribute("value"),"1");

        //STEP 7
        assertEquals(calendarEventsPage.summaryText.getText(),"Daily every 1 day");

        //STEP 8
        calendarEventsPage.weekdayCheckBox.click();

        //STEP 9
        assertFalse(calendarEventsPage.numberOfDays.isEnabled());

        //STEP 10
        assertEquals(calendarEventsPage.summaryText.getText(),"Daily, every weekday");

    }

    @Test
    public void defaultValues(){
        //STEP 1
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));

        //STEP 2
        dashboardPage.changeMenu("Activities","Calendar Events");

        //STEP 3
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsPage.createCalendarEventBtn));
        calendarEventsPage.createCalendarEventBtn.click();

        //STEP 4
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsPage.repeatCheckbox));
        calendarEventsPage.repeatCheckbox.click();

        //STEP 5
        dropdown=new Select(calendarEventsPage.repeatsDropdown);
        assertEquals(dropdown.getFirstSelectedOption().getText(),"Daily");

        //STEP 6
        assertTrue(calendarEventsPage.daysCheckbox.isSelected());
        assertEquals(calendarEventsPage.numberOfDays.getAttribute("value"),"1");

        //STEP 7
        assertEquals(calendarEventsPage.summaryText.getText(),"Daily every 1 day");
    }

    @Test
    public void errorMessage(){
        //STEP 1
        loginPage.login(ConfigurationReader.getProperty("driver_username"),
                ConfigurationReader.getProperty("driver_password"));

        //STEP 2
        dashboardPage.changeMenu("Activities","Calendar Events");

        //STEP 3
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsPage.createCalendarEventBtn));
        calendarEventsPage.createCalendarEventBtn.click();

        //STEP 4
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsPage.repeatCheckbox));
        calendarEventsPage.repeatCheckbox.click();

        // STEP 5 & 6
        calendarEventsPage.numberOfDays.clear();
        calendarEventsPage.numberOfDays.sendKeys("0");

        Assert.assertEquals(calendarEventsPage.daysBoundaryMessage.getText(), "The value have not to be less than 1.");

        calendarEventsPage.numberOfDays.clear();
        calendarEventsPage.numberOfDays.sendKeys("100");
        Assert.assertEquals(calendarEventsPage.daysBoundaryMessage.getText(),
                "The value have not to be more than 99.");

        //STEP 7
        calendarEventsPage.numberOfDays.clear();
        calendarEventsPage.numberOfDays.sendKeys("1");
        assertEquals(driver.findElement(By.id("temp-validation-name-418-error")).getAttribute("style"),
                "display: none;");

    }

    @Test
    public void repeatEveryDaysFunctionality(){
        //STEP 1
        loginPage.login("driver");

        //STEP 2
        dashboardPage.changeMenu("Activities","Calendar Events");

        //STEP 3
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsPage.createCalendarEventBtn));
        calendarEventsPage.createCalendarEventBtn.click();

        //STEP 4
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsPage.repeatCheckbox));
        calendarEventsPage.repeatCheckbox.click();

        //STEP 5

        calendarEventsPage.numberOfDays.clear();
        int randomNum=random.nextInt(99);
        calendarEventsPage.numberOfDays.sendKeys(randomNum+""+Keys.ENTER);

        //STEP 6
        assertEquals("Daily every "+randomNum+" days",calendarEventsPage.summaryText.getText());

        //STEP 7
        int nextRandom=random.nextInt(99);
        calendarEventsPage.numberOfDays.clear();
        calendarEventsPage.numberOfDays.sendKeys(nextRandom+""+Keys.ENTER);

        //STEP 8
        assertEquals("Daily every "+nextRandom+" days",calendarEventsPage.summaryText.getText());

    }

    @Test
    public void blankFields(){
        //STEP 1
        loginPage.login("driver");

        //STEP 2
        dashboardPage.changeMenu("Activities","Calendar Events");

        //STEP 3
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsPage.createCalendarEventBtn));
        calendarEventsPage.createCalendarEventBtn.click();

        //STEP 4
        wait.until(ExpectedConditions.elementToBeClickable(calendarEventsPage.repeatCheckbox));
        calendarEventsPage.repeatCheckbox.click();

        //STEP 5
        calendarEventsPage.numberOfDays.clear();

        //STEP 6
        assertEquals(calendarEventsPage.daysBoundaryMessage.getText(),"This value should not be blank.");

        //STEP 7
        calendarEventsPage.numberOfDays.sendKeys(random.nextInt(99)+"");

        //STEP 8
        assertEquals(driver.findElement(By.id("temp-validation-name-418-error")).getAttribute("style"),
                "display: none;");

        //STEP 9
      calendarEventsPage.afterOccurrencesInput.click();
      calendarEventsPage.afterOccurrencesInput.sendKeys("0");
      calendarEventsPage.afterOccurrencesInput.clear();
      calendarEventsPage.afterOccurrencesInput.click();
        //STEP 10
       assertEquals("This value should not be blank.",calendarEventsPage.afterOccurMessage.getText());

        //STEP 11




    }
}

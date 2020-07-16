package com.vytrack.pages;

import com.vytrack.base.PageBase;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends PageBase {
    public CalendarEventsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='btn main-group btn-primary pull-right ']")
    public WebElement createCalendarEventBtn;

    @FindBy(xpath = "//input[starts-with(@id,'recurrence-repeat')]")
    public WebElement repeatCheckbox;

    @FindBy(xpath = "(//select)[1]")
    public WebElement repeatsDropdown;

    @FindBy(xpath = "//input[@type='radio']")
    public WebElement daysCheckbox;

    @FindBy(xpath = "//span[contains(text(),'day(s)')]/preceding-sibling::input[@class]")
    public WebElement numberOfDays;

    @FindBy(xpath = "//div[@data-name='recurrence-summary']/div/span")
    public WebElement summaryText;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement weekdayCheckBox;

    @FindBy(xpath= "//span[@class='validation-failed']/span/span")
    public WebElement daysBoundaryMessage;

    @FindBy(xpath = "//input[@placeholder='Choose a date']")
    public WebElement startDate;

    @FindBy(xpath = "(//input[@placeholder='Choose a date'])[2]")
    public WebElement endDate;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td")
    public List<WebElement> calendarDates;

    public void selectDate(String day){
        Driver.getDriver().findElement(By.xpath("//a[.="+day+"]")).click();
    }

    @FindBy(xpath = "//button[@data-handler='today']")
    public WebElement todayBtn;

    @FindBy(xpath = "//input[@data-related-field='occurrences']")
    public WebElement afterOccurrencesInput;

    @FindBy(xpath = "//span[@class='validation-failed']/span/*")
    public WebElement afterOccurMessage;


    public void selectTime(String time) {
        List<WebElement> timesAM = Driver.getDriver().findElements(By.xpath("//li[@class='ui-timepicker-am']"));
        List<WebElement> timesPM =Driver.getDriver().findElements(By.xpath("//li[@class='ui-timepicker-pm']"));
        for (WebElement t : timesAM) {
            if (t.getText().equals(time)) {
                t.click();
            }
        }

        for (WebElement t : timesPM) {
            if (t.getText().equals(time)) {
                t.click();
            }
        }
    }
    @FindBy(xpath = "//input[@placeholder='time']")
    public WebElement startTime;

    @FindBy(xpath = "//input[@placeholder='time'][2]")
    public WebElement endTime;



}

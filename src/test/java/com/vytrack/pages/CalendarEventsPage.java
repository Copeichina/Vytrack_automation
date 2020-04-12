package com.vytrack.pages;

import com.vytrack.base.PageBase;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class CalendarEventsPage extends PageBase {
    public CalendarEventsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}

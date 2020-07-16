package com.vytrack.pages;

import com.vytrack.base.PageBase;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends PageBase {
    public ContactsPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
}

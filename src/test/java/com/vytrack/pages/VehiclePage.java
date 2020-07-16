package com.vytrack.pages;

import com.vytrack.base.PageBase;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class VehiclePage extends PageBase {
    public VehiclePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}

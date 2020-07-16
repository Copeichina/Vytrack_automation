package com.vytrack.pages;

import com.vytrack.base.PageBase;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleContractsPage extends PageBase {
    public VehicleContractsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//div[contains(text(), 'You do not have permission to perform this action.')]")
    public WebElement alertMessage;
}

package com.vytrack.pages;

import com.vytrack.base.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarsPage extends PageBase {

    @FindBy(xpath = "//a[@title='Create Car']")
    public WebElement createCarBtn;

    @FindBy(xpath = "//input[starts-with(@id,'custom_entity_type_LicensePlate-uid')]")
    public WebElement licencePlateInput;

    @FindBy(xpath = "//input[@name='custom_entity_type[Tags][]']")
   public List<WebElement> tagsCxBoxList;

    @FindBy(xpath = "//input[@name='custom_entity_type[Driver]']")
   public WebElement driverInput;

    @FindBy(xpath = "//input[@name='custom_entity_type[Location]']")
   public WebElement locationInput;

    @FindBy(xpath = "//input[@name='custom_entity_type[ModelYear]']")
   public WebElement modelYearInput;

    @FindBy(xpath = "//input[@name='custom_entity_type[SeatsNumber]']")
   public WebElement seatNumberInput;

    @FindBy(xpath = "//input[@name='custom_entity_type[DoorsNumber]']")
   public WebElement doorsNumInput;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement saveAndCloseBtn;

    @FindBy(xpath = "(//span[contains(text(),'License Plate')])[2]")
    public WebElement licencePlateBtn;

    @FindBy(xpath = "(//span[contains(text(),'Driver')])[2]")
    public WebElement driverBtn;
}

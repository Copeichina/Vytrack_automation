package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

public LoginPage() {
    PageFactory.initElements(Driver.getDriver(), this);

}
    @FindBy(id = "prependedInput")
    public WebElement username;

     @FindBy(id="prependedInput2")
    public WebElement password;

     @FindBy(id="_submit")
    public WebElement logIn;

     @FindBy(xpath = "//div[@class='alert alert-error']/div")
     public WebElement errorMessage;

     public void login(String username,String password){
         this.username.sendKeys(username);
         this.password.sendKeys(password);
         logIn.click();
     }

    public void login(String user) {
        String username;
        String password;
        switch (user) {
            case "driver":
                username = ConfigurationReader.getProperty("driver_username");
                password = ConfigurationReader.getProperty("driver_password");
                this.username.sendKeys(username);
                this.password.sendKeys(password);
                this.logIn.click();
                break;
            case "store_manager":
                username = ConfigurationReader.getProperty("store_manager_username");
                password = ConfigurationReader.getProperty("store_manager_password");
                this.username.sendKeys(username);
                this.password.sendKeys(password);
                this.logIn.click();
                break;
            case "sales_manager":
                username = ConfigurationReader.getProperty("sales_manager_username");
                password = ConfigurationReader.getProperty("sales_manager_password");
                this.username.sendKeys(username);
                this.password.sendKeys(password);
                this.logIn.click();
                break;
            default:
                System.out.println("ERROR: Invalid user type provided!");

        }
    }


}

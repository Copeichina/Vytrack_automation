package com.vytrack.pages;

import com.vytrack.base.PageBase;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends PageBase {
  public  DashboardPage(){
      PageFactory.initElements(Driver.getDriver(),this);
  }

}

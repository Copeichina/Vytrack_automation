package com.vytrack.tests.smoke_tests;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MenuOptionsTest extends TestBase {

    @Test
    public void test() throws InterruptedException {
        String url= ConfigurationReader.getProperty("url");
        driver.get(url);
        String username=ConfigurationReader.getProperty("username");
        String password=ConfigurationReader.getProperty("password");

        WebElement submitBtn=driver.findElement(By.id("_submit"));
        WebElement usernameBar=driver.findElement(By.id("prependedInput"));
        usernameBar.sendKeys(username);
        WebElement passwordBar=driver.findElement(By.id("prependedInput2"));
        passwordBar.sendKeys(password);
        submitBtn.click();

        //locate fleet
        WebElement fleet=driver.findElement(By.cssSelector(".title.title-level-1"));
        //create an explicit wait object
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(fleet));
        fleet.click();

       Actions actions=new Actions(driver);

       WebElement vehicle=driver.findElement(By.cssSelector(".dropdown-menu-single-item"));
       actions.click(vehicle).perform();

       wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//h1)[2]"))));
       WebElement pageName=driver.findElement(By.xpath("(//h1)[2]"));
       String expectedTitle="Car - Entities - System - Car - Entities - System";

        //wait.until(ExpectedConditions.titleContains(expectedTitle));
        Thread.sleep(4000);
        String actualTitle=driver.getTitle().trim();
        System.out.println("Expected "+expectedTitle);
        System.out.println("Actual "+actualTitle);
        Assert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));

        String expectedPageName="Cars";
        WebElement cars=driver.findElement(By.xpath("(//h1)[2]"));
       wait.until(ExpectedConditions.visibilityOf(cars));
       String actualPageName=cars.getText();
       // System.out.println(actualPageName);

       Assert.assertTrue(expectedPageName.equalsIgnoreCase(actualPageName));

        //locate webElement Customers
      WebElement customers=driver.findElement(By.xpath("(//li/a/span)[9]"));
      actions.click(customers).perform();
        System.out.println(customers.getText());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//li/a/span)[10]"))));
      WebElement accounts=driver.findElement(By.xpath("(//li/a/span)[10]"));
      //  System.out.println(accounts.getText());
      //click on Accounts
      actions.click(customers).pause(2).moveToElement(accounts).pause(2).click(accounts).build().perform();
      wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[@class='oro-subtitle']"))));
      WebElement accountsPageName=driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));

      String expectedAccPageTitle="Accounts - Customers";
        wait.until(ExpectedConditions.titleContains("Accounts"));
      String actualAccPageTitle=driver.getTitle();
       //verify page title on Accounts page
      Assert.assertTrue(expectedAccPageTitle.equalsIgnoreCase(actualAccPageTitle));


      actions.moveToElement(customers).pause(10).click(customers).build().perform();
      //click on Contacts
      wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a/span)[11]"))));
       WebElement contacts=driver.findElement(By.xpath("(//a/span)[11]"));
       actions.moveToElement(customers).pause(1).moveToElement(contacts).pause(2).click(contacts).build().perform();

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h1)[2]")));
      // wait.until(ExpectedConditions.textToBe(By.xpath("(//a/span)[11]"),"Contacts"));
      String expectedContactTitle="Contacts - Customers";
//       wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//h1)[2]"))));
      WebElement pageNameContacts=driver.findElement(By.xpath("(//h1)[2]"));


        wait.until(ExpectedConditions.titleIs("Contacts - Customers"));
        String actualTitleContacts=driver.getTitle();
        System.out.println(actualTitleContacts);

        Assert.assertTrue(expectedContactTitle.equalsIgnoreCase(actualTitleContacts));

        String actualPageContacts=contacts.getText();
        String expectedPageContacts="Contacts";
        //verify the page name of Contacts
        Assert.assertTrue(expectedPageContacts.equalsIgnoreCase(expectedPageContacts));

        //step 5 Navigate to Activities
        WebElement activities=driver.findElement(By.xpath("(//span[@class='title title-level-1'])[3]"));
        actions.moveToElement(activities).pause(2).click(activities).build().perform();

        wait.until(ExpectedConditions.textToBe(By.xpath("(//span[@class='title title-level-2'])[10]"),"Calendar Events"));
        WebElement calendarEvents=driver.findElement(By.xpath("(//span[@class='title title-level-2'])[10]"));
        actions.pause(3).moveToElement(calendarEvents).pause(2).click(calendarEvents).build().perform();

        String expectedTitleCalendar="Calendar Events - Activities";
        wait.until(ExpectedConditions.titleIs(expectedTitleCalendar));
        String actualTitleCalendar=driver.getTitle();
        //System.out.println(actualTitleCalendar);
        //verify if Title of Calendar Events
        Assert.assertTrue(expectedTitleCalendar.equalsIgnoreCase(actualTitleCalendar));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//h1)[2]")));
        WebElement calendarEventsPage=driver.findElement(By.xpath("(//h1)[2]"));
        String expectedPageNameEvents="Calendar Events";
        wait.until(ExpectedConditions.textToBe(By.xpath("(//h1)[2]"),expectedPageNameEvents));
        String actualPageNameEvents=calendarEventsPage.getText();
        //verify the page name Calendar WEvents
        Assert.assertTrue(expectedPageNameEvents.equalsIgnoreCase(actualPageNameEvents));




    }
}

package com.vytrack.tests.component_tests.fleet;

import com.vytrack.base.TestBase;
import com.vytrack.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class Vehicles extends TestBase {

   private FileInputStream fileInputStream;
   private Workbook workbook;
   Sheet workSheet;



    private String filePath="src/main/resources/MOCK_DATA (3).xlsx";
    private String sheetName="data";

    public void generateCars() {
        ExcelUtil exeldata = new ExcelUtil(filePath, sheetName);
        String data[][] = exeldata.getDataArray();
        for (int i = 1; i < data.length; i++) {

            carsPage.createCarBtn.click();
            carsPage.licencePlateInput.sendKeys(data[i][0]);
            carsPage.driverInput.sendKeys(data[i][1]);
            carsPage.locationInput.sendKeys(data[i][2]);
            carsPage.modelYearInput.sendKeys(data[i][3]);
            carsPage.seatNumberInput.sendKeys(data[i][4]);
            carsPage.doorsNumInput.sendKeys(data[i][5]);
            carsPage.saveAndCloseBtn.click();

            dashboardPage.changeMenu("Fleet", "Vehicles");
        }
    }
    @Test
    public void defaultOrder() throws InterruptedException {
        //STEP 1
        loginPage.login("store_manager");

        //STEP 2
        dashboardPage.changeMenu("Fleet","Vehicles");

        //STEP 3
        carsPage.licencePlateBtn.click();
        //checking ascending order
        List<String>actualLicencePlate=getActualLicencePlates();
        for (int i = 0; i < actualLicencePlate.size()-1; i++) {
            Assert.assertTrue(actualLicencePlate.get(i).compareTo(actualLicencePlate.get(i+1))<0);
        }

        //STEP 4
        carsPage.licencePlateBtn.click();

        //STEP 5
        //checking descending order
        actualLicencePlate=getActualLicencePlates();
        for(int i=actualLicencePlate.size()-1;i>0;i--){
            assertTrue(actualLicencePlate.get(i).compareTo(actualLicencePlate.get(i-1))<0);
        }

    }

    @Test
    public void sortByDriver() throws InterruptedException {
        //STEP 1
        loginPage.login("store_manager");

        //STEP 2
        dashboardPage.changeMenu("Fleet","Vehicles");

        //STEP 3
        carsPage.driverBtn.click();

        //STEP 4
        //ascending order
        List<String>listDrivers=getDriverList();
        //System.out.println(listDrivers);
        for (int i = 0; i <listDrivers.size()-1 ; i++) {
            assertTrue(listDrivers.get(i).compareTo(listDrivers.get(i+1))<0);
        }

        //STEP 5
        carsPage.driverBtn.click();

        //STEP 6
        listDrivers=getDriverList();
        for(int i=listDrivers.size()-1;i>0;i--){
            assertTrue(listDrivers.get(i).compareTo(listDrivers.get(i-1))<0);
        }


    }
    public static String getCellXpathByIndex(int row, int column) {
        String xpath = "//tbody/tr["+row+"]/td["+column+"]";
        return xpath;
    }

    public List<String> getActualLicencePlates() throws InterruptedException {
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        List<String> actualLicensePlates = new ArrayList<>();
        for (int i = 1; i < rows.size()+1 ; i++) {
            Thread.sleep(1000);
            actualLicensePlates.add(driver.findElement(By.xpath(getCellXpathByIndex(i,2))).getText());
        }
        System.out.println(actualLicensePlates);
        return actualLicensePlates;
    }
    public List<String> getDriverList() throws InterruptedException {
        List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
        List<String> actualLicensePlates = new ArrayList<>();
        for (int i = 1; i < rows.size()+1 ; i++) {
            Thread.sleep(1000);
            actualLicensePlates.add(driver.findElement(By.xpath(getCellXpathByIndex(i,4))).getText());
        }

        return actualLicensePlates;
    }

        }




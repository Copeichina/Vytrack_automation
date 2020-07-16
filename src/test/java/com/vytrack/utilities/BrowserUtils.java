package com.vytrack.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class BrowserUtils {

    /*
    takes a list of web elements
    returns a list of strings
     */
    public static List<String> getElementsText(List<WebElement>listEl){
        //given a list web elements,extract the text of the elements into new list of Strings
        List<String>listSt=new ArrayList<>();
        for(WebElement element:listEl){
            listSt.add(element.getText());
        }
        return listSt;
    }
    /*
    This method takes a list of String and returns a List of Integer
     */
    public static List<Integer>getIntegerList(List<String>liststr){
        List<Integer>list=new ArrayList<>();
        for (String each:liststr ) {
            list.add(Integer.parseInt(each));
                  }
        return list;
    }

    /*
     * takes screenshot
     * @param name
     * take a name of a test and returns a path to screenshot takes
     */
    public static String getScreenshot(String name) throws IOException {
        // name the screenshot with the current date time to avoid duplicate name
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot ---> interface from selenium which takes screenshots
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-output/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    //checkListOrdered checks if list ordered
    public static boolean checkListOrdered(List<WebElement>elements){
        List<String>elements1= new ArrayList<>();
        List<String>elements2= new ArrayList<>();
        for(WebElement n:elements){
            elements1.add(n.getText().toLowerCase());
            elements2.add(n.getText().toLowerCase());
        }
        Collections.sort(elements2);
        return elements1.equals(elements2);
    }

    //checkReverseOrdered check if list reverse ordered
    public static boolean checkListReverseOrdered(List<WebElement>elements){
        List<String>elements1= new ArrayList<>();
        List<String>elements2= new ArrayList<>();
        for(WebElement n:elements){
            elements1.add(n.getText().toLowerCase());
            elements2.add(n.getText().toLowerCase());
        }
        Collections.sort(elements2);
        Collections.reverse(elements2);
        return elements1.equals(elements2);
    }
}


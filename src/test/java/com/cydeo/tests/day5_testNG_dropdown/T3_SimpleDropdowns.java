package com.cydeo.tests.day5_testNG_dropdown;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_SimpleDropdowns {



    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
      //  1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void simpleDropDown(){
     //   2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

     //   3. Verify “Simple dropdown” default selected value is correct
        //   Expected: “Please select an option”
        Select simpleDropDown = new Select(driver.findElement(By.id("dropdown")));

        String actualSimpleDropDown = simpleDropDown.getFirstSelectedOption().getText();
        String expectedSimpleDropDown = "Please select an option";

        Assert.assertEquals(actualSimpleDropDown,expectedSimpleDropDown);


     //   4. Verify “State selection” default selected value is correct
     //   Expected: “Select a State”
        Select stateSelection = new Select(driver.findElement(By.id("state")));

        String actualStateSelection = stateSelection.getFirstSelectedOption().getText();
        String expectedStateSelection = "Select a State";

        Assert.assertEquals(actualSimpleDropDown, expectedSimpleDropDown);

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}

package com.cydeo.tests.day5_testNG_dropdown.homework;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T4_T5_T6_T7 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        // 1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void selectState() {
        //    2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");

        //    3. Select Illinois
        Select stateDropDown = new Select(driver.findElement(By.id("state")));
        stateDropDown.selectByVisibleText("Illinois");

        //    4. Select Virginia
        stateDropDown.selectByValue("VA");

        //    5. Select California
        stateDropDown.selectByIndex(5);

        //    6. Verify final selected option is California.
        //    Use all Select options. (visible text, value, index)
        String expected = "California";
        String actual = stateDropDown.getFirstSelectedOption().getText();

        Assert.assertEquals(actual, expected);

    }

    @Test
    public void selectDate() {
        //  2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //  3. Select “December 1st, 1923” and verify it is selected.
        //  Select year using   : visible text
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("1923");

        //  Select month using    : value attribute Select
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        month.selectByValue("11");

        //  day using : index number
        Select day = new Select(driver.findElement(By.id("day")));
        day.selectByIndex(0);

        String expectedYear = "1923";
        String actualYear = year.getFirstSelectedOption().getText();
        Assert.assertEquals(actualYear, expectedYear);

        String expectedMonth = "December";
        String actualMonth = month.getFirstSelectedOption().getText();
        Assert.assertEquals(actualMonth, expectedMonth);

        String expectedDay = "1";
        String actualDay = day.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDay, expectedDay);

    }


    @Test
    public void nonSelectDropDown() {
        // 2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        // 3. Click to non-select dropdown
        WebElement dropDownLink = driver.findElement(By.id("dropdownMenuLink"));
        dropDownLink.click();
        //  Select website = new Select(driver.findElement(By.xpath("//div[@class='dropdown-menu']")));
        WebElement facebook = driver.findElement(By.xpath("//a[text()='Facebook']"));
        facebook.click();

        // 4. Select Facebook from dropdown
        //  website.deselectByVisibleText("Facebook");

        // 5. Verify title is “Facebook - Log In or Sign Up”
        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }


    @Test
    public void multipleSelectDropDown() {
        //  2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //  3. Select all the options from multiple select dropdown.

        Select languages = new Select(driver.findElement(By.xpath("//select[@name = 'Languages']")));

        for (int i = 0; i < languages.getOptions().size(); i++) {
            languages.selectByIndex(i);
        }

        List<WebElement> selectedLanguages = languages.getAllSelectedOptions();
        for (WebElement each: selectedLanguages){
            System.out.println(each.getText());
        }

        //  5. Deselect all values.
        languages.deselectAll();
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
}

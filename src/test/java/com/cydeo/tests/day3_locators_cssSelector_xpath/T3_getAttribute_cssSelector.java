package com.cydeo.tests.day3_locators_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_cssSelector {
    public static void main(String[] args) {
     //   1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

     //   2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

     //   3- Verify “Log in” button text is as expected: Expected: Log In
        WebElement loginText = driver.findElement(By.cssSelector("input[type='submit']"));

        String expectedText = "Log In";
        String actualText = loginText.getAttribute("value");

        if (actualText.equals(expectedText)){
            System.out.println("Login text verification PASS!");
        } else {
            System.out.println("Login text verification FAILED!");
        }

        driver.quit();






    }
}

package com.cydeo.tests.day3_locators_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_Locators_getText {
    public static void main(String[] args) {

        // 1. Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        // 2. Go to : https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        // 3. Enter incorrect username: “incorrect”
        WebElement login = driver.findElement(By.name("USER_LOGIN"));
        login.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("incorrect");

        //5- Click to login button.
        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();

        //6- Verify error message text is as expected:
        String expectedMsg = "Incorrect login or password";
        String actualMsg = driver.findElement(By.className("errortext")).getText();

        if (expectedMsg.equals(actualMsg)){
            System.out.println("Error message verification PASSED!");
        } else{
            System.out.println("Error message verification FAILED!");
        }

        driver.quit();

        //Expected: Incorrect login or password


    }
}

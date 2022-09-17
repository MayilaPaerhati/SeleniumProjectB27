package com.cydeo.tests.day2_locators_getText_getAttribute.home_work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_BackAndForthNavigation {
    public static void main(String[] args) {
        // 1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2- Go to: https://google.com
        driver.get("https://google.com");

        // 3- Click to Gmail from top right.
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        gmailLink.click();

        //  4- Verify title contains: Expected: Gmail
        String expectTitle = "Gmail";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectTitle)){
            System.out.println("Gmail title verification PASSED!");
        } else {
            System.out.println("Gmail title verification FAILED!");
        }

        // 5- Go back to Google by using the .back();
        driver.navigate().back();

        //  6- Verify title equals: Expected: Google
        expectTitle = "Google";
        actualTitle = driver.getTitle();

        if (actualTitle.equals(expectTitle)){
            System.out.println("Google title verification PASSED!");
        } else {
            System.out.println("Google title verification FAILED!");
        }

        driver.quit();
    }
}

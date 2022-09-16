package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {
    public static void main(String[] args) {

        /*
        TC #1: Cydeo practice tool verifications
              1. Open Chrome browser
              2. Go to https://practice.cydeo.com
              3. Verify URL contains
                 Expected: cydeo
              4. Verify title:
                 Expected: Practice
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://practice.cydeo.com");

        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains("cydeo")){
            System.out.println("URL verification is PASSED!");
        } else {
            System.out.println("URL verification is FAILED!");
        }

        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification is PASSED!");
        }else{
            System.out.println("Title verification is FAILED!");
        }

        driver.close();
    }
}

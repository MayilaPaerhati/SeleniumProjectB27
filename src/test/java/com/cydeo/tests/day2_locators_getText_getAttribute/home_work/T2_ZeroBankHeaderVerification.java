package com.cydeo.tests.day2_locators_getText_getAttribute.home_work;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_ZeroBankHeaderVerification {
    public static void main(String[] args) {
        //  1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //  3. Verify header text Expected: “Log in to ZeroBank”
        WebElement header = driver.findElement(By.tagName("h3"));

        String actualHeader = header.getText();
        String expectHeader = "Log in to ZeroBank";

        if (actualHeader.equals(expectHeader)){
            System.out.println("Header verification PASSED!");
        } else {
            System.out.println("Header verification FAILED!");
        }

        driver.quit();

    }
}

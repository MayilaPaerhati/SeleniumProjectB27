package com.cydeo.tests.day4_xpath_findElements_checkbox;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T6_HomeWork {
    public static void main(String[] args) {
        //   USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS

     //   1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("CHROME");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

     //   2. Go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons ");

     //   3. Click on Button 1
        WebElement button1 = driver.findElement(By.xpath("//button[text() = 'Button 1']"));
        button1.click();

     //   4. Verify text displayed is as expected: Expected: “Clicked on button one!”
        WebElement button1Text = driver.findElement(By.xpath("//p[@id ='result']"));
        String actualText = button1Text.getText();
        String expected = "Clicked on button one!";

        if (actualText.equals(expected)){
            System.out.println("PASS!");
        } else {
            System.out.println("FAILED");
        }

        driver.quit();


    }
}

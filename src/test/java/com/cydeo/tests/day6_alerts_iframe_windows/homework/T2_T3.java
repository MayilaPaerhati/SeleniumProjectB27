package com.cydeo.tests.day6_alerts_iframe_windows.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T2_T3 {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts ");
    }

    @Test
    public void confirmationAlertT2(){

    //    3. Click to “Click for JS Confirm” button
        WebElement jsConfirmBtn = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        jsConfirmBtn.click();

    //    4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

    //    5. Verify “You clicked: Ok” text is displayed.
        String actualText = driver.findElement(By.id("result")).getText();
        String expectedText = "You clicked: Ok";

        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void confirmationAlertT3(){

     //   3. Click to “Click for JS Prompt” button
        WebElement jsPromptBtn = driver.findElement(By.xpath("//button[text() = 'Click for JS Prompt']"));
        jsPromptBtn.click();

     //   4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

     //   5. Click to OK button from the alert
        alert.accept();

     //   6. Verify “You entered:  hello” text is displayed.
        String actualText = driver.findElement(By.id("result")).getText();
        String expectedText = "You entered: hello";
        Assert.assertEquals(actualText, expectedText);
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }
}

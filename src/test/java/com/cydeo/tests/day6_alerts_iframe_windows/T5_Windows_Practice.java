package com.cydeo.tests.day6_alerts_iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_Windows_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/windows");
    }

    @Test
    public void windowsTask() {

        //   4. Assert: Title is “Windows”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";

        Assert.assertEquals(actualTitle, expectedTitle);

        System.out.println("Before opening new window: " + actualTitle);

        //   5. Click to: “Click Here” link
        WebElement clickHereBtn = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereBtn.click();

        actualTitle = driver.getTitle();
        System.out.println("After opening new window: " + actualTitle);

        //   6. Driver still in the previous page, we need to Switch to new Window.
        //   driver.getWindowHandles();  // it stores all the windows

        for (String eachWindow : driver.getWindowHandles()) {
            driver.switchTo().window(eachWindow);
            System.out.println("eachWindow = " + eachWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }

        //   7. Assert: Title is “New Window”
        actualTitle = driver.getTitle();
        expectedTitle = "New Window";

        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @AfterMethod
    public void tearDownMethod() {
        driver.quit();
    }
}

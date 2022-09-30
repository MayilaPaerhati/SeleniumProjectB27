package com.cydeo.tests.crm_us10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TC1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // go to https://login2.nextbasecrm.com/
        driver.get("https://login2.nextbasecrm.com/");

        // login as hr4@cydeo.com (password:UserUser)
        WebElement login = driver.findElement(By.name("USER_LOGIN"));
        login.sendKeys("hr4@cydeo.com");

        WebElement password = driver.findElement(By.name("USER_PASSWORD"));
        password.sendKeys("UserUser");

        WebElement loginBtn = driver.findElement(By.className("login-btn"));
        loginBtn.click();

        // click the TASK tab
        WebElement task = driver.findElement(By.id("feed-add-post-form-tab-tasks"));
        task.click();

        // write task titles
        WebElement taskTitle = driver.findElement(By.xpath("//input[@name='ACTION[0][ARGUMENTS][data][TITLE]']"));
        taskTitle.sendKeys("Automation US10");

        // write task content
        WebElement taskContent = driver.findElement(By.cssSelector("body[style = 'min-height: 84px;']"));
        taskContent.sendKeys("Do automation testing on my user story");

        // click SEND
        WebElement sendBtn = driver.findElement(By.id("blog-submit-button-save"));
        sendBtn.click();






    }
}

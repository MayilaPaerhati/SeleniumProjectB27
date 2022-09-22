package com.cydeo.tests.day3_locators_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_homework {
    public static void main(String[] args) {
        //  1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();

        //  2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //  3- Enter incorrect username into login box:
        WebElement inputUsername = driver.findElement(By.cssSelector("input[name='USER_LOGIN']"));
        inputUsername.sendKeys("incorrect");

        //  4- Click to `Reset password` button
        WebElement resetPasswordBtn = driver.findElement(By.cssSelector("button.login-btn"));
        resetPasswordBtn.click();

        //  5- Verify “error” label is as expected. Expected: Login or E-mail not found
        WebElement errorLabel = driver.findElement(By.cssSelector("div.errortext"));
        String expectedErrorLabel = "Login or E-mail not found";
        String actualErrorLabel = errorLabel.getText();

        if (actualErrorLabel.equals(expectedErrorLabel)){
            System.out.println("Error label verification PASSED!");
        } else {
            System.out.println("Error label verification FAILED!");
        }

        driver.quit();

    }
}

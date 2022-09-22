package com.cydeo.tests.day3_locators_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {
    public static void main(String[] args) {
        // 1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        // 3- Verify “remember me” label text is as expected: Expected: Remember me on this computer
        WebElement RememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));
        String expectedRememberMeLabel = "Remember me on this computer";
        String actualRememberMeLabel = RememberMeLabel.getText();

        if (actualRememberMeLabel.equals(expectedRememberMeLabel)){
            System.out.println("Remember me label verification PASSED!");
        }else{
            System.out.println("Remember me label verification FAILED");
        }

        // 4-Verify “forgot password”  link text is as expected: Expected: FORGOT YOUR PASSWORD?
        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String expectedForgotPasswordLink = "FORGOT YOUR PASSWORD?";
        String actualForgotPasswordLink = forgotPasswordLink.getText();

        if (actualForgotPasswordLink.equals(expectedForgotPasswordLink)){
            System.out.println("Forgot password link verification PASSED!");
        } else {
            System.out.println("Forgot password link verification FAILED!");
            System.out.println("expectedForgotPasswordLink = " + expectedForgotPasswordLink);
            System.out.println("actualForgotPasswordLink = " + actualForgotPasswordLink);
        }



        // 5-Verify “forgot password”  href attribute’s value contains expected: Expected:forgot_password=yes
        String expectedHref = "forgot_password=yes";
        String actualHref = forgotPasswordLink.getAttribute("href");

        if (actualHref.contains(expectedHref)){
            System.out.println("Href attribute value verification PASSED!");
        } else {
            System.out.println("Href attribute value verification FAILED");
        }

        driver.quit();


    }
}

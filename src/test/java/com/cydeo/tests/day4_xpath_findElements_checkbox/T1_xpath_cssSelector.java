package com.cydeo.tests.day4_xpath_findElements_checkbox;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector {
    public static void main(String[] args) {
      //  1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

      //  2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

      //  3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)

      //  a. “Home” link
        // with CSS class attribute
        WebElement homeLink1 = driver.findElement(By.cssSelector("a.nav-link"));
        // with CSS class attribute
        WebElement homeLink2 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        // with xpath class attribute
        WebElement homeLink3 = driver.findElement(By.xpath("// a[@class='nav-link']"));
        // with xpath text
        WebElement homeLink4 = driver.findElement(By.xpath("// a[text()='Home']"));
        WebElement homeLink5 = driver.findElement(By.xpath("// a[.='Home']"));


      //  b. “Forgot password” header
        // with CSS class attribute
        WebElement header1 = driver.findElement(By.cssSelector("div[class='example']>h2"));
        // with xpath
        WebElement header2 = driver.findElement(By.xpath("//div[@class='example']/h2"));
        // with locator class attribute
        WebElement header3 = driver.findElement(By.className("example"));

      //  c. “E-mail” text
        // with CSS for attribute
        WebElement emailText1 = driver.findElement(By.cssSelector("label[for='email']"));
        // with xpath for attribute
        WebElement emailText2 = driver.findElement(By.xpath("//label[@for='email']"));
        // with xpath text
        WebElement emailText3 = driver.findElement(By.xpath("//label[.='E-mail']"));

      //  d. E-mail input box
        // with CSS type att
        WebElement emailInputBox1 = driver.findElement(By.cssSelector("input[type='text']"));
        // with CSS name att
        WebElement emailInputBox2 = driver.findElement(By.cssSelector("input[name='email']"));
        // with xpath type att
        WebElement emailInputBox3 = driver.findElement(By.xpath("//input[@type='text']"));
        // with xpath name att
        WebElement emailInputBox4 = driver.findElement(By.xpath("//input[@name='email']"));
        // with xpath contains
        WebElement emailInputBox5 = driver.findElement(By.xpath("//input[contains(@pattern, 'a-z')]"));

      //  e. “Retrieve password” button
        // with CSS class att
        WebElement button1 = driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));
        // with xpath text
        WebElement button2 = driver.findElement(By.xpath("//i[text()='Retrieve password']"));
        // with CSS button att
        WebElement button3 = driver.findElement(By.cssSelector("button#form_submit>i"));

      //  f. “Powered by Cydeo text
        // with CSS style att
        WebElement poweredText1 = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        // with xpath style att
        WebElement poweredText2 = driver.findElement(By.xpath("//div[@style='text-align: center;']"));


      //  4. Verify all web elements are displayed.
        // isDisplayed() method return to boolean true/false
        System.out.println("homeLink1.isDisplayed() = " + homeLink1.isDisplayed());
        System.out.println("header1.isDisplayed() = " + header1.isDisplayed());
        System.out.println("emailInputBox5.isDisplayed() = " + emailInputBox5.isDisplayed());
        System.out.println("button3.isDisplayed() = " + button3.isDisplayed());
        System.out.println("poweredText1.isDisplayed() = " + poweredText1.isDisplayed());

        driver.quit();

    }
}

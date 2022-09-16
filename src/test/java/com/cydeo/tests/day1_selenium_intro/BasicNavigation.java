package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {

        //1. set up web driver manager
        WebDriverManager.chromedriver().setup();

        //2. opening an empty browser with creating instance drive
        WebDriver driver = new ChromeDriver();

        // making window full screen/maximizing
        driver.manage().window().maximize();

        //3. go to https://www.tesla.com/
    //    driver.get("https://www.tesla.com/");

       // navigate().to() is loading url in browser
        driver.navigate().to("https://www.tesla.com/");

        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);


        // stop execution of code for 3 sec.
        Thread.sleep(3000);

        // navigate().back() method will take  to previous page
        driver.navigate().back();

        Thread.sleep(3000);

        // navigate().forward() method will
        driver.navigate().forward();

        Thread.sleep(3000);

        driver.navigate().refresh();



        driver.navigate().to("https://www.google.com");
        // System.out.println("driver.getTitle() = " + driver.getTitle());

        currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);





        Thread.sleep(3000);
        // close() method will close current opened page
        // driver.close();

        //quit() method will close all opened pages
        driver.quit();



    }
}

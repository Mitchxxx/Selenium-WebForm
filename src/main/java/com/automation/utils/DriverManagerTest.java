package com.automation.utils;

import org.openqa.selenium.WebDriver;

public class DriverManagerTest {
    public static void main(String[] args) {
        // Get the driver instance
        WebDriver driver = DriverManager.getDriver();

        // Navigate to a website
        driver.get("https://www.google.com");

        driver.manage().timeouts().implicitlyWait(50, java.util.concurrent.TimeUnit.SECONDS);

        // Print the title to verify the browser is working
        System.out.println("Page title: " + driver.getTitle());

        // Close the driver
       // DriverManager.closeDriver();
    }
}

package com.automation.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null){
            WebDriverManager.edgedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
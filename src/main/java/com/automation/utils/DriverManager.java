package com.automation.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null){
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments(
                    "--headless",
                    "--disable-gpu",
                    "--disable-dev-shm-usage",
                    "--no-sandbox",   // Needed for GitHub Actions
                    "--user-data-dir=/tmp/chrome-user-data"
            );
            driver = new ChromeDriver(options);
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
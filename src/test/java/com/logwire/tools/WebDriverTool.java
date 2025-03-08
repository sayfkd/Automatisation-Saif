package com.logwire.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverTool {

    static public WebDriver driver;

    public static void setDriver() {
        String browser = System.getProperty("driver", "chrome").toLowerCase();
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "true")); // Par défaut en headless

        switch (browser) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;

            case "edge":
                driver = new EdgeDriver(); 
                break;

            case "chrome":
            default:
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--window-size=1920,1080");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                }
                driver = new ChromeDriver(chromeOptions);
                break;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void tearDown() {
        if(driver != null) {   
            driver.quit();
            driver = null;
        } 
    }   
}

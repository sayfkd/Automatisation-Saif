package com.logwire.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverTool {

    static public WebDriver driver;

    public static void setDriver() {

        String browser = System.getProperty("driver", "chrome").toLowerCase();

        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
                break;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void tearDown() {
        if(driver != null)  {   
            driver.close();
            driver.quit();
            driver = null;
        } 
    }   
}

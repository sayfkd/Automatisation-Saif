package com.logwire.tools;
import org.junit.jupiter.api.parallel.Execution;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.IOException;

@Execution(org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT)
public class WebDriverTool {

    static public WebDriver driver;

    public static void setDriver() throws IOException {

        String browser = System.getProperty("driver", "chrome").toLowerCase();
 

        String fullGridUrl = "http://192.168.1.95:4444/wd/hub"; 
        // String fullGridUrl = "http://localhost:4444/wd/hub"; 

        switch (browser) {
            case "firefox":
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--no-sandbox");    
                driver = new RemoteWebDriver(new java.net.URL(fullGridUrl), options);
                //WebDriverManager.firefoxdriver().setup(); 
                //driver = new FirefoxDriver();
                break;
            case "chrome":
            default:
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--no-sandbox");        
                driver = new RemoteWebDriver(new java.net.URL(fullGridUrl), optionsChrome);
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

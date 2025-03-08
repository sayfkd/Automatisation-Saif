package com.logwire.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.logwire.tools.WebDriverTool;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void BeforeEach(){
        WebDriverTool.setDriver();
    }

    @After
    public void AfterEach(){
        WebDriverTool.tearDown();
    }
    
}
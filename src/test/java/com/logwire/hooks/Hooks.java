package com.logwire.hooks;

import com.logwire.tools.WebDriverTool;
import io.cucumber.java.After;
import io.cucumber.java.Before;

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

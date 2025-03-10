package com.logwire.hooks;

import java.io.IOException;

import com.logwire.tools.WebDriverTool;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
    @Before
    public void BeforeEach() throws IOException{
        WebDriverTool.setDriver();
    }

    @After
    public void AfterEach(){
        WebDriverTool.tearDown();
    }
    
}
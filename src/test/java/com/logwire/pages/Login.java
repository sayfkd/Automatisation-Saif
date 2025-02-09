package com.logwire.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
      
    public Login(WebDriver driver) {
        PageFactory.initElements(driver, this);   
    }
    
    @FindBy(id = "user-name")
    WebElement usernameElement;

    @FindBy(id = "password")
    WebElement passwordElement;

    @FindBy(id = "login-button")
    WebElement loginButton ;

    @FindBy(className  = "error")
    public WebElement messageError;

    //actions

    public void saisirUsername(String username) {
        usernameElement.sendKeys(username);
    }
    public void saisirPassword(String password) {
        passwordElement.sendKeys(password);
    }
    public void clickLogin() {
        loginButton.click();
    }
    
    public void login(String username, String password) {
        saisirUsername(username);
        saisirPassword(password);
        clickLogin();
    }
    
}

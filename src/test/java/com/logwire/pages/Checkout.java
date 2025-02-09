package com.logwire.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {

    public Checkout(WebDriver driver) {
        PageFactory.initElements(driver, this);   
    }

    @FindBy(className = "title")
    public WebElement title;

    @FindBy(id = "cancel")
    public WebElement cancel;

    @FindBy(id = "first-name")
    public WebElement firstName;

    @FindBy(id = "last-name")
    public
    WebElement lastName; 

    @FindBy(id = "postal-code")
    public WebElement postalCode;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(className = "error")
    public WebElement errorMessage;

    //actions
    public void clickContinue() {
        continueButton.click();
    }

    public void fillForm(String firstName, String lastName, String postalCode) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
    }
    
}

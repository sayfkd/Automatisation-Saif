package com.logwire.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoCart {
    
    public SauceDemoCart(WebDriver driver) {
        PageFactory.initElements(driver, this);   
    }

    @FindBy(className = "title")
    public WebElement title;

    @FindBy(css = (".inventory_item_price"))
    public WebElement firstProductPrice;

    @FindBy(id = ("continue-shopping"))
    public WebElement continueShoppingButton;

    @FindBy(id = ("checkout"))
    public WebElement checkoutButton;

    @FindAll(@FindBy(xpath = "//button[contains(text(),'Remove')]"))
    public List<WebElement> RemoveButtons;

    @FindBy(css = ".cart_item")
    public List<WebElement> cartContents;
    
}

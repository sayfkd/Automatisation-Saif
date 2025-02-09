package com.logwire.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutOverview {
    
    public CheckoutOverview(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);   
    }

    @FindBy(css = ".cart_item")
    public List<WebElement> cartContents;

    @FindBy(className = "summary_subtotal_label")
    public WebElement subtotalLabel;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(className = "complete-header")
    public WebElement title;

    //actions

    public void clickFinish() {
        finishButton.click();
    }

}

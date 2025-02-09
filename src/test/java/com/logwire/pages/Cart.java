package com.logwire.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {
    
    public Cart(WebDriver driver) {
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

    //actions 
    public void clickRemoveButton(String productName) {
        for (WebElement product : cartContents) {
            if (product.getText().contains(productName)) {
                product.findElement(By.xpath(".//button")).click();
            }
        }
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickRemoveButton() {
        RemoveButtons.forEach(WebElement::click);
    }

    public void clickRemoveButton(int index) {
        RemoveButtons.get(index).click();
    }

}

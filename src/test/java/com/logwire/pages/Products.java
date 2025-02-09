package com.logwire.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Products {
    
    public Products(WebDriver driver) {
        PageFactory.initElements(driver, this);   
    }

    @FindBy(className ="shopping_cart_link")
    public WebElement cart;

    @FindAll(@FindBy(xpath = "//button[contains(text(),'Add to cart')]"))
    public List<WebElement> allAddToCart;

    @FindBy(css = ".inventory_item")
    public List<WebElement> allProducts;

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    public WebElement removeButton;

    @FindBy(className = "product_sort_container")
    public WebElement filter;

    @FindBy(className = "shopping_cart_badge")
    public WebElement cartBadge;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuButton;

    @FindBy(className = "bm-menu-wrap")
    public WebElement menu;

    @FindBy(id = "react-burger-cross-btn")
    public WebElement closeMenu;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItemsLink;

    @FindBy(id = "about_sidebar_link")
    public WebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logoutLink;

    @FindBy(id = "reset_sidebar_link")
    public WebElement resetLink;

    public void clickAddToCart(String productName) {
        for (WebElement product : allProducts) {
            if (product.getText().contains(productName)) {
                product.findElement(By.xpath("//button")).click();
                break;
            }
        }
    }

    public void clickCart() {
        cart.click();
    }

    public void selectFilter(String string) {
        Select dropdown = new Select(filter);
        dropdown.selectByVisibleText(string);
    }


    public WebElement getCheapestProduct() {
        WebElement cheapestProduct = allProducts.get(0);
        for (WebElement product : allProducts) {
            if (Double.parseDouble(product.findElement(By.className("inventory_item_price")).getText().substring(1)) < Double.parseDouble(cheapestProduct.findElement(By.className("inventory_item_price")).getText().substring(1))) {
                cheapestProduct = product;
            }
        }
        return cheapestProduct;
    }

    public WebElement getMostExpensiveProduct() {
        WebElement mostExpensiveProduct = allProducts.get(0);
        for (WebElement product : allProducts) {
            if (Double.parseDouble(product.findElement(By.className("inventory_item_price")).getText().substring(1)) > Double.parseDouble(mostExpensiveProduct.findElement(By.className("inventory_item_price")).getText().substring(1))) {
                mostExpensiveProduct = product;
            }
        }
        return mostExpensiveProduct;
    }

    public void clickMenu() {
        menuButton.click();
    }

    public WebElement getAlphabeticalProduct() {
        WebElement alphabeticalProduct = allProducts.get(0);
        for (WebElement product : allProducts) {
            if (product.findElement(By.className("inventory_item_name")).getText().compareTo(alphabeticalProduct.findElement(By.className("inventory_item_name")).getText()) < 0) {
                alphabeticalProduct = product;
            }
        }
        return alphabeticalProduct;
    }

    public WebElement getInverseAlphabeticalProduct() {
        WebElement alphabeticalProduct = allProducts.get(0);
        for (WebElement product : allProducts) {
            if (product.findElement(By.className("inventory_item_name")).getText().compareTo(alphabeticalProduct.findElement(By.className("inventory_item_name")).getText()) > 0) {
                alphabeticalProduct = product;
            }
        }
        return alphabeticalProduct;
    }
}

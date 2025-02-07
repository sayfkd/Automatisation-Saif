package com.logwire.classicTests;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.logwire.pages.SauceDemoCart;
import com.logwire.pages.SauceDemoCheckout;
import com.logwire.pages.SauceDemoCheckoutOverview;
import com.logwire.pages.SauceDemoLogin;
import com.logwire.pages.SauceDemoProducts;

@Tag("SauceDemoTests")
@Disabled
public class SauceDemoTests {

    WebDriver driver;
    SauceDemoLogin sauceDemoLogin;
    SauceDemoProducts sauceDemoProducts;
    SauceDemoCart sauceDemoCart;
    SauceDemoCheckout sauceDemoCheckout;
    SauceDemoCheckoutOverview sauceDemoCheckoutOverview;

    @BeforeEach
    public void setUp() throws InterruptedException {
        String browser = System.getProperty("driver", "chrome").toLowerCase();
        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                driver = new ChromeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        sauceDemoLogin = new SauceDemoLogin(driver);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
        driver = null;
    }

    @Test
    @Tag("login")
    @DisplayName("Test de connexion avec des identifiants valides")
    public void LoginTestCorrectCredentials() {
        sauceDemoLogin.login("standard_user", "secret_sauce");
        assertTrue(driver.getPageSource().contains("Products"));
    }

    @ParameterizedTest
    @Tag("login")
    @DisplayName("Test de connexion avec des identifiants valides depuis un fichier csv")
    @CsvFileSource(resources = "./logins.csv", numLinesToSkip = 1)
    public void LoginTestCorrectCredentialsData(String username, String password) {
        sauceDemoLogin.login(username, password);
        assertTrue(driver.getPageSource().contains("Products"));
    }

    @Test
    @Tag("login")
    @DisplayName("Test de connexion avec des identifiants invalides")
    public void LoginTestIncorrectCredentials() {
        sauceDemoLogin.login("standard_user", "secret_saucer");
        assertTrue(sauceDemoLogin.messageError.isDisplayed());
    }

    @Test
    @Tag("product")
    @DisplayName("Test de la liste des produits affichés")
    public void ProductListTest() {
        sauceDemoLogin.login("standard_user", "secret_sauce");
        sauceDemoProducts = new SauceDemoProducts(driver);
        System.out.println("list size " + sauceDemoProducts.allAddToCart.size());
        assertTrue(sauceDemoProducts.allAddToCart.size()>0);
    }



    @Test
    @Tag("cart")
    @DisplayName("Test d'ajout d'un produit au panier")
    public void ProductPageAddToCartTest() {
        sauceDemoLogin.login("standard_user", "secret_sauce");
        sauceDemoProducts = new SauceDemoProducts(driver);
        sauceDemoProducts.allAddToCart.get(0).click();
        sauceDemoProducts.allAddToCart.get(1).click();
        assertEquals("2", sauceDemoProducts.cart.getText());
    }

    @Test
    @Tag("cart")
    @DisplayName("Test de navigation vers la page panier")
    public void goToCartPageTest() {
        sauceDemoLogin.login("standard_user", "secret_sauce");
        sauceDemoProducts = new SauceDemoProducts(driver);
        sauceDemoProducts.allAddToCart.get(0).click();
        sauceDemoProducts.clickCart();
        assertTrue(driver.getPageSource().contains("Checkout"));
    }

    @Test
    @Tag("cart")
    @DisplayName("Test de vérification du prix sur la page panier")
    public void cartPagePriceTest() {
        sauceDemoLogin.login("standard_user", "secret_sauce");
        sauceDemoProducts = new SauceDemoProducts(driver);
        sauceDemoCart = new SauceDemoCart(driver);
        sauceDemoProducts.allAddToCart.get(0).click();
        sauceDemoProducts.clickCart();
        assertEquals("$29.99", sauceDemoCart.firstProductPrice.getText());
    }

    @Test
    @Tag("cart")
    @DisplayName("Test de suppression d'un produit du panier")
    public void cartPageRemoveProductTest() {
        sauceDemoLogin.login("standard_user", "secret_sauce");
        sauceDemoProducts = new SauceDemoProducts(driver);
        sauceDemoCart = new SauceDemoCart(driver);
        sauceDemoProducts.allAddToCart.get(0).click();
        sauceDemoProducts.clickCart();
        assertEquals("$29.99", sauceDemoCart.firstProductPrice.getText());
        sauceDemoCart.RemoveButtons.get(0).click();
        assertFalse(driver.getPageSource().contains("$29.99"));
    }


    @Test
    @Tag("cart")
    @DisplayName("Test de continuer les achats")
    public void continueShoppingTest() {
        sauceDemoLogin.login("standard_user", "secret_sauce");
        sauceDemoProducts = new SauceDemoProducts(driver);
        sauceDemoCart = new SauceDemoCart(driver);
        sauceDemoProducts.allAddToCart.get(0).click();
        sauceDemoProducts.clickCart();
        sauceDemoCart.continueShoppingButton.click();
        assertTrue(driver.getPageSource().contains("Products"));
    }

    @Test
    @Tag("cart")
    @Tag("checkout")
    @DisplayName("Test de boutton de checkout")
    public void checkoutButtonTest() {
        sauceDemoLogin.login("standard_user", "secret_sauce");
        sauceDemoProducts = new SauceDemoProducts(driver);
        sauceDemoCart = new SauceDemoCart(driver);
        sauceDemoCheckout = new SauceDemoCheckout(driver);
        sauceDemoProducts.allAddToCart.get(0).click();
        sauceDemoProducts.clickCart();
        sauceDemoCart.checkoutButton.click();
        assertTrue(sauceDemoCheckout.title.getText().contains("Your Information"));
    }

    @Test
    @Tag("checkout")
    @DisplayName("Test du boutton cancel dans la page checkout")
    public void checkoutCancelButtonTest() {
        sauceDemoLogin.login("standard_user", "secret_sauce");
        sauceDemoProducts = new SauceDemoProducts(driver);
        sauceDemoCart = new SauceDemoCart(driver);
        sauceDemoCheckout = new SauceDemoCheckout(driver);
        sauceDemoProducts.allAddToCart.get(0).click();
        sauceDemoProducts.clickCart();
        sauceDemoCart.checkoutButton.click();
        sauceDemoCheckout.cancel.click();
        assertTrue(sauceDemoCart.title.getText().contains("Your Cart"));
    }

    @Test
    @Tag("checkout")
    @DisplayName("Test de la saisie des informations de livraison")
    public void checkoutInformationTest() {
        sauceDemoLogin.login("standard_user", "secret_sauce");
        sauceDemoProducts = new SauceDemoProducts(driver);
        sauceDemoCart = new SauceDemoCart(driver);
        sauceDemoCheckout = new SauceDemoCheckout(driver);
        sauceDemoProducts.allAddToCart.get(0).click();
        sauceDemoProducts.clickCart();
        sauceDemoCart.checkoutButton.click();
        sauceDemoCheckout.firstName.sendKeys("John");
        sauceDemoCheckout.lastName.sendKeys("Doe");
        sauceDemoCheckout.postalCode.sendKeys("12345");
        sauceDemoCheckout.continueButton.click();
        assertTrue(sauceDemoCart.title.getText().contains("Checkout: Overview"));
    }

    @Test
    @Tag("checkout")
    @DisplayName("Test de la validation des informations de livraison")
    public void checkoutValidationTest() {
        sauceDemoLogin.login("standard_user", "secret_sauce");
        sauceDemoProducts = new SauceDemoProducts(driver);
        sauceDemoCart = new SauceDemoCart(driver);
        sauceDemoCheckout = new SauceDemoCheckout(driver);
        sauceDemoCheckoutOverview = new SauceDemoCheckoutOverview(driver);
        sauceDemoProducts.allAddToCart.get(0).click();
        sauceDemoProducts.clickCart();
        sauceDemoCart.checkoutButton.click();
        sauceDemoCheckout.firstName.sendKeys("John");
        sauceDemoCheckout.lastName.sendKeys("Doe");
        sauceDemoCheckout.postalCode.sendKeys("12345");
        sauceDemoCheckout.continueButton.click();
        sauceDemoCheckoutOverview.finishButton.click();
        assertTrue(driver.getPageSource().contains("Thank you for your order!"));
    }

}

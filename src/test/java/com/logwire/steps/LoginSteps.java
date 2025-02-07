package com.logwire.steps;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.logwire.pages.SauceDemoLogin;
import com.logwire.pages.SauceDemoProducts;
import com.logwire.tools.WebDriverTool;

public class LoginSteps {

    SauceDemoLogin loginPage;    
    SauceDemoProducts productsPage;


    @Given("je suis sur la page {string}")
    public void je_suis_sur_la_page(String s) {
        WebDriverTool.getDriver().get(s);
        loginPage = new SauceDemoLogin(WebDriverTool.getDriver());
    }

    @When("je saisis le password {string}")
    public void je_saisis_le_password(String s) {
        this.loginPage.saisirPassword(s);
    }

    @When("je clique sur le bouton Login")
    public void je_clique_sur_le_bouton_Login() {
        this.loginPage.clickLogin();
    }

    @When("je saisis le username {string}")
    public void je_saisis_le_username(String s) {
        this.loginPage.saisirUsername(s);
    }

    @Then("je suis redirige vers la page produit")
    public void je_suis_redirige_vers_la_page_produit() {
        productsPage = new SauceDemoProducts(WebDriverTool.getDriver());
        assertTrue( productsPage.allProducts.size() > 0);
    }

    @Then("un message derreur est affiche")
    public void un_message_derreur_est_affiche() {
        WebDriverWait wait = new WebDriverWait(WebDriverTool.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(this.loginPage.messageError));
        assertTrue(this.loginPage.messageError.isDisplayed());
    }
}

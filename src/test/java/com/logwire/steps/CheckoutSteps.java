package com.logwire.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.logwire.pages.SauceDemoCart;
import com.logwire.pages.SauceDemoCheckout;
import com.logwire.tools.WebDriverTool;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {
 
    
    SauceDemoCart sauceDemoCart;
    SauceDemoCheckout sauceDemoCheckout;

    public CheckoutSteps() {
    this.sauceDemoCart = new SauceDemoCart(WebDriverTool.getDriver());
    this.sauceDemoCheckout = new SauceDemoCheckout(WebDriverTool.getDriver());
    }

    @When("je clique sur le bouton Continue")
    public void je_clique_sur_le_bouton_Continue() {
        this.sauceDemoCheckout.continueButton.click();;
    }

    @Then("un message derreur est affiche sous le formulaire")
    public void un_message_derreur_est_affiche_sous_le_formulaire() {
        assertTrue(this.sauceDemoCheckout.errorMessage.isDisplayed());
    }

    @When("je saisis le prenom {string}")
    public void je_saisis_le_prenom(String s) {
        this.sauceDemoCheckout.firstName.sendKeys(s);
    }

    @When("je saisis le nom {string}")
    public void je_saisis_le_nom(String s) {
        this.sauceDemoCheckout.lastName.sendKeys(s);
    }
    
    @When("je saisis le code postal {string}")
    public void je_saisis_le_code_postal(String s) {
        this.sauceDemoCheckout.postalCode.sendKeys(s);
    }

    @Then("je suis redirige vers la page de Checkout Overview")
    public void je_suis_redirige_vers_la_page_de_Checkout_Overview() {
        assertTrue(this.sauceDemoCart.title.getText().contains("Checkout: Overview"));
    }

}


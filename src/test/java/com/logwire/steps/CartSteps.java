package com.logwire.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.logwire.pages.Cart;
import com.logwire.pages.Products;
import com.logwire.tools.WebDriverTool;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {

    Cart sauceDemoCart;
    Products sauceDemoProducts;

    
    public CartSteps() {
        this.sauceDemoCart = new Cart(WebDriverTool.getDriver());
        this.sauceDemoProducts = new Products(WebDriverTool.getDriver());
    }


    @When("je clique sur le panier")
    public void je_clique_sur_le_panier() {
        this.sauceDemoProducts.clickCart();
    }

    @Then("je suis redirige vers la page du panier")
    public void je_suis_redirige_vers_la_page_du_panier() {
        assertTrue( this.sauceDemoCart.title.getText().contains("Your Cart"));
    }

    @Then("la liste des produits ajoutes au panier contient les deux produits")
    public void la_liste_des_produits_ajoutes_au_panier_contient_les_deux_produits() {


    }

    @Then("la liste des produits ajoutes au panier est vide")
    public void la_liste_des_produits_ajoutes_au_panier_est_vide() {
        assertTrue( this.sauceDemoCart.cartContents.size() == 0);
    }

    @Then("le prix sur {string} est {float}")
    public void le_prix_sur_est(String s, float f) {
        this.sauceDemoCart.cartContents.forEach(product -> {
            if (product.getText().contains(s)) {
                assertTrue(product.getText().contains(String.valueOf(f)));
            }
        });
    }

    @Then("le badge du panier affiche {int}")
    public void le_badge_du_panier_affiche(int i) {
        assertTrue( this.sauceDemoProducts.cartBadge.getText().contains("2"));
    }

    @When("je clique sur le bouton Checkout")
    public void je_clique_sur_le_bouton_Checkout() {
        this.sauceDemoCart.checkoutButton.click();
    }

    @Then("je suis redirige vers la page de checkout")
    public void je_suis_redirige_vers_la_page_de_checkout() {
        assertTrue( this.sauceDemoCart.title.getText().contains("Checkout"));
    }
}

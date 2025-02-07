package com.logwire.steps;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.logwire.pages.SauceDemoProducts;
import com.logwire.tools.WebDriverTool;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPageSteps {

    SauceDemoProducts productsPage;
    
    public ProductPageSteps() {
        this.productsPage = new SauceDemoProducts(WebDriverTool.getDriver());
    }

    @When("je verifie la liste des produits")
    public void je_verifie_la_liste_des_produits() {        assertTrue( this.productsPage.allProducts.size() > 0);
    }

    @Then("la liste des produits est affiche")
    public void la_liste_des_produits_est_affiche() {
        assertTrue( this.productsPage.allProducts.size() > 0);
    }

    @When("je clique sur le bouton Add to card du produit {string}")
    public void je_clique_sur_le_bouton_Add_to_card_du_produit(String s) {
        this.productsPage.allProducts.forEach(product -> {
            if (product.getText().contains(s)) {
                product.findElement(By.xpath(".//button")).click();
            }
        });    
    }

    @Then("le produit {string} est ajoute au panier")
    public void le_produit_est_ajoute_au_panier(String s) {
        assertTrue(this.productsPage.cart.isDisplayed());
    }

    @Then("la quantite de produits dans le panier est {int}")
    public void la_quantite_de_produits_dans_le_panier_est(int i) {
        assertTrue( this.productsPage.cart.getText().contains(String.valueOf(i)));
    }

    @Then("le produit {string} est retire du panier")
    public void le_produit_est_retire_du_panier(String s) {
        this.productsPage.allProducts.forEach(product -> {
            if (product.getText().contains(s)) {
                assertFalse(product.getText().contains("Remove"));
            }
        });
    }

    @When("je clique sur le bouton Remove du produit {string}")
    public void je_clique_sur_le_bouton_Remove_du_produit(String s) {
        this.productsPage.allProducts.forEach(product -> {
            if (product.getText().contains(s)) {
                product.findElement(By.xpath(".//button")).click();
            }
        }); 
    }

    @When("je selectionne {string} dans le menu deroulant")
    public void je_selectionne_dans_le_menu_deroulant(String s) {
        this.productsPage.selectFilter(s);
    } 

    @Then( "les produits sont affiches dans lordre croissant")
    public void les_produits_sont_affiches_dans_lordre_croissant() {
        assertTrue(this.productsPage.getCheapestProduct().getText().equals(this.productsPage.allProducts.get(0).getText()));
    }

    @Then("les produits sont affiches dans lordre decroissant")
    public void les_produits_sont_affiches_dans_lordre_decroissant() {
        assertTrue(this.productsPage.getMostExpensiveProduct().getText().equals(this.productsPage.allProducts.get(0).getText()));
    }



    @When("quand je click sur le titre dun produit")
    public void quand_je_click_sur_le_titre_dun_produit() {
        WebElement product = this.productsPage.allProducts.get(0);
        product.findElement(By.className("inventory_item_name")).click();
    }

    @Then("je suis redirige vers la page details produit")
    public void je_suis_redirige_vers_la_page_details_produit() {
        assertTrue(WebDriverTool.getDriver().findElement(By.className("inventory_details_name")).isDisplayed());
    }

}

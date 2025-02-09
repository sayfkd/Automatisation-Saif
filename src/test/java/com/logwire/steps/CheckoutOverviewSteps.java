package com.logwire.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.logwire.pages.CheckoutOverview;
import com.logwire.tools.WebDriverTool;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutOverviewSteps {


    CheckoutOverview sauceDemoCheckoutOverview;

    public CheckoutOverviewSteps() {
        this.sauceDemoCheckoutOverview = new CheckoutOverview(WebDriverTool.getDriver());
    }

    @Then("la liste des produits est affiche sur la page de checkout")
    public void la_liste_des_produits_est_affiche_sur_la_page_de_checkout() {
        this.sauceDemoCheckoutOverview.cartContents.forEach(product -> {
            assertTrue(product.isDisplayed());
        });
    }

    @When("je clique sur le bouton Finish")
    public void je_clique_sur_le_bouton_Finish() {
        this.sauceDemoCheckoutOverview.finishButton.click();
    }

    @Then("je suis redirige vers la page final")
    public void je_suis_redirige_vers_la_page_final() {
        assertTrue( WebDriverTool.getDriver().getCurrentUrl().contains("checkout-complete"));
        assertTrue( this.sauceDemoCheckoutOverview.title.getText().contains("Thank you for your order!"));
    }

    @Then("le prix total des produits est juste")
    public void le_prix_total_des_produits_est_juste() {
    assertEquals(Float.parseFloat(this.sauceDemoCheckoutOverview.subtotalLabel.getText().substring(1)), this.sauceDemoCheckoutOverview.calculatTotalPrice(), 0.01F);    
    }
    
}

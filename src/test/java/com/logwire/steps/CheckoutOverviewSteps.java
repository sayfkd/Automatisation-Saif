package com.logwire.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.logwire.pages.SauceDemoCheckoutOverview;
import com.logwire.tools.WebDriverTool;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutOverviewSteps {


    SauceDemoCheckoutOverview sauceDemoCheckoutOverview;

    public CheckoutOverviewSteps() {
        this.sauceDemoCheckoutOverview = new SauceDemoCheckoutOverview(WebDriverTool.getDriver());
    }

    @Then("la liste des produits est affiche sur la page de checkout")
    public void la_liste_des_produits_est_affiche_sur_la_page_de_checkout() {
        this.sauceDemoCheckoutOverview.cartContents.forEach(product -> {
            assertTrue(product.isDisplayed());
        });
    }

    @Then("le prix total des produits est {float}")
    public void le_prix_total_des_produits_est(float f) {
        assertTrue( this.sauceDemoCheckoutOverview.subtotalLabel.getText().contains(String.valueOf(f)));
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
}

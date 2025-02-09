@Cart
Feature: Cart 
    Background:
    Given je suis sur la page "https://www.saucedemo.com/"
    When je saisis le username "standard_user"
    And je saisis le password "secret_sauce"
    And je clique sur le bouton Login

    @GoCart
    Scenario: aller au panier
    When je clique sur le panier
    Then je suis redirige vers la page du panier

    @AddToCart
    Scenario: Verification du badge du panier 
    When je clique sur le bouton Add to card du produit "Sauce Labs Backpack"
    And je clique sur le bouton Add to card du produit "Sauce Labs Bike Light"
    Then le badge du panier affiche 2

    @CartRemoval
    Scenario Outline: Vérification de la suppression des produits du panier
    When je clique sur le bouton Add to card du produit "<NomProduit1>"
    And je clique sur le bouton Add to card du produit "<NomProduit2>"
    And je clique sur le bouton Add to card du produit "<NomProduit3>"
    And je clique sur le bouton Remove du produit "<NomProduit1>"
    And je clique sur le bouton Remove du produit "<NomProduit2>"
    And je clique sur le bouton Remove du produit "<NomProduit3>"
    Then la liste des produits ajoutes au panier est vide

    Examples:
        | NomProduit1             | NomProduit2                 | NomProduit3           |
        | Sauce Labs Backpack     | Sauce Labs Bike Light       | Sauce Labs Bolt T-Shirt |
        | Sauce Labs Fleece       | Test.allTheThings() T-Shirt | Sauce Labs Onesie |

    @Price
    Scenario: Vérification des prix des produits dans le panier
        When je clique sur le bouton Add to card du produit "<NomProduit>"
        Then le prix sur "<NomProduit>" est <Prix>

        Examples:
        | NomProduit                | Prix  |
        | Sauce Labs Backpack       | 29.99 |
        | Sauce Labs Bike Light     | 9.99  |
        | Sauce Labs Bolt T-Shirt   | 15.99 |

    @Checkout
    Scenario: Verification du checkout
    When je clique sur le bouton Add to card du produit "Sauce Labs Backpack"
    And je clique sur le bouton Add to card du produit "Sauce Labs Bike Light"
    And je clique sur le panier
    And je clique sur le bouton Checkout
    Then je suis redirige vers la page de checkout



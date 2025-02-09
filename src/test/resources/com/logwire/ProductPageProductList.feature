@ProductPage
Feature: List des produits

    Background:
    Given je suis sur la page "https://www.saucedemo.com/"
    When je saisis le username "standard_user"
    And je saisis le password "secret_sauce"
    And je clique sur le bouton Login

    @ProductList
    Scenario: Affichage de la liste des produits
    When je verifie la liste des produits
    Then la liste des produits est affiche

    @AddToCart
    Scenario: Ajout dun produit au panier
    When je clique sur le bouton Add to card du produit "Sauce Labs Backpack"
    Then le produit "Sauce Labs Backpack" est ajoute au panier

    @AddToCart
    Scenario: Ajout de plusieurs produits au panier
    When je clique sur le bouton Add to card du produit "Sauce Labs Backpack"
    And je clique sur le bouton Add to card du produit "Sauce Labs Bike Light"
    And je clique sur le bouton Add to card du produit "Sauce Labs Bolt T-Shirt"
    Then la quantite de produits dans le panier est 3

    @CartRemoval
    Scenario: Suppression dun produit du panier
    When je clique sur le bouton Add to card du produit "Sauce Labs Backpack"
    And je clique sur le bouton Remove du produit "Sauce Labs Backpack"
    Then le produit "Sauce Labs Backpack" est retire du panier

    @PriceTri
    Scenario: Tri des produits par prix
    When je selectionne "Price (low to high)" dans le menu deroulant
    Then les produits sont affiches dans lordre croissant
    
    @PriceTri
    Scenario: Tri des produits par prix decroissant
    When je selectionne "Price (high to low)" dans le menu deroulant
    Then les produits sont affiches dans lordre decroissant

    @NameTri
    Scenario: Tri des produits par nom
    When je selectionne "Name (A to Z)" dans le menu deroulant
    Then les produits sont affiches dans lordre alphabetique

    @NameTri
    Scenario: Tri des produits par nom
    When je selectionne "Name (Z to A)" dans le menu deroulant
    Then les produits sont affiches dans linverse dordre alphabetique

    @ProductDetails
    Scenario: Redicercion vers la page details produit
    When quand je click sur le titre dun produit
    Then je suis redirige vers la page details produit

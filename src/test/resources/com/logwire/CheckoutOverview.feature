@CheckoutOverview
Feature: Checkout over 

    Background:
        Given je suis sur la page "https://www.saucedemo.com/"
        When je saisis le username "standard_user"
        And je saisis le password "secret_sauce"
        And je clique sur le bouton Login
        And je clique sur le bouton Add to card du produit "Sauce Labs Backpack"
        And je clique sur le bouton Add to card du produit "Sauce Labs Bike Light"
        And je clique sur le panier
        And je clique sur le bouton Checkout
        And je suis redirige vers la page de checkout
        And je saisis le nom "Doe"
        And je saisis le prenom "John"
        And je saisis le code postal "12345"
        And je clique sur le bouton Continue
        Then je suis redirige vers la page de Checkout Overview

    Scenario: Je verifie la liste des produits
        When je suis redirige vers la page de Checkout Overview
        Then la liste des produits est affiche sur la page de checkout
    
    Scenario: Je verifie le prix total des produits
        When la liste des produits est affiche sur la page de checkout
        Then le prix total des produits est 39.98

    Scenario: Je clique sur le bouton Finish
        When je clique sur le bouton Finish
        Then je suis redirige vers la page final 
       
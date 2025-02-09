@Checkout
Feature: Checkout page

    Background:
        Given je suis sur la page "https://www.saucedemo.com/"
        When je saisis le username "standard_user"
        And je saisis le password "secret_sauce"
        And je clique sur le bouton Login
        And je clique sur le bouton Add to card du produit "Sauce Labs Backpack"
        And je clique sur le bouton Add to card du produit "Sauce Labs Bike Light"
        And je clique sur le panier
        And je clique sur le bouton Checkout
        Then je suis redirige vers la page de checkout

    @empty_erreur
    Scenario: Je laisse tous les champs vides
        When je clique sur le bouton Continue
        Then un message derreur est affiche sous le formulaire
    
    @empty_postal
    Scenario: Je saisis le nom et le prenom sans code postal
        When je saisis le nom "Doe"
        And je saisis le prenom "John"
        And je clique sur le bouton Continue
        Then un message derreur est affiche sous le formulaire
        
    @empty_nom
    @empty_prenom
    Scenario: Je saisis le code postal sans nom et prenom
        When je saisis le code postal "12345"
        And je clique sur le bouton Continue
        Then un message derreur est affiche sous le formulaire
    
    @valid_checkout
    Scenario: Je saisis le nom et le prenom avec code postal
        When je saisis le nom "Doe"
        And je saisis le prenom "John"
        And je saisis le code postal "12345"
        And je clique sur le bouton Continue
        Then je suis redirige vers la page de Checkout Overview


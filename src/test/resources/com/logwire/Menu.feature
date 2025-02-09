@Menu
Feature: Menu 

Background:
    Given je suis sur la page "https://www.saucedemo.com/"
    When je saisis le username "standard_user"
    And je saisis le password "secret_sauce"
    And je clique sur le bouton Login

Scenario: Ouvrir le menu
    When je clique sur le bouton du menu
    Then le menu est affiche
    And le menu contient les elements suivants All Items, About, Logout, Reset App State sont visibles

Scenario: clique sur le bouton de fermeture du menu
    When je clique sur le bouton du menu
    And le menu est affiche
    And je clique sur le bouton de fermeture du menu
    Then le menu est ferme

Scenario: clique sur le bouton All Items
    When je clique sur le bouton du menu
    And le menu est affiche
    And je clique sur le bouton All Items
    Then je suis redirige vers la page produit

Scenario: clique sur le bouton About
    When je clique sur le bouton du menu
    And le menu est affiche
    And je clique sur le bouton About
    Then je suis redirige vers la page About

Scenario: clique sur le bouton Logout
    When je clique sur le bouton du menu
    And le menu est affiche
    And je clique sur le bouton Logout
    Then je suis redirige vers la page de login

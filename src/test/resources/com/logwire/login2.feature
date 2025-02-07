@Login
Feature: Login to SauceDemo 2
    Background:
        Given je suis sur la page "https://www.saucedemo.com/"

    @DDT
    Scenario:
    Given je suis sur la page "<url>"
    When je saisis le username "<username>"
    And je saisis le password "<password>"
    And je clique sur le bouton Login
    Then je suis redirige vers la page produit
    @env
    Examples:
        | username       | password       | url                        |
        | standard_user  | secret_sauce   | https://www.saucedemo.com/ |
        | visual_user    | secret_sauce   | https://www.saucedemo.com/ |
        | problem_user   | secret_sauce   | https://www.saucedemo.com/ |

    Scenario: Login avec username valide et password invalide
    When je saisis le username "standard_user"
    And je saisis le password "invalid_password"
    And je clique sur le bouton Login
    Then un message derreur est affiche

    Scenario: Login avec username invalide et password valide
    When je saisis le username "invalid_user"
    And je saisis le password "secret_sauce"
    And je clique sur le bouton Login
    Then un message derreur est affiche

    Scenario: Login avec username invalide et password invalide
    When je saisis le username "invalid_user"
    And je saisis le password "invalid_password"
    And je clique sur le bouton Login
    Then un message derreur est affiche

    Scenario: Login avec username vide et password vide
    When je saisis le username ""
    And je saisis le password ""
    And je clique sur le bouton Login
    Then un message derreur est affiche

    Scenario: Login avec username vide et password valide
    When je saisis le username ""
    And je saisis le password "secret_sauce"
    And je clique sur le bouton Login
    Then un message derreur est affiche

    Scenario: Login avec username valide et password vide
    When je saisis le username "standard_user"
    And je saisis le password ""
    And je clique sur le bouton Login
    Then un message derreur est affiche

    @locked_out_user
    Scenario: Login avec un username suspendu et password valide
    When je saisis le username "locked_out_user"
    And je saisis le password "secret_sauce"
    And je clique sur le bouton Login
    Then un message derreur est affiche



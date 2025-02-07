Feature: Login DDT

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

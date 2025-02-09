# Automatisation des tests du site SauceDemo

Ce projet implémente l'automatisation des tests du site [SauceDemo](https://www.saucedemo.com/) en utilisant **Selenium** et **Cucumber**. Il inclut des tests classiques avec Selenium et des scénarios complets de bout en bout avec Cucumber.

## Technologies utilisées

- **Java**
- **Selenium WebDriver**
- **Cucumber**
- **JUnit**
- **Maven**
- **Page Object Model (POM) avec PageFactory**

## Structure du projet

- `src/test/java/com/logwire/classicTests/` : Contient des tests Selenium classiques, dont un test de connexion utilisant un fichier CSV pour la gestion des données et un fichier .odt aui contient les scenarios de tests
- `src/test/java/com/logwire/pages/` : Contient toutes les pages modélisées selon le pattern Page Object Model (POM).
- `src/test/java/com/logwire/steps/` : Contient tous les steps définis pour les scénarios Cucumber.
- `src/test/java/com/logwire/hooks/` : Contient les hooks pour la gestion des pré-conditions et post-conditions.
- `src/test/resources/com/logwire/` : Contient les fichiers `.feature` définissant les scénarios de tests en Gherkin.
- `src/test/java/com/logwire/tools/WebDriverTool.java` : Un outil permettant de centraliser l'initialisation du WebDriver pour tous les tests.
- `src/test/java/com/logwire/scripts/tests_runner.sh` : Un script permettant de lancer tous les tests ou d'exécuter des tests spécifiques par tag.

## Scénarios Cucumber implémentés

Les scénarios de tests automatisés couvrent plusieurs fonctionnalités du site SauceDemo :

1. **Login** : Test de connexion avec différents utilisateurs.
2. **Product Page** : Vérification de l'affichage des produits et interactions avec ceux-ci, plus des tests sur le sidebar menu.
3. **Cart** : Ajout et suppression de produits du panier.
4. **Checkout** : Processus de validation de commande.
5. **Vérification des prix** : Comparaison entre les prix affichés et calculés.
6. **Manipulation des produits** : Ajout, suppression et tri des articles.
7. **Data-Driven Testing (DDT)** : Exécution de tests avec des données externes (CSV).

## Exécution des tests

### Exécuter tous les tests

```bash
mvn test
```
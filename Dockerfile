# Utiliser une image Selenium avec Chrome préinstallé
FROM selenium/standalone-chrome:latest

# Installer Maven
USER root
RUN apt-get update && apt-get install -y maven

# Définir le répertoire de travail
WORKDIR /workspace

# Copier le projet Selenium dans le conteneur
COPY . /workspace

# Commande par défaut pour exécuter les tests
CMD ["mvn", "clean", "test"]
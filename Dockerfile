# Utiliser une image de base avec Java et Maven
FROM maven:latest

# Installer Google Chrome
RUN apt-get update && apt-get install -y wget curl unzip \
    && wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list \
    && apt-get update && apt-get install -y google-chrome-stable \
    && google-chrome --version

# Installer ChromeDriver (assure-toi que la version correspond à celle de Chrome)
RUN CHROMEDRIVER_VERSION=$(curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE) && \
    wget -N https://chromedriver.storage.googleapis.com/$CHROMEDRIVER_VERSION/chromedriver_linux64.zip -P /tmp/ && \
    unzip /tmp/chromedriver_linux64.zip -d /usr/local/bin/ && \
    chmod +x /usr/local/bin/chromedriver && \
    chromedriver --version

# Copier le projet dans l'image
WORKDIR /app
COPY . .

# Lancer les tests Selenium avec Maven
CMD ["mvn", "clean", "test"]

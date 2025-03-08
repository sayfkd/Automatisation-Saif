pipeline {
    agent {
        docker {
            image 'maven:3.8.5-openjdk-17'
        }
    }
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/sayfkd/Automatisation-Saif'
            }
        }

        stage('Start Selenium Grid') {
            steps {
                sh '''
                    docker network create selenium-grid || true
                    docker run -d -p 4444:4444 --net selenium-grid --name selenium-hub selenium/hub || true
                    docker run -d --net selenium-grid --name chrome-node -e HUB_HOST=selenium-hub selenium/node-chrome || true
                '''
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn clean test -Ddriver=chrome'
            }
        }
    }
}

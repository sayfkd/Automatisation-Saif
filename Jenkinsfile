pipeline {
    agent any

    tools {
        maven 'Maven' // Assure-toi qu'il est configuré dans Jenkins
        jdk 'JDK17'   // Assure-toi qu'il est configuré dans Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/sayfkd/Automatisation-Saif'
            }
        }

        stage('Setup') {
            steps {
                sh 'apt-get update && apt-get install -y maven openjdk-17-jdk'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test -Dheadless=true'
            }
        }

        stage('Generate Reports') {
            steps {
                cucumber buildStatus: "false", fileIncludePattern: '**/target/cucumber-reports/*.json', jsonReportDirectory: 'target/cucumber-reports'
            }
        }
    }
}

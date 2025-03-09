pipeline {
    agent { docker { image 'selenium/standalone-chrome' } } 
    tools {
        maven 'M3'
    }

    stages {
        stage('mvn check ') { 
            steps { sh "mvn --version" } 
        }
        stage('chrome check ') { 
            steps { sh "google-chrome --version" } 
        }
        stage('test ') { 
            steps { sh "mvn clean test" } 
        }
    }
}
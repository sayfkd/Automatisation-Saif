pipeline {
    agent any
    tools {
        maven 'M3'
    }

    stages {
        stage('mvn ') { 
            steps { sh "mvn --version" } 
        }
        stage('test ') { 
            steps { sh "mvn clean test" } 
        }
    }
}
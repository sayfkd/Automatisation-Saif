pipeline {
    agent { docker { image 'maven:3.8.6-openjdk-11' } } 
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
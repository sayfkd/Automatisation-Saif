pipeline {
    agent any
    tools {
        maven 'M3'
        jdk 'JDK17'
    }
    environment {
        JAVA_HOME = "${tool 'JDK17'}" // Force l'utilisation du JDK configuré
    }

    stages {
        stage('mvn ') 
        { 
            steps { sh "mvn --version" } 
        }
    }
}
pipeline {
    agent any

    tools {
        maven 'Maven' 
        jdk 'JDK17'  
    }

    stages {
        
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
                sh 'mvn verify'
            }
        }

        stage('Publish Reports') {
            steps {
                cucumber buildStatus: false, fileIncludePattern: '**/target/cucumber-reports/*.json', jsonReportDirectory: 'target/cucumber-reports'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
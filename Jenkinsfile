pipeline {
    agent {
        docker {
            image 'maven:3.8.6-openjdk-11'
        }
    }
    
        stage('Install Dependencies') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                sh 'mvn test -Ducumber.filter.tags="@Cart"'
            }
        }

    }

}

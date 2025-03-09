pipeline {
  agent {
    docker {
      image 'selenium/standalone-chrome:latest'
      args '-v /dev/shm:/dev/shm'
    }
  }
  stages {

    stage('verify chrome version') {
      steps {
        script {
        sh 'google-chrome --version'
        }
      }
    }

    stage('Install Maven') {
      steps {
        sh '''
        apt update
        apt install -y maven
        '''
      }
    }

    stage('Run Tests') {
      steps {
        script {
          sh 'mvn test'
        }
      }
    }
  }
}

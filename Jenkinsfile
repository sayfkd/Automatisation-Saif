pipeline {
  agent {
    docker {
      image 'selenium/standalone-chrome:latest'
      args '-v /dev/shm:/dev/shm'
    }
  }
  stages {
    stage('Run Tests') {
      steps {
        script {
          // Exécuter les tests avec Maven
          sh './mvnw clean test'
        }
      }
    }
  }
}

pipeline {
  agent {
    docker {
      image 'your-dockerhub-username/my-selenium-maven'
      args '-v /dev/shm:/dev/shm'
    }
  }
  stages {
    stage('Verify Chrome Version') {
      steps {
        sh 'google-chrome --version'
      }
    }
    stage('Run Tests') {
      steps {
        sh 'mvn test'
      }
    }
  }
}

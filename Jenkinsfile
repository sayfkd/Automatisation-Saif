pipeline {
  agent {
    docker {
      image 'selenium/standalone-chrome'
    }
  }
  stages {
    stage('Run Tests') {
      steps {
        sh './mvnw clean test'
      }
    }
  }
}

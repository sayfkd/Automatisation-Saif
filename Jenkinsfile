pipeline {
  agent {
    docker {
      image 'selenium-maven'
    }
  }
  stages {
    stage('Run Tests') {
      steps {
        sh 'mvn clean test'
      }
    }
  }
}

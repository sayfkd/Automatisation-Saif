pipeline {
  agent any
  stages {
    stage('Verify browsers are installed') {
      steps {
        script {
          // Installer Google Chrome avec Homebrew (si ce n'est pas déjà fait)
          sh 'brew install --cask google-chrome'

          // Vérifier si les navigateurs sont installés
          sh 'google-chrome --version'
          sh 'firefox --version'
        }
      }
    }
    stage('Run Tests') {
      steps {
        sh './mvnw clean test'
      }
    }
  }
}

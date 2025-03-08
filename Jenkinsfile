pipeline {
  agent any
  stages {
    stage('Verify browsers are installed') {
      steps {
        script {
          // Utiliser curl au lieu de wget pour télécharger Google Chrome
          sh 'curl -o google-chrome-stable_current_amd64.deb https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb'
          
          // Installer Google Chrome
          sh 'sudo apt install ./google-chrome-stable_current_amd64.deb -y'

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

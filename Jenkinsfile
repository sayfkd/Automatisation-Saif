pipeline {
  agent any
  stages {
    stage('Verify browsers are installed') {
      steps {
        script {
          // Télécharger Google Chrome avec curl (pas besoin de sudo)
          sh 'curl -o google-chrome-stable_current_amd64.deb https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb'
          
          // Installer Google Chrome sans sudo (exécution directe)
          sh 'apt install ./google-chrome-stable_current_amd64.deb -y'

          // Vérifier si les navigateurs sont installés
          sh 'google-chrome --version'
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

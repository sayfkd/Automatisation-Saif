pipeline {
  agent any
  stages {
    stage('Verify browsers are installed') {
     script {
          // Installer Google Chrome sur l'agent Jenkins (si ce n'est pas déjà fait)
          sh 'wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb'
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
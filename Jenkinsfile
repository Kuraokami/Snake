pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        echo 'Build Application'
        sh 'mvn compile'
      }
    }
    stage('Test') {
      steps {
        echo 'Testing'
        sh 'mvn test'
      }
    }
    stage('Deploy') {
      steps {
        echo 'Yayyyyy'
      }
    }
  }
}
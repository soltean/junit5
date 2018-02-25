pipeline {
  agent any
  stages {
    stage('Hello') {
      steps {
        echo 'Hello Jenkins user!'
      }
    }
    stage('Get maven info') {
      steps {
        sh 'echo $M2_HOME'
      }
    }
  }
}
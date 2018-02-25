pipeline {
  agent any
  stages {
    stage('Hello') {
      steps {
        echo 'Hello Jenkins user!'
      }
    }
    stage('Get Maven info') {
      agent {
        docker {
          image 'maven:3.5.2'
        }
        
      }
      steps {
        sh 'echo $M2_HOME'
      }
    }
  }
}
pipeline {
  agent {
    docker {
      image 'maven'
    }
    
  }
  stages {
    stage('Hello') {
      steps {
        echo 'Hello Jenkins user!'
      }
    }
    stage('Get Maven info') {
      agent {
        docker {
          image 'maven'
        }
        
      }
      steps {
        sh 'echo $M2_HOME'
      }
    }
  }
}
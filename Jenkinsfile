pipeline {
  agent {
    docker {
      image 'maven'
    }
    
  }
  stages {
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
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
          image 'maven:3.5.2'
        }
        
      }
      steps {
        sh 'echo $M2_HOME'
      }
    }
  }
}
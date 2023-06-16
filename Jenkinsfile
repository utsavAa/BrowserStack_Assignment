pipeline {
  agent any

  stages {
    stage('Compile') {
      steps {
	withMaven(maven: 'Maven 3.9.1') {
        sh 'mvn clean compile -Dmaven.compiler.source=1.8 -Dmaven.compiler.target=1.8 
-Dmaven.compiler.includeFiles=. TestSDK.java'
	}
      }
    }

    stage('Test') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'f910838a-db91-4868-8645-48115ec7eada', passwordVariable: 'PASSWORD', 
usernameVariable: 
'USERNAME')]) {
          withMaven(maven: 'Maven 3.9.1') {
            sh 'mvn test'
          }
        }
      }
    }
  }
}

pipeline {
  agent any

  stages {
    stage('Compile') {
      steps {
        sh 'javac -cp /Users/utsavbanerjee/Downloads/jar_files/testng-7.8.0.jar:. TestSDK.java'
      }
    }

    stage('Test') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'f910838a-db91-4868-8645-48115ec7eada', passwordVariable: 'PASSWORD', 
usernameVariable: 
'USERNAME')]) {
          sh 'java -cp /Users/utsavbanerjee/Downloads/jar_files/testng-7.8.0.jar:. TestSDK.java $USERNAME $PASSWORD'
        }
      }
    }
  }
}

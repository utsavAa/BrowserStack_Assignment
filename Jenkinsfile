pipeline {
  agent any

  stages {
    stage('Compile') {
      steps {
	sh 'pwd'
        sh 'javac -cp /Users/utsavbanerjee/Downloads/selenium-server-4.9.1.jar:/Users/utsavbanerjee/Downloads/testng-7.4.0.jar:. TestOnSafari.java'
	sh 'find . -name "*.class"'
      }
    }

    stage('Test') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'f910838a-db91-4868-8645-48115ec7eada', passwordVariable: 'PASSWORD', 
usernameVariable: 
'USERNAME')]) {
          sh 'javac -cp 
/Users/utsavbanerjee/Downloads/selenium-server-4.9.1.jar:/Users/utsavbanerjee/Downloads/testng-7.4.0.jar:/Users/utsavbanerjee/.jenkins/workspace/BrowserStack test.TestOnSafari'
        }
      }
    }
  }
}

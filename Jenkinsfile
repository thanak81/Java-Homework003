pipeline {
    agent any
    stages {
        stage("Checkin"){
            agent {
                docker {
                  image  "radut/openjdk-21-maven:latest"
                }
            }
            steps{
//                  sh "apt-get update && apt-get install -y maven"  // Install Maven
                 sh "mvn --version"  // Check Maven version
            }
        }
        stage("Test"){
            steps{
                sh "mvn test"
            }
        }
    }

    post {
        success {
            echo "wow congratz, you passed the test"
        }

    }

}
pipeline {
    agent any
    stages {
        stage("Checkin"){
            agent {
                docker {
                  image  "openjdk:21"
                }
            }
            steps{
                 sh "apt-get update && apt-get install -y maven"  // Install Maven
                 sh "mvn --version"  // Check Maven version
            }
        }
    }

    post {
        success {
            echo "wow congratz, you passed the test"
        }

    }

}
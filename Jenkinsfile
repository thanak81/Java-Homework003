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
                sh "apt-get update"
                sh "apt-get install -y maven"
                sh "mvn --version"
            }
        }
    }

    post {
        success {
            echo "wow congratz, you passed the test"
        }

    }

}
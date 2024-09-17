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
                sh "echo maven --version"
            }
        }
    }

    post {
        success {
            echo "wow congratz, you passed the test"
        }

    }

}
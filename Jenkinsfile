pipeline {
    agent any
    stages {
        stage("Checkin"){
            agent {
                docker {
                  image  "maven:3.8.6-openjdk-21"
                }
            }
            steps{
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
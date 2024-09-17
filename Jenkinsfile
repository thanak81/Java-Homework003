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
                sh """"
                    ls -la
                """
            }
        }
    }

}
pipeline {
    agent any
    stages {
        stage("Checkin"){
            agent {
                docker {
                  image  "openjdk:21"
                }
            }
            step {
                sh ```
                    ls -la
                ```
            }
        }
    }

}
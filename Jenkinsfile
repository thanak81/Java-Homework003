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
                sh "mvn  clean"
                sh "mvn test"
            }
        }
        stage ("Build"){
            steps{
                sh "mvn install"
            }
        }

//         stage ("Run"){
//             steps{
//                 sh "java "
//             }
//         }
    }

    post {
        success {
            echo "wow congratz, you passed the test nice one"
        }

        failure {
            sh "echo your code is shite dawg dafak"
        }

    }

}
pipeline {
    agent {
        label "jenkins-agent"
    }
    tools {
        jdk "Java21"
        maven "Maven3"
    }
    stages{
        stage ("Cleanup workspace"){
            steps {
                cleanWs() // Jenkins func to clean workspace
            }
        }
         stage ("Checkout from SCM"){
                    steps{
                        git branch: "main", credentialsId: "github", url: "https://github.com/thanak81/Java-Homework003.git"
                    }
        }
        stage ("Build application"){
            steps{
                sh "mvn clean package"
            }
        }
         stage ("Test Application"){
                    steps{
                        sh "mvn test"
                    }
                }
    }
}
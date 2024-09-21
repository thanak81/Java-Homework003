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
    }
    stages {
        stage ("Checkout from SCM"){
            steps{
                git branch: "main", credentialId: "github", url: "https://github.com/thanak81/Java-Homework003.git"
            }
        }
        }
}
pipeline {
    agent {
        label "jenkins-agent"
    }
    tools {
        jdk "Java21"
        maven "Maven3"
    }
    environment {
        APP_NAME = "java-homework003-pipeline"
        RELEASE = "1.0.0"
        DOCKER_USER = "thanak81"
        DOCKER_PASS = "dockerhub"
        IMAGE_NAME = "${DOCKER_USER}" + "/" + "${APP_NAME}"
        IMAGE_TAG  = "${RELEASE}-${BUILD_NUMBER}"
        APP_NAME = "spring-argo-pipeline"
        JENKINS_API_TOKEN= "${JENKINS_API_TOKEN}"
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

         stage ("Build & Push Docker Image"){
            steps{
                script {
                    docker.withRegistry("",DOCKER_PASS){
                        docker_image = docker.build "${IMAGE_NAME}"
                    }
                    docker.withRegistry("",DOCKER_PASS){
                        docker_image.push("${IMAGE_TAG}")
                        docker_image.push("latest")
                    }
                }
            }
         }
         stage ("Triggered CD Pipeline"){
            steps {
                script {
                    sh "curl -v -k --user admin:${JENKINS_API_TOKEN} -X POST -H "cache-control: no-cache" -H 'content-type: application/x-www-form-urlencoded' --data 'IMAGE_TAG=${IMAGE_TAG}' 'http://35.240.229.111:8080/job/springboot-complete-pipeline/buildWithParameters?token=gitops-token'
                }
            }
         }
    }
}
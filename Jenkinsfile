pipeline {
    agent any
    stages {
        stage ("French") {
            steps {
                sh "echo bonjour"
            }
        }
        stage ("English"){
            steps {
                sh "echo helloworld"
            }
        }
    }
    post {
        success {
            echo "wow you passed the test"
        }
        failure{
            echo "oh hell naw, your code is shite"
        }
    }

}
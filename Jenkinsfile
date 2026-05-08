pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'Java17'
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {

        success {
            echo 'PR Validation Successful'
        }

        failure {
            echo 'PR Validation Failed'
        }
    }
}

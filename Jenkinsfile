pipeline {
    agent any

    tools {
        maven 'Maven3'
        jdk 'Java17'
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Cloning repository...'
                git branch: 'main',
                url: 'https://github.com/sonawaneumesh210/UIFarmework.git'
            }
        }

        stage('Build & Test') {
            steps {
                echo 'Running Maven command...'
                sh 'mvn clean test'
            }
        }
    }

    post {

        success {
            echo 'Pipeline executed successfully!'
        }

        failure {
            echo 'Pipeline failed!'
        }

        always {
            echo 'Pipeline execution completed.'
        }
    }
}

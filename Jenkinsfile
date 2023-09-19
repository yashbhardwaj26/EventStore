pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
     sh 'mvn clean install'
            }
        }

        stage('Test') {
        steps {
     sh 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t eventstore-service .'
       }
        }

        stage('Docker Push') {
            steps {
                sh 'docker push eventstore-service'
            }
        }
    }
}

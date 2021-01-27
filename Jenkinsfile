pipeline {
    agent any

    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('build'){
            steps {
                sh './gradlew clean build'
            }
        }
        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }
    }
}
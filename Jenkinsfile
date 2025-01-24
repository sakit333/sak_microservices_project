pipeline {
    agent any

    environment {
        GIT_CRED = 'git-cred' // GitHub token credentials ID
    }

    stages {
        stage('Checkout Code from GitHub') {
            steps {
                script {
                    // Checkout code from GitHub
                    git credentialsId: "${GIT_CRED}", url: '', branch: 'main'
                }
            }
        }
        stage('Build and Run Auth Service') {
            steps {
                script {
                    // Build auth-service Docker image
                    docker.build('auth-service-image', './auth-service')

                    // Run the auth-service container on port 8081
                    docker.image('auth-service-image').run('-d -p 8081:8080')
                }
            }
        }
        stage('Build and Run User Service') {
            steps {
                script {
                    // Build user-service Docker image
                    docker.build('user-service-image', './user-service')

                    // Run the user-service container on port 8082
                    docker.image('user-service-image').run('-d -p 8082:8080')
                }
            }
        }
        stage('Build and Run Welcome Service') {
            steps {
                script {
                    // Build welcome-service Docker image
                    docker.build('welcome-service-image', './welcome-service')

                    // Run the welcome-service container on port 8083
                    docker.image('welcome-service-image').run('-d -p 8083:8080')
                }
            }
        }
    }
}

pipeline {
    agent any
    tools {
        maven 'maven_3.8.7'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(
                    branches: [[name: '*/jenkins']],
                    extensions: [],
                    userRemoteConfigs: [[url: 'https://github.com/AbdelilahSaouiri/CI-CD.git']]
                )
                sh 'mvn clean package'
            }
        }
        stage('Docker Build Image') {
            steps {
                script {
                    sh 'docker build -t demo .'
                }
            }
        }
        stage('Upload to Kubernetes') {
            steps {
                script {
                    sh 'kubectl apply -f K8S/deployment.yaml'
                    sh 'kubectl apply -f K8S/service.yaml'
                }
            }
        }
    }
}

pipeline {
    agent any
    tools {
        maven 'maven_3.8.7'
    }
    stages {
        stage('build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/jenkins']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/AbdelilahSaouiri/CI-CD.git']])
                sh 'mvn clean package'
            }
        }
        stage("docker build images") {
            steps {
                script {
                    sh 'docker build -t demo .'
                }
            }
        }
        stage('apply to Kubernetes') {
            steps {
                script {
                    sh """
                    echo 'Using KUBECONFIG=/c/Users/abdos/.kube/config'
                    export KUBECONFIG=/c/Users/abdos/.kube/config

                    echo 'Applying Deployment...'
                    kubectl apply -f K8S/deployment.yaml --validate=false

                    echo 'Applying Service...'
                    kubectl apply -f K8S/service.yaml --validate=false

                    echo 'Deployment to Kubernetes complete!'
                    """
                }
            }
        }
    }
}

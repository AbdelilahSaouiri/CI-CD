pipeline{
    agent any
    tools{
        maven 'maven_3.8.7'
    }
    stages{
        stage('build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/jenkins']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/AbdelilahSaouiri/CI-CD.git']])
                sh 'mvn clean package'
            }
        }
        stage("docker build images"){
            steps{
                script{
                   sh 'docker build -t demo .'                }
            }
        }
    }
}
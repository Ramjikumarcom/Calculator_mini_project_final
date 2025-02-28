pipeline {
    agent any
 environment {
        IMAGE_NAME = 'gupta9939/calculator_main_project_final'
        IMAGE_TAG = 'latest'
    }
stages {
        stage('Clone Repository') {
            steps {
                echo 'Cloning the repository...'
                git url: 'https://github.com/Ramjikumarcom/Calculator_mini_project_final.git', branch: 'main'
            }
        }
 stage('Build JAR') {
            steps {
                echo 'Building the JAR file with Maven...'
                sh 'mvn clean package'
            }
        }  stage('Build Docker Image') {
            steps {
                echo 'Building Docker image...'
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
            }
        }stage('Push Docker Image') {
            steps {
                echo 'Pushing Docker image to Docker Hub...'
                withDockerRegistry([credentialsId: 'docker-hub-credentials', url: '']) {
                    sh "docker push ${IMAGE_NAME}:${IMAGE_TAG}"
                }
            }
        } stage('Deploy with Ansible') {
            steps {
                echo 'Deploying with Ansible...'
                sh 'ansible-playbook -i ansible/hosts ansible/deploy.yml'
            }
        }
    }
   post {
        success {
            echo 'Pipeline executed successfully! 🚀'
        }
        failure {
            echo 'Pipeline failed. Check the logs for errors. ❌'
        }
    }
}

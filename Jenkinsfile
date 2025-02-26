pipeline {
    agent any

    stages {
        stage('Clone Repository') {
            steps {
                git url: 'https://github.com/Ramjikumarcom/Calculator_mini_project_final.git', branch: 'main'
            }
        }

        stage('Build JAR') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t gupta9939/calculator_main_project_final:latest .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withDockerRegistry([credentialsId: 'docker-hub-credentials', url: '']) {
                    sh 'docker push gupta9939/calculator_main_project_final:latest'
                }
            }
        }

        stage('Deploy with Ansible') {
            steps {
                script {
                    sh '''
                    # Run the Ansible playbook to deploy the updated Docker container
                    ansible-playbook -i ansible/hosts ansible/deploy.yml --ask-become-pass
                    '''
                }
            }
        }

        stage('Check Running Container') {
            steps {
                script {
                    sh 'docker ps'
                }
            }
        }
    }
}

pipeline {
    agent any
    tools {
        maven 'M3'
    }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', 
                url: 'https://github.com/RemshaaHaneef/jenkins-azure-demo.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        
        stage('Deploy') {
            steps {
                withCredentials([sshUserPrivateKey(
                    credentialsId: 'azure-vm-ssh-key',
                    keyFileVariable: 'SSH_KEY',
                    usernameVariable: 'SSH_USER'
                )]) {
                    sh '''
                        scp -i $SSH_KEY -o StrictHostKeyChecking=no target/*.jar azureuser@20.198.100.25:/home/azureuser/
                        ssh -i $SSH_KEY -o StrictHostKeyChecking=no azureuser@20.198.100.25 "sudo systemctl restart myapp"
                    '''
                }
            }
        }
    }
}

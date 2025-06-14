pipeline {
    agent any
    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', 
                url: 'https://github.com/RemshaaHaneef/jenkins-azure-demo.git'
            }
        }
        
        stage('Build with Maven') {
            steps {
                sh 'mvn clean package'
            }
        }
        
        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }
        
        stage('Deploy to Azure VM') {
            steps {
                sshagent(['azure-vm-ssh-key']) {
                    sh """
                        scp -o StrictHostKeyChecking=no \
                        target/*.jar azureuser@${AZURE_VM_IP}:/home/azureuser/
                        
                        ssh -o StrictHostKeyChecking=no \
                        azureuser@${AZURE_VM_IP} \
                        'sudo systemctl restart my-java-app.service'
                    """
                }
            }
        }
    }
}

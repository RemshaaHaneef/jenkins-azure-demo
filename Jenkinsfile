pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git credentialsId: 'github-creds', url: 'https://github.com/RemshaHaneef/jenkins-azure-demo.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Deploy to Azure') {
            steps {
                sh '''
                    scp -i /home/azureuser/key.pem target/*.jar azureuser@<azure-ip>:/home/azureuser/
                    ssh -i /home/azureuser/key.pem azureuser@<azure-ip> 'nohup java -jar /home/azureuser/*.jar > log.txt 2>&1 &'
                '''
            }
        }
    }
}

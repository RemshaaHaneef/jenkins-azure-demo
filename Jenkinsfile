pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: 'github-creds', url: 'https://github.com/RemshaaHaneef/jenkins-azure-demo.git'
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
                    scp -i /var/lib/jenkins/azure-key.pem target/*.jar azureuser@20.124.90.101:/home/azureuser/
                    ssh -i /var/lib/jenkins/azure-key.pem azureuser@20.124.90.101 'nohup java -jar /home/azureuser/*.jar > log.txt 2>&1 &'
                '''
            }
        }
    }
}

pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/username/my-java-app.git'
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
                    scp -i /path/to/key.pem target/myapp.jar azureuser@<azure_ip>:/home/azureuser/
                    ssh -i /path/to/key.pem azureuser@<azure_ip> "nohup java -jar /home/azureuser/myapp.jar > log.txt 2>&1 &"
                '''
            }
        }
    }
}

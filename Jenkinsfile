pipeline {
    agent any

    tools {
        maven 'Maven' 
        jdk 'JDK25'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Compile') {
            steps {
                echo 'Compiling the Voting Eligibility System...'
                // Changed 'sh' to 'bat' for Windows
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running JUnit Eligibility Tests...'
                bat 'mvn test'
            }
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging the application into a JAR file...'
                bat 'mvn package -DskipTests'
            }
        }
    }

    post {
        success {
            echo 'Voting System Pipeline Build Successful!'
        }
        failure {
            echo 'Build Failed. Please check the logs.'
        }
    }
}

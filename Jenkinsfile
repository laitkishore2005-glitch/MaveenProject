pipeline {
    agent any

    tools {
        // Updated names to match your Jenkins configuration
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
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo 'Running JUnit Eligibility Tests...'
                sh 'mvn test'
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
                sh 'mvn package -DskipTests'
            }
        }
    }

    post {
        success {
            echo 'Voting System Pipeline Build Successful!'
        }
        failure {
            echo 'Build Failed. Please check the test results for ineligibility logic errors.'
        }
    }
}

pipeline {
    agent any

    tools {
        // Ensure 'Maven 3.9' and 'JDK 17' match the names you configured 
        // in Jenkins under 'Manage Jenkins' -> 'Global Tool Configuration'
        maven 'Maven 3.9' 
        jdk 'JDK 17'
    }

    stages {
        stage('Checkout') {
            steps {
                // Clones your code from the Git repository defined in your Jenkins job
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
                    // This archives the unit test results in the Jenkins UI
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

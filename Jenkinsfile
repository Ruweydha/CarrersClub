pipeline {
    agent any
    stages{
        stage("Checkout"){
            steps{
                git url: https://github.com/Ruweydha/CarrersClub.git
            }
        }
        stage("Compile"){
            steps{
                sh './mvnw compile'
            }
        }
        stage("Unit Test"){
            steps{
                sh './mvnw test'
            }
        }
    }
}
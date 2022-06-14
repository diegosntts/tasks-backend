pipeline{
    agent any
    stages{
        stage ('Just test') {
            steps{
                bat 'mvn clean package -DSkipTests=true'
            }
        }
        // stage ('Unit tests') {
        //     steps{
        //         bat 'nvm clean package -DSkipTests=true'
        //     }
        // }   
        stage ('Sonar scanner') {
            environment{
                scannerHome = tool 'SONAR_SCANNER'
            }
            steps{
                withSonarQubeEnv('SONAR_LOCAL'){
                bat "${scannerHome}/bin/sonar-scanner -e -Dsonar.projectKey=DeployBack -Dsonar.host.url=http://localhost:9000 -Dsonar.login=cdec6b7fb5e3ee1042149a1770bf238e0d65355e -Dsonar.java.binaries=target "
                }
            }
        }
        stage('Quality Gate'){
            steps{
                sleep(5)
                timeout(time: 1, unit: 'MINUTES')
                waitForQualityGate aborpipeline = true
            }
        }
    }
}


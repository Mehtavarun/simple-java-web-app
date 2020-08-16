pipeline {
    agent any

    tools {
        maven "Maven"
    }
    options {
        timestamps()
        
        timeout(time: 1, unit: 'HOURS')
        
        skipDefaultCheckout()
    }

    stages {
        stage('Checkout') {
            steps {
                
                git 'https://github.com/Mehtavarun/simple-java-web-app.git'
                
            }
        }
        stage('Build') {
            steps {

                bat "mvn install"

            }
        }
        stage('Sonar Analysis') {
            steps {
                
                withSonarQubeEnv('Sonarqube'){
                    bat "mvn sonar:sonar -Dsonar.test.exclusions=**/test/**/*.* -Dsonar.exclusions=**/ai/**/*.*,**/jdbc/**/*.*,**/mpt/**/*.*,**/jcr/**/*.*,**/*.c,**/*.java,**/*.h,**/*.cc,**/*.cpp,**/*.cxx,**/*.c++,**/*.hh,**/*.hpp,**/*.hxx,**/*.h++,**/*.ipp,**/*.m -Dsonar.login=95b60403470ccd631852bbb4d751d41ec9c66ed8"
                }
                
            }
        }
        stage('Push to Artifactory'){
            steps {
                rtMavenDeployer(
                    id: 'deployer',
                    serverId: 'nagp@artifactory',
                    releaseRepo: 'Nagp',
                    snapshotRepo: 'Nagp'
                    )
                rtMavenRun(
                    pom: 'pom.xml',
                    goals: 'clean install',
                    deployerId: 'deployer'
                    )
                rtPublishBuildInfo(
                    serverId: 'nagp@artifactory'
                    )
            }
        }
        stage('Create Docker Image') {
            steps {
                
                bat "docker build -t mvarun96/simple-java-web-app:latest --no-cache -f Dockerfile ."
                
            }
        }
        stage('Push to DTR') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
                    
                    bat "echo | set /p=\"$PASSWORD\" | docker login --username $USERNAME --password-stdin && docker push $USERNAME/simple-java-web-app:latest"
                    
                }
            }
        }
        stage('Stop and Remove Container') {
            steps {
                
                bat "docker ps -aq --filter \"name=simple-java-web-app\" | (findstr . && docker stop simple-java-web-app && docker rm -fv simple-java-web-app) || echo \"No Container Running with name simple-java-web-app\""
                
            }
        }
        stage('Run New Container') {
            steps {
                
                bat "docker run -d --name simple-java-web-app -p 8080:8080 mvarun96/simple-java-web-app:latest"
                
            }
        }
    }
}

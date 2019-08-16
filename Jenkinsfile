pipeline {
//def workspace;
agent any 
// node {
 tools {
      maven "Maven 3.6.1"
      jdk 'jdk8'
   }
  stages {
    // stage('Checkout Source')
      //{
      //checkout([$class: 'GitSCM', branches: [[name: '*/master'], [name: '*/develop']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: '075a5905-76ba-4902-95de-bbefeeb59788', url: 'https://github.com/saikaushik-itsmyworld/Node-express-App']]])
      //workspace =pwd() 
        // steps {
           // checkout scm
         //}
      //} 
     stage('Initialize')
      {
       steps {
        sh ''' echo "PATH = ${PATH}"
               echo "M2_HOME = ${M2_HOME}"
            '''
       }
      }
     stage('Install dependencies'){ 
         steps {
          //sh 'npm config ls'
          //sh 'npm install'
            echo "Npm Packages has been installed"
         }
      }
      stage('Build'){
         steps {
            echo "Build the Code"
            sh 'mvn clean install'
        
         }
      }
   stage ('SonarQube Analysis'){
    steps{
     //dir("project_templates/java_project_template"){
      withSonarQubeEnv('sonarqube') {
       //sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
       sh '''mvn sonar:sonar \
          -Dsonar.projectKey=HelpSME \
          -Dsonar.host.url=http://192.168.1.186:9000 \
          -Dsonar.login=6cf451fa4e118614d412b1b0712db5c67f773dcd'''
      }
     }
    }
   
      stage('archive') {
      steps {
        parallel(
          "Junit": {
            //junit 'target/surefire-reports/*.xml'
            echo "Running Junit"
            
          },
          "Archive": {
            //archiveArtifacts(artifacts: 'target/SearchSME.jar', onlyIfSuccessful: true, fingerprint: true)
            //archiveArtifacts(artifacts: 'target/SearchSME*javadoc.jar', fingerprint: true)
           echo "Archive"
            
          }
        )
      }
    }
      stage('Deploy'){
         steps {
            echo"deploying the code"
         }
      }
   }
}

//Uses Declarative syntax to run commands inside a container.


//Constants
// APP_NAME = "dockerapp"
// dockerImageName = "charan2616/dockerapp"
// GIT_REPOSITORY = ""
// GIT_CREDENTIALS = "GIT_CRED"

pipeline {
   agent any
   stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: 'main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GIT_CRED', url: 'https://github.com/vcvarma/dockerapp.git']]])
                sh "ls -lart ./*"
            }
        }     
    }
}


// //pipeline
// pipeline {
//     agent any
//     stages {
//         stage ('Git Checkout'){
//             steps{
//                 checkout([$class: 'GitSCM', 
//                 branches: [[name: "*/${BRANCH_NAME}"]], 
//                 userRemoteConfigs: [[credentialsId: GIT_CREDENTIALS, url: GIT_REPOSITORY]]
//                 ]
//                 )
//             }
//         }
//         // stage ('Docker Build and Push image'){

//         // }
//         // stage ('Deployment'){

//         // }
//     }
// }
    
// Uses Declarative syntax to run commands inside a container.
// def branch = "main"
// def allowed_branch


// Constants
// APP_NAME = "dockerapp"
// dockerImageName = "charan2616/dockerapp"
// GIT_REPOSITORY = ""
// GIT_CREDENTIALS = "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"


pipeline {
   agent any
//   environment {
//       DOCKERHUB_CREDENTIALS = credentials('DOCKER_CRED')
//     }
   stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: 'main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GIT_CRED', url: 'https://github.com/vcvarma/dockerapp.git']]])
                sh "ls -lart ./*"
            }
        } 
        stage('Build image') {
            steps{
                // sh "echo $PATH=/usr/local/"
                sh "docker build -t charan2616/dockerapp ."
            }
        }
        stage('Push image') {
            environment {
                DOCKERHUB_CREDENTIALS = credentials('DOCKER_CRED')
                //PATH = "/usr/local/bin/"
            }
            steps{
                // sh "echo $PATH=/usr/local/bin/docker"
                //docker.withRegistry([file(credentialsId: 'DOCKER_CRED', URL : 'https://hub.docker.com/')]){
                 sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                // sh "docker login -u charan2616 -p Sirisha@2616"
                sh 'docker push charan2616/dockerapp'
            //}
            }
        } 
        stage('deployment'){
            steps{
                sh'docker run -itd -p 8082:8080 charan2616/dockerapp '
            }
        }   
    }
}


// String getBranchEnv(String branch_name) {
//    return env_branch.find{(it.value).contains(branch_name)}?.key
// }

// List<String> getAllowedbranches() {
// def all_allowed_branches = []
//   env_branch.each{ k,v ->
//     all_allowed_branches.addAll(v)
//   }
//   return all_allowed_branches
// } 

// //pipeline
// pipeline {
//     agent any
//     stages {
//         stage ('initialization'){
//             steps{
//                 script {
//                     allowed_branch = getAllowedbranches()
//                     branchEnv = getBranchEnv(BRANCH_NAME)
                    
//                 }
//             }
//         }
//         stage ('Git Checkout'){
//             when {
//                 expression { allowed_branch.contains(BRANCH_NAME) }
//             }
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
    
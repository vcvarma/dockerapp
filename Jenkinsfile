Uses Declarative syntax to run commands inside a container.
def branch = "main"
def allowed_branch


Constants
APP_NAME = "dockerapp"
dockerImageName = "charan2616/dockerapp"
GIT_REPOSITORY = ""
GIT_CREDENTIALS = "GIT_CRED"

// pipeline {
//    agent any
//    stages {
//         stage('Checkout') {
//             steps {
//                 checkout([$class: 'GitSCM', branches: [[name: 'main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'GIT_CRED', url: 'https://github.com/vcvarma/dockerapp.git']]])
//                 sh "ls -lart ./*"
//             }
//         }     
//     }
// }
String getBranchEnv(String branch_name) {
   return env_branch.find{(it.value).contains(branch_name)}?.key
}

List<String> getAllowedbranches() {
def all_allowed_branches = []
  env_branch.each{ k,v ->
    all_allowed_branches.addAll(v)
  }
  return all_allowed_branches
} 

//pipeline
pipeline {
    agent any
    stages {
        stage ('initialization'){
            steps{
                script {
                    allowed_branch = getAllowedbranches()
                    branchEnv = getBranchEnv(BRANCH_NAME)
                    
                }
            }
        }
        stage ('Git Checkout'){
            when {
                expression { allowed_branch.contains(BRANCH_NAME) }
            }
            steps{
                checkout([$class: 'GitSCM', 
                branches: [[name: "*/${BRANCH_NAME}"]], 
                userRemoteConfigs: [[credentialsId: GIT_CREDENTIALS, url: GIT_REPOSITORY]]
                ]
                )
            }
        }
        // stage ('Docker Build and Push image'){

        // }
        // stage ('Deployment'){

        // }
    }
}
    
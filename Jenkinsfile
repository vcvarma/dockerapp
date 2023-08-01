// Uses Declarative syntax to run commands inside a container.
def branch = "main"
def allowed_branch


// Constants
APP_NAME = "dockerapp"
dockerImageName = "charan2616/dockerapp"
GIT_REPOSITORY = "git@github.com:vcvarma/dockerapp.git"
GIT_CREDENTIALS = "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"


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
    
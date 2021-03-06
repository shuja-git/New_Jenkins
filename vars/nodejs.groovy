//def info(message) {
//    echo "INFO: ${message}"
//}
//
//def warning(message) {
//    echo "WARNING: ${message}"
//}
// for nodejs compilation is not needed
def call() {

    pipeline{
        agent { label "${BUILD_LABEL}" }

// triggers {  pollSCM('H/2 * * * *') }
        environment {
            PROG_LANG_NAME = "nodejs"
            PROG_LANG_VER  = "16"
            NEXUS = credentials('NEXUS')
            }

        stages {
            stage('Label Build'){
                steps{
                    script{
       env.gitTag = GIT_BRANCH.split('/').last()
         addShortText background: 'white', borderColor: 'white', color: 'RED', link: '', text: "${gitTag}"
                    }
                }

            }

            stage('Checking code Quality'){
            steps {
                script {
                    common.SonarQube()

                }

            }
        }
            stage('Link Check'){
                steps{
//                    sh '/home/centos/node_modules/eslint/bin/eslint.js *.js'
                    sh 'echo Lint checks means style of program checks'
                }
            }


            stage('Test Cases'){
                steps{
                    sh 'echo "${COMPONENT}" Test case'
                    sh 'env'
                }
            }
            stage('Publish Artifacts'){
           when {
           expression { sh([returnStdout: true, script: 'echo ${GIT_BRANCH} | grep tags || true' ]) }
                    }
                steps{
//                    sh 'echo Publish Artifacts'
////                    sh 'env'
                    script{
                        common.prepareArtifacts()
                        common.publishArtifacts()

//                         println 'Publilsh Artifacts'
                    }
                }
            }

        }
        post {
            always {
                cleanWs()
            }
        }

    }


}


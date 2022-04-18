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

 triggers {  pollSCM('H/2 * * * *') }

        stages {

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
                steps{
                    sh 'echo Publish Artifacts'
                    sh 'env'
//                    script{
//                        common.publishArtifacts()
//                    }
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


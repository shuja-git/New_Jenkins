//def info(message) {
//    echo "INFO: ${message}"
//}
//
//def warning(message) {
//    echo "WARNING: ${message}"
//}
//
def call() {

    pipeline{
        agent { label "${BUILD_LABEL}" }

 triggers {  pollSCM('*/2 * * * *') }

        stages {

            stage('Check code Quality'){
            steps {
                script {
                    common.SonarQube()
                }

            }
        }
            stage('Link Check'){
                steps{
//                    sh '/home/centos/node_modules/eslint/bin/eslint.js *.js'
                    sh 'echo Lint checks'
                }
            }


            stage('Test Cases'){
                steps{
                    sh 'echo "${COMPONENT}" Test case'
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


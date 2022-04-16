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
        agent { label 'WORKSTATION' }

// triggers {  pollSCM('*/2 * * * *') }

        stages {

            stage('Compile Code'){
                steps{
                    sh 'echo Compile "${COMPONENT}" Code'
                }
            }

            stage('Code Chek'){
                steps{
                    sh 'echo "${COMPONENT}" Code check'
                }
            }

            stage('Test Cases'){
                steps{
                    sh 'echo "${COMPONENT}" Test case'
                }
            }


        }
    }


}


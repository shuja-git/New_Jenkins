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
                    sh 'echo Code check'
                }
            }

            stage('Code Chek'){
                steps{
                    sh 'echo Code check'
                }
            }

            stage('Test Cases'){
                steps{
                    sh 'echo Test case'
                }
            }


        }
    }


}


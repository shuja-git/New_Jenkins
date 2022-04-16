def call() {

    pipeline{
        agent { label "${BUILD_LABEL}" }

// triggers {  pollSCM('*/2 * * * *') }

        stages {

            stage('Code Chek'){
                steps{
                    sh 'echo "${COMPONENT}" Code check'
                }
            }
            stage('Link Check'){
                steps{
                    sh 'echo "${COMPONENT}" Link Check'
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


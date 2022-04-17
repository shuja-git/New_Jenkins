def call() {

    pipeline{
        agent { label "${BUILD_LABEL}" }

// triggers {  pollSCM('*/2 * * * *') }

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


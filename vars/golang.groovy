def call() {

    pipeline{
        agent { label "${BUILD_LABEL}" }

// triggers {  pollSCM('H/2 * * * *') }

        environment {
            PROG_LANG_NAME = "golang"
            PROG_LANG_VER  = "1.16"
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
            stage('Publish Artifacts'){
                when {
                    expression { sh([returnStdout: true, script: 'echo ${GIT_BRANCH} | grep tags || true' ]) }
                }
                steps{
                    script{
                        common.prepareArtifacts()
                        common.publishArtifacts()
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


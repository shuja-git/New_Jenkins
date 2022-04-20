import org.jenkinsci.plugins.pipeline.modeldefinition.Utils
def SonarQube(){
    println("SonarQube Testing- ")

//  sh 'sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://172.31.12.130:9000 -Dsonar.login=admin -Dsonar.password=admin123'
//
//    sh 'sonar-quality-gate.sh admin:admin123 172.31.12.130 ${COMPONENT}'
}
def publishArtifacts() {
//    if (env.GIT_BRANCH == "*tag*") {
//        println 'Ran on Tag'
//    }
//    else {
//        Utils.markStageSkippedForConditional('Publish Artifacts')
//    }

}
def prepareArtifacts(){
    if(PROG_LANG_NAME == "nodejs" && PROG_LANG_VER == "16"){
        sh '''
          echo Hello
          echo Bye
        '''
    }
}
//this is comment

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
      sh '''
        curl -f -v -u ${NEXUS_USR}:${NEXUS_PSW} --upload-file ${COMPONENT}-${gitTag}.zip http://nexus.roboshop.internal:8081/repository/${COMPONENT}/${COMPONENT}-${gitTag}.zip
      '''
}
def prepareArtifacts(){
//    env.gitTag = GIT_BRANCH.split('/').last()
    if(PROG_LANG_NAME == "nodejs" && PROG_LANG_VER == "16"){
        sh '''
          npm install
          zip -r ${COMPONENT}-${gitTag}.zip nod_modules server.js
          ls -ltr
        '''
    }
}
//this is comment

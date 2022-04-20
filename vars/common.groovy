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
    if(PROG_LANG_NAME == "java" && PROG_LANG_VER == "1.8"){
        sh '''
          mvn clean package
          mv target/${COMPONENT}-1.0.jar ${COMPONENT}.jar 
          zip -r ${COMPONENT}-${gitTag}.zip ${COMPONENT}.jar
        '''
    }
    if(PROG_LANG_NAME == "python" && PROG_LANG_VER == "3"){
        sh '''
          zip -r ${COMPONENT}-${gitTag}.zip requirements.txt *.py ${COMPONENT}.ini
        '''
    }
    if(PROG_LANG_NAME == "golang" && PROG_LANG_VER == "1.16"){
        sh '''
        go mod init dispatch
        go get
        go build
       zip -r ${COMPONENT}-${gitTag}.zip ${COMPONENT}
        '''
    }
    if(PROG_LANG_NAME == "angular"){
        sh '''
        cd static
        zip -r ../${COMPONENT}-${gitTag}.zip *
        
        '''
    }
}
//this is comment

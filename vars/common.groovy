def SonarQube(){
    println("SonarQube Testing- ")

  sh 'sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://172.31.12.130:9000 -Dsonar.login=admin -Dsonar.password=admin123'


}
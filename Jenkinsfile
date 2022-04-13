//  options example
//-------------------
// pipeline {
// agent any
// options { disableConcurrentBuilds() }
// stages{
// stage('one'){
// steps{
//     sh 'sleep 5'
// }
// }
// }
// }

//-----------------------------------
// Environment Example
//-----------------------------------
pipeline{
agent any
environment {
  URL1 = 'google.com'
  SSH = credentials("CENTOS")
  SSH1 = credentials("common/ssh")
}
stages {
stage('Environment parameter Example'){
steps{
// echo URL1
// sh 'echo ${URL1}'
echo SSH
sh 'env'
sh 'echo ${SSH1} | base64'
}
}
}
}

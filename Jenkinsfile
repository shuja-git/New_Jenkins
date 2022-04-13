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
}
stages {
stage('Environment parameter Example'){
steps{
echo URL1
sh 'echo ${URL1}'

}
}
}
}

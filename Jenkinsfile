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
// pipeline{
// agent any
// environment {
//   URL1 = 'google.com'
//   SSH = credentials("CENTOS")
//   SSH1 = credentials("uname")
// }
// stages {
// stage('Environment parameter Example'){
// steps{
// // echo URL1
// // sh 'echo ${URL1}'
// echo SSH
// sh 'env'
// sh 'echo ${SSH1} | base64'
// }
// }
// }
// }
//----------------------------------
//  Parameters Example
// ---------------------------------
// pipeline {
//     agent any
//     parameters {
//         string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
//
//         text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')
//
//         booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')
//
//         choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
//
//         password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
//     }
//     stages {
//         stage('Example') {
//             steps {
//                 echo "Hello ${params.PERSON}"
//
//                 echo "Biography: ${params.BIOGRAPHY}"
//
//                 echo "Toggle: ${params.TOGGLE}"
//
//                 echo "Choice: ${params.CHOICE}"
//
//                 echo "Password: ${params.PASSWORD}"
//             }
//         }
//     }
// }
// -----------------------------------------------------
// tools example
// -----------------------------------------------------
// pipeline{
// agent any
// tools {
//         maven 'maven 3.5.0'
//     }
// stages {
// stage('Maven'){
// steps{
//   sh 'mvn --version'
// }
//
// }
// }
// }
// --------------------------------------------------
// input example
//---------------------------------------------------
// pipeline {
//     agent any
//     stages {
//         stage('Example') {
//             input {
//                 message "Should we continue?"
//                 ok "Yes, we should."
//                 submitter "shuja,bob"
//                 parameters {
//                     string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
//                 }
//             }
//             steps {
//                 echo "Hello, ${PERSON}, nice to meet you."
//             }
//         }
//     }
// }
// ------------------------
// when condition example
// ---------------------------
// pipeline{
// agent any
// parameters {
// choice(name: 'ENV', choices: ['DEV', 'PROD'], description: 'Choose Env')
// }
// stages{
// stage('DEV'){
// when {
//         environment name: 'ENV', value: 'DEV'
//             }
// steps{
//    echo 'DEV'
// }
// }
// stage('PROD'){
// when {
//         environment name: 'ENV', value: 'PROD'
//             }
//
// steps{
//  echo 'PROD'
// }
// }
// }
// }
// ----------------------------
// parallel stages
// ----------------------------
pipeline{
agent any
stages{
stage('One-Sequential'){
steps{
sh 'sleep 45'
}
}
stage('Two-Parallel'){
parallel{
stage('Two1'){
steps{
sh 'sleep 60'
}
}

stage('Two2'){
steps{
sh 'sleep 90'
}
}


}
}
}

}












pipeline {
    agent any

    options {
        buildDiscarder logRotator(
            artifactDaysToKeepStr: '', 
            artifactNumToKeepStr: '', 
            daysToKeepStr: '7', 
            numToKeepStr: '8'
        )
    }

    parameters {
        string defaultValue: 'master', name: 'TMS_BRANCH', trim: true
    }

    stages {
        stage('Build') {
            parallel {
                stage('Setup') {
                    steps {
                        buildName "${TMS_BRANCH} #${BUILD_NUMBER}"
                        buildDescription "4.1.0.${BUILD_NUMBER}"
                        sh '/home/user/pcat/test.sh'
                    }
                }
                stage('SGH-Part-1') {
                    steps {
                        build job: 'sgh-part-1', parameters: [string(name: 'TMS_BRANCH', value: "${TMS_BRANCH}")]
                    }
                }
                stage('SGH-Part-2') {
                    steps {
                        build job: 'sgh-part-2', parameters: [string(name: 'TMS_BRANCH', value: "${TMS_BRANCH}")]
                    }
                }
                stage('SGH-Part-3') {
                    steps {
                        build job: 'sgh-part-3', parameters: [string(name: 'TMS_BRANCH', value: "${TMS_BRANCH}")]
                    }
                }
                stage('SGH-Part-4') {
                    steps {
                        build job: 'sgh-part-4', parameters: [string(name: 'TMS_BRANCH', value: "${TMS_BRANCH}")]
                    }
                }
            }

            post {
                success {
                    echo "post - success"
                }
            }
        }
    }
}

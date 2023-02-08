def buildSafe(Map config) {
    try {
        build job: config.job, parameters: config.parameters
    }
    catch (hudson.AbortException e) {
        echo "Some error is happened ${e}"
    }
}

def enableTest() {
    echo 'Enable the tests'
    sh 'env | sort'
}

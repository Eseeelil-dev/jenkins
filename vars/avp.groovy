def buildSafe(Map config) {
    try {
        echo "Run ${config.job}"
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

def cleanupHosts(List<String> hosts) {
    hosts.each { host -> 
        echo "Cleanup ${host}"
        sh 'hostname'
    }
}

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
    sh 'free -h'
}

/**
  * Cleanup the hosts
  *
  * @param hosts List of hosts to cleanup
  */
def cleanupHosts(List<String> hosts) {
    hosts.each { host -> 
        sh label: "Cleanup ${host}", script: """#!/bin/bash +x
            rm -rf /tmp/* || true
        """
    }
}

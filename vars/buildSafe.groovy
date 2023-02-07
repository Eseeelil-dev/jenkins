def call(Map config) {
    node {
        try {
            build job: config.job, parameters: config.parameters
        }
        catch (hudson.AbortException e) {
            echo "Some error is happened ${e}"
        }
    }
}

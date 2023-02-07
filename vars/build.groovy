def call() {
    try {
        build job: job, parameters: parameters
    }
    catch (hudson.AbortException e) {
        echo "Some error is happened ${e}"
    }
}

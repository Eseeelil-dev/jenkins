package ru.avp

def Build(String job, List parameters) {
    try {
        build job: job, parameters: parameters
    }
    catch (hudson.AbortException e) {
        echo "Some error is happened ${e}"
    }
}

def Echo(String text) {
    ehco "${text}"
}

return this

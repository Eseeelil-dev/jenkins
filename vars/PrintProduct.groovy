#!/usr/bin/env groovy

def call(product, version) {
    if (!product || !version)
        return
    sh "echo ${product}"
    sh "echo ${version}"
}

#!/usr/bin/env groovy

/**
  * Cleanup the hosts
  *
  * @param hosts List of hosts to cleanup
  */
def call(List<String> hosts) {
    hosts.each { host ->
        sh label: "Cleanup ${host}", script: """#!/bin/bash +x
            echo ${host}
        """
    }
}

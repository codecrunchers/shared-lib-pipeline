package com.codecrunchers.ci

import com.codecrunchers.ci.builders.LambdaBuilder
import groovy.transform.TupleConstructor

@TupleConstructor
public class PipelineDirector {
    BuildBuilder builder
    String builderId
    String executor
    String serviceId

    void construct(body) {
        println "Initiating Build with ${builder.title()}, ${executor} for ${serviceId}"

        assignBuilder()
        def config = [:]
        body.resolveStrategy = Closure.DELEGATE_FIRST
        body.delegate = config
        body()

        node {
            // Clean workspace before doing anything
            deleteDir()

                try {
                    stage ('Clone') {
                        checkout scm
                    }
                    stage ('Build') {
                        sh "echo 'building ${config.projectName} ...'"
                    }
                    stage ('Tests') {
                        parallel 'static': {
                            sh "echo 'shell scripts to run static tests...'"
                        },
                                 'unit': {
                                     sh "echo 'shell scripts to run unit tests...'"
                                 },
                                 'integration': {
                                     sh "echo 'shell scripts to run integration tests...'"
                                 }
                    }
                    stage ('Deploy') {
                        sh "echo 'deploying to server ${config.serverDomain}...'"
                    }
                } catch (err) {
                    println "${err}"
                    currentBuild.result = 'FAILED'
                        throw err
                }
        }

}

private BuildBuilder assignBuilder(){
    println "Assinging Builder to ${serviceId}: ${builderId}"

    switch(builderId) {
        case "lambda":
            builder =  new LambdaBuilder()
        default:
                throw new RuntimeException("Unsupported Builder");
    }
}

}



package com.codecrunchers.ci
import groovy.transform.TupleConstructor

@TupleConstructor
public class PipelineDirector {
    BuildBuilder builder
    String builderId
    String executor
    String serviceId

    void construct(body) {
        assignBuilder()
        new com.codecrunchers.ci.PipelineDirector()
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
                    currentBuild.result = 'FAILED'
                        throw err
                }
        }

}

private BuildBuilder assignBuilder(){
    switch(builderId) {
        case "lambda":
            builder =  LambdaBuilder()
        default:
                throw new RuntimeException("Unsupported Builder");
    }
}

}



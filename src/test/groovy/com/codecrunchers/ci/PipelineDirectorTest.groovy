package com.codecrunchers.ci;

import spock.lang.Specification

class PipelineDirectorTest extends Specification {
    def "construct returns a pipeline definition"() {
            setup:
            def pipelineDirector

            when:
            pipelineDirector =  new com.codecrunchers.ci.PipelineDirector(
                    builderId: "lambda",
                    executor: "",
                    serviceId: "test"
                    )
            then:
                pipelineDirector.builderId == "lambda"
                pipelineDirector.executor == ""
                pipelineDirector.serviceId == "test"

    }
}


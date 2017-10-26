package com.codecrunchers.ci;

import spock.lang.Specification

class BuildTest extends Specification {
    def "Build has commands for lifecycle"() {
            setup:
            def build

            when:
            build =  new com.codecrunchers.ci.Build(
                    title : "lambdabuild",
                    compile: "echo \"compile\"",
                    test: "echo \"test\"",
                    deploy: "echo \"deploy\""
                    )
            then:
            build.title == "lambdabuild"
            build.compile =~ /compile/
            build.test  =~ /test/
            build.deploy  =~ /deploy/

    }
}



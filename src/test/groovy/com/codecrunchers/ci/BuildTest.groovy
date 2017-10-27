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

    def "Build has commands for lifecycle with asignment"() {
            setup:
            def build =  new com.codecrunchers.ci.Build()
            when:
                build.setTitle("lambdabuild")
                build.setCompile("compile")
                build.setTest("test")
                build.setDeploy("deploy")
            then:
            build.title == "lambdabuild"
            build.compile =~ /compile/
            build.test  =~ /test/
            build.deploy  =~ /deploy/

    }

}



package com.codecrunchers.ci.builders

import com.codecrunchers.ci.*

public class LambdaBuilder extends BuildBuilder {

    LambdaBuilder(){
        createNewBuild()
    }

    void setTitle(){
        build.title = "echo \"Test Build\""
    }
    void setCompile(){
        build.compile = "echo \"Compile\""
    }
    void setTest(){
        build.test = "echo \"Test\""

    }

    void setDeploy(){
        build.deploy = "echo \"Test Build\""

    }

}


package com.codecrunchers.ci.builders
import com.codecrunchers.ci.*

public class LamdaBuilder extends BuildBuilder {

    LamdaBuilder(){
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


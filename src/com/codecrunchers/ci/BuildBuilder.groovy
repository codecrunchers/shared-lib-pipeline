package com.codecrunchers.ci

abstract public class BuildBuilder {
    protected Build build

    Build getBuild(){
        build
    }

    protected void createNewBuild(){
        build = new Build()
    }

    abstract void setTitle()
    abstract void setCompile()
    abstract void setTest()
    abstract void setDeploy()
}


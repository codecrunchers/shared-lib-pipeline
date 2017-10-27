library identifier: 'custom-lib@master', retriever: modernSCM(
  [$class: 'GitSCMSource',
   remote: 'git@git.mycorp.com:my-jenkins-utils.git',
   credentialsId: 'my-private-key'])

@Library("builder") 
import com.codecrunchers.ci.*
import com.codecrunchers.ci.builders.*

standardPipeline {
    projectName = "Project1"
    serverDomain = "Project1 Server Domain"
}


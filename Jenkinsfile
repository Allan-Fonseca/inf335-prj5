pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/Allan-Fonseca/inf335-prj5'

                // Run Maven on a Unix agent.
                sh "cd inf33-prj02; mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/inf33-prj02/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'inf33-prj02/target/*.jar'
                }
            }
        }
    }
}

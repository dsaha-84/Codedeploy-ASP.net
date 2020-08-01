pipeline {
    agent any

    stages {
        stage('Dev') {
            steps {
                echo 'Development Build'
                build 'ci-dev'
            }
        }
        stage('QA') {
            input {
                message "Please approve to proceed ?"
                ok "Yes, we should."
                submitter "alice,bob"
                parameters {
                    string(name: 'PERSON', defaultValue: 'Mr Davidu', description: 'Who should I say hello to?')
                }
            }
            steps {
                echo 'CI Release Environment'
                build 'ci-release'
            }
        }
        stage('Stage') {
            input {
                message "Please approve to proceed ?"
                ok "Yes, we should."
                submitter "alice,bob"
                parameters {
                    string(name: 'Approver', defaultValue: 'Mr Davidu', description: 'Who should I say hello to?')
                }
            }
            steps {
                echo 'Hello World'
            }
        }
        stage('Production') {
            input {
                message "Please approve to proceed ?"
                ok "Yes, we should."
                submitter "alice,bob"
                parameters {
                    string(name: 'PERSON', defaultValue: 'Mr Davidu', description: 'Who should I say hello to?')
                }
            }
            steps {
                echo 'Hello World'
            }
        }
    }
}

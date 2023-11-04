pipeline{
    environment{
        docker_image = ""
    }
    agent any
    stages{
        stage("Step 1: Git Clone"){
            steps{
                git branch: "main", url: "https://github.com/mukul1357/calculator.git"
            }
        }
        stage("Step 2: Maven Build"){
            steps{
                sh "mvn clean install"
            }
        }
        stage("Step 3: Build docker image"){
            steps{
                script{
                    docker_image = docker.build "mukul1357/calculator:latest"
                }
            }
        }
        stage("Step 4: Push Docker image to hub"){
            steps{
                script{
                    docker.withRegistry("", "docker"){
                        docker_image.push()
                    }
                }
            }
        }
        stage("Step 5: Clean docker image"){
            steps{
                // sh "docker stop spe_mini_project"
                // sh 'docker rm $(docker ps -a -q)'
                sh 'docker image rm mukul1357/calculator'
                // sh 'docker rmi $(docker images --filter "dangling=true" -q --no-trunc)'
            }
        }
        stage("Step 6: Ansible Deployment"){
            steps{
                ansiblePlaybook becomeUser: null,
                colorized: true,
                credentialsId: 'localhost',
                disableHostKeyChecking: true,
                installation: 'Ansible',
                inventory: 'Deployment/inventory',
                playbook: 'Deployment/deploy.yml',
                sudoUser: null
            }
        }
    }
}

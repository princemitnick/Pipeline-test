pipeline{
	agent any
	environment {
		SERVER="172.25.102.53"
	}
	stages {
		stage('Build') {
		    steps {
		        echo 'Running build automation'
            	sh 'mvn clean install'
            	archiveArtifacts artifacts: 'target/student-0.0.1-SNAPSHOT.jar'
		    }
		}

		stage('Build Docker Image') {
			steps {
				script {
					app = docker.build('princemitnick/student')
					//app.inside {
					//	sh 'echo ${curl localhost:8080}'
					//}
				}
			}
		}
		stage('Push Docker Image'){
			steps {
				script {
					docker.withRegistry('https://registry.hub.docker.com', 'docker_hub_login') {
						//app.push("${env.BUILD_NUMBER}")
						app.push("latest")
					}
				}
			}
		}
		stage('DeployToProduction') {
			steps {
				echo 'Deploy To Production Stage'
				withCredentials([usernamePassword(credentialsId: 'webserver_login', usernameVariable: '$USERNAME', passwordVariable: '$PASSWORD')]) {
					script {
						try{
							sh "sshpass -p 'jenkins' -v ssh -o StrictHostKeyChecking=no deploy@$SERVER 'docker pull princemitnick/student:latest'"
							sh "sshpass -p 'jenkins' -v ssh -o StrictHostKeyChecking=no deploy@$SERVER 'docker stop student && docker rm student'"
							echo: "Yes we did it"
						}catch (err){
							echo "caught error : $err"
						}
						sh "sshpass -p 'jenkins' -v ssh -o StrictHostKeyChecking=no deploy@$SERVER 'docker run -d -p 9999:9091 --name student princemitnick/student:latest'"
						echo "We dit it guys"
					}
				}
			}
		}

	}
}
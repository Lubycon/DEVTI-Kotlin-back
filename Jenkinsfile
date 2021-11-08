////이미지 빌드시 이름을 ECR 쪽으로 변경
//app = docker.build("676381797150.dkr.ecr.ap-northeast-2.amazonaws.com/devti/kotlin-api-server")
//// ECR에서 생성한 Repository URI로 변경 및 Jenkins AWS Credential으로 변경
//docker.withRegistry('https://********.dkr.ecr.ap-northeast-2.amazonaws.com', 'ecr:ap-northeast-2:teichae-ecr-credentials')

pipeline {
    // agent 어차피 노드 하나니까 any
    agent any

    //몇분 주기 trigger  3분주기로 pipeline 구동
    triggers {
        pollSCM('*/3 * * * *')
    }

    //pipeline 에서 쓸 환경변수
    environment {
        AWS_ACCESS_KEY_ID = credentials('awsAccessKeyId')
        AWS_SECRET_ACCESS_KEY = credentials('awsSecretAccessKey')
        AWS_DEFAULT_REGION = 'ap-northeast-2'
        HOME = '.' // Avoid npm root owned
    }

    //큰 단계
   stages {
        // 레포지토리를 다운로드 받음
        stage('Prepare') {
            agent any

            steps {
                echo 'Clonning Repository'

                git url: 'https://github.com/Lubycon/DEVTI-Kotlin-back.git',
                        branch: 'feat/devti_new_service',
                        credentialsId: 'git-token'
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    echo 'Successfully Cloned Repository'
                }

                always {
                    echo "i tried..."
                }

                cleanup {
                    echo "after all other post condition"
                }
            }
        }

        stage('Bulid Backend') {
            agent any
            steps {
                echo 'Build Backend'

                dir ('.'){
                    sh """
                ./gradlew clean build -x test
                docker build -t devti/kotlin-api-server .              
                """
                }
            }

            post {
                failure {
                    error 'This pipeline stops here...'
                }
            }
        }

        stage('Deploy Backend') {
            agent any

            steps {
                echo 'Build Backend'

                dir ('.'){
                    sh '''
                docker rm -f $(docker ps -aq)
                docker run -p 80:80 -d server
                '''
                }
            }

            post {
                success {
                    echo 'Successfully deployed!'

                }

                failure {
                    error 'deploy fail'
                }
            }
        }
    }
}

pipeline {
    agent any

    environment {
       COPY_RIGHT = 'chen dajie'
       VERSION    = '1.0.0'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                echo '编译环境....'
                sh 'printenv'
                echo 'mvn版本信息..'
                sh 'mvn --version'
                echo '编译工程....'
                sh 'mvn clean'
            }
        }

        stage('Test') {
            steps {
                echo 'Testing..'
                echo '单元测试....'
            }
        }

        stage('Deploy') {
            steps {
                echo '构建现有版本镜像....'

            }
        }
    }
}
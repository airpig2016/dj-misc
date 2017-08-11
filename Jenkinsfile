pipeline {
    agent any

    environment {
       COPY_RIGHT = '福建阿思可网络教育有限公司版权所有'
       VERSION    = '1.0.0'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                echo '编译环境....'
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
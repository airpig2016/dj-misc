pipeline {
    agent any

    environment {
       COPY_RIGHT = 'chen dajie'
       VERSION    = '1.0.0'
    }

    stages {
        stage('Build') {
            steps {
                echo '====================== Building ======================'
                echo '====================== 编译环境 ======================'
                sh 'printenv'
                echo '====================== mvn版本信息 ======================'
                sh '/Users/dajiechen/software/java/maven/apache-maven-3.3.9/bin/mvn --version'
                echo '====================== 编译工程 ======================'
                sh '/Users/dajiechen/software/java/maven/apache-maven-3.3.9/bin/mvn clean'
            }
        }

        stage('Test') {
            steps {
                echo '====================== Testing ======================'
                echo '====================== 单元测试 ======================'
            }
        }

        stage('Deploy') {
            steps {
                echo '====================== 构建现有版本镜像 ======================'
                sh '/Users/dajiechen/software/java/maven/apache-maven-3.3.9/bin/mvn package -Dmaven.test.skip=true -pl ${projectName} -am -amd'
                sh '/Users/dajiechen/software/java/maven/apache-maven-3.3.9/bin/mvn -f ${projectName} docker:build'
                echo '====================== 移除该主机现有版本镜像 ======================'

                sh '/Users/dajiechen/software/java/maven/apache-maven-3.3.9/bin/mvn -f ${projectName} docker:removeImage'
                sh '/Users/dajiechen/software/java/maven/apache-maven-3.3.9/bin/mvn clean'

            }
        }
    }
}
#!/usr/bin/env groovy

def call(){
   

   pipeline {
    
    agent {
      label: slave1
    }

    stages {
        
        stage('install nginx') {
            steps {
               sh 'sudo yum install nginx -y'
            }
        }
        stage('start nginx') {
            steps {
                sh "sudo systemctl enable nginx "
                 sh "sudo systemctl start nginx "
            }    
        }
       stage('test nginx') {
            steps {
                sh "curl localhost "
            }    
        }
       
    }
  
}
}

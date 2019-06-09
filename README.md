# RecruitersApp

THESE APPLICATION REQUIRES PORT 8080, 4200 AND 27017 TO BE FREE ON THE MACHINE TO BE STARTED ON.
To start the application in your machine, follow the below steos:

1 ) Clone the git repository :  https://github.com/jay1791994/RecruitersApp.git

2)  Ii will create a folder named "RecruitersApp" where the repo in cloned.

    FOR STARTING USER INTERFACE

3)  open the cmd/terminal and change the directory to "../RecruitersApp".
    There should be two folder under this folder : 1) RecruitersAppUI(FrontEnd)   2) UserApp(Backend)
4)  change directory to RecruitersApp.

5)  Run command :        npm install

6)  On successfull installation, Run command:     npm start
    on successfull startup, front end will be available on "localhost:4200".
    
    
    START SERVER
    
    
7) Install MongoDB to your machine and start mongo server.
   link :  https://docs.mongodb.com/manual/installation/
   
8) Install MAVEN AND JAVA 8 TO YOUR MACHINE IF IT IS NOT THERE. 
   link: https://maven.apache.org/install.html
   
   link:https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html
   
9) Upon Successfull intallation of maven and java 8,

   -->  change directory to "../RecruiterApps/UserApp" in terminal/cmd.
   
   -->  run command:   mvn spring-boot:run
      
         It will start spring boot application on port number 8080 to serve the application which will make connection with mongodb server itself, provided
         mongodb server is running on port 27017.
         
         
   
 

# MessageBoard
 This is my demo web application. It's a simple message board which provide users authentication and registration and also internatialization.
 
Used frameworks: **Spring MVC**, **Spring Security**

Requirements:

* `Maven`

* `MySql server`

* `Tomcat`

### How to install:

1. Configure your database connection: 
    
    username = **root**

    password = **root**
    
	port = **3306**
	
2. On your MySql server create database with name **messageboard**

3. Initialize database with required tables and test data (use file **init.sql** in the root directory of project)

4. Go to the root directory of the project and open command line. From command line run following command: **mvn clean install** . This should create war file with name **MessageBoard.war** in the '/target' directory

5. Copy war file from 'target' directory to 'webapps' directory of your Tomcat server. 

6. Start Tomcat

### How to use:
Application will be avaliable at http://localhost:8080/MessageBoard

**Avaliable users**: 

Administrator privileges:

login: **admin**

password: **password** 

User privileges:

login: **Alex**

password: **password**

You can also register another user with user privileges.



	


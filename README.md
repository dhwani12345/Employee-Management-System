# Employee-Management-System
Create a basic employee management system to have a handson experience with jsp, servlets, JDBC, postgresql



<!-- TABLE OF CONTENTS -->
## Table of Contents

* About the Project
  * Built With
* Getting Started
  * Prerequisites
  * Installation
* Contact
* Acknowledgements



<!-- ABOUT THE PROJECT -->
## About The Project
This project showcases basic handson with the use of jsp, servlets, JDBC, sql and java OOP concepts. The end goal being to create an employee management system where the user takes data from the following tables with attributes as listed :
1. tblpersonalmaster
 - id (primary key)
 - firstname
 - lastname
 - birthdate
 - gender

2. tblqualificationmaster
 - id (primary key)
 - qualification

3. tblemployeemaster
  - id (primary key)
  - personal_id (foreign key on id from tblpersonalmaster)
  - qualification_id (foreign key on id from tblqualificationmaster)
  - salary
  - is_fresheremployee
  - joiningdate
  
User click on submit button,check validation and insert data into tblEmployeeMaster and
tblPersonalMaster.And last inserted record is displayed in EmployeeList.

### Built With
* Eclipse 2019-03 (4.11.0)
* JDK 1.8
* Tomcat version 9.0
* PgAdmin4 v4.11

<!-- GETTING STARTED -->
## Getting Started
The following is the list of files with functionality of each file

1. web.xml
 - This file is located in the WEB-INF directory of your Web application. The first entry, under the root servlet element in web.xml, defines a name for the servlet and specifies the compiled class that executes the servlet. 
 
2. employee.jsp
 - This file contains the front end layout of the screen with all the text fiels, radio buttons and submit option 
 
3. edit.jsp
 - Similar to employee.jsp but displays front end to edit last inserted record on clicking edit button 
 
 4. MyProvider.java
  - This is an interface file providing information (i.e. url,username,password) for database connectivity with postgresql
  
 5. MyConnectionProvider.java
  - Java class implementing MyProvider interface for JDBC connectivity
  
 6. Employee.java
  - This file contains all the getter and setter methods for retrieving employee information
  
 7. EmployeeDAO.java 
  - This is a java interface file defining functions insertemployee, getemployee and updateemployee
  
 8. EmployeeDAOImplementation.java
  - Java file implementing functions defined in EmployeeDAO interface.
  
 9. RegisterEmployeeInfo.java
  - Servlet file containing doPost and doGet methods

<!-- CONTACT -->
## Contact

Dhwani Mehta - dhwanidm1996@gmail.com - [LinkedIn](https://www.linkedin.com/in/dhwani-mehta-b1a6a9129/)

Project Link: [Link](https://github.com/dhwani12345/Employee-Management-System)


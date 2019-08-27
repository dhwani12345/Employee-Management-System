# Employee-Management-System
Create a basic employee management system to have a handson experience with jsp, servlets, JDBC, postgresql



<!-- TABLE OF CONTENTS -->
## Table of Contents

* About the Project
  * Built With
* Getting Started
  * Prerequisites
  * Installation
* Usage
* Roadmap
* Contributing
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


<!-- ROADMAP -->
## Roadmap

See the [open issues](https://github.com/othneildrew/Best-README-Template/issues) for a list of proposed features (and known issues).



<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.


<!-- CONTACT -->
## Contact

Your Name - [@your_twitter](https://twitter.com/your_username) - email@example.com

Project Link: [https://github.com/your_username/repo_name](https://github.com/your_username/repo_name)


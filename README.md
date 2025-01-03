**Library Management System - Spring MVC Project**

This project is a Library Management System developed using Spring MVC, Spring JDBC, and MySQL. The system allows students and librarians to manage book borrowing and returning processes efficiently. It includes role-based access control, with separate functionalities for students and librarians.

**Features**

**Student Features**

    View available books.
    
    Request to borrow books.
    
    View borrowed books and their due dates.
    
    Request to return books.
    
    Logout functionality.

**Librarian Features**

  View all books in the library.
  
  Add new books to the library.
  
  Approve or deny book borrowing requests.
  
  Approve or deny book return requests.
  
  Logout functionality.

**  Technologies Used**

  Backend: Spring MVC, Spring JDBC
  
  Database: MySQL
  
  Frontend: JSP, JSTL, HTML, CSS
  
  Build Tool: Maven
  
  IDE: Eclipse

 ** Prerequisites**

  Java 8 or higher
  
  Apache Tomcat 9
  
  MySQL 8.0
  
  Maven 3.6+
  
  Eclipse IDE (or any preferred IDE)

**Database Setup**

  Create Database and Tables:
  
    Run the SQL commands provided in **sql/CreateTables.sql** to create the necessary tables.
  
  Insert Sample Data:
  
    Run the SQL commands in **sql/InsertData.sql** to insert sample data into the tables.
  
  Database Configuration:
  
    Update the **application.properties** file with your MySQL database credentials:
  
    spring.datasource.url=jdbc:mysql://localhost:3306/library_db
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

**Project Setup**

  1. Clone the Repository
  
    git clone https://github.com/trupti-patil23/library-management-SpringMvc.git
  
  2. Import the Project into Eclipse
  
    Open Eclipse and select File > Import > Maven > Existing Maven Projects.
    
    Browse to the location where you cloned the repository and select the project.
    
    Click Finish.
  
  3. Build the Project
  
    Right-click on the project in Eclipse and select Run As > Maven Install to download dependencies and build the project.
  
  4. Deploy on Tomcat Server
  
    Right-click the project and select Run As > Run on Server.
  
    Choose Apache Tomcat server and click Finish.
  
  5. Access the Application
  
    Open your web browser and go to http://localhost:8080/library-management/.
  
    Usage Instructions
  
    Student Login
  
      Use the sample student credentials from the InsertData.sql file to log in.
      
      After logging in, you can view available books, borrow books, and view borrowed books.
  
    Librarian Login
  
      Use the sample librarian credentials from the InsertData.sql file to log in.
      
      After logging in, you can manage books and approve/deny requests from students.

**Directory Structure**
      library-management-SpringMvc/
      
      ├── src/
      │   ├── main/
      │   │   ├── java/
      │   │   │   └── com.library.management/
      │   │   │       ├── config/            # Spring configuration classes
      │   │   │       ├── controller/        # Controllers for handling requests
      │   │   │       ├── exception/         # Custom exception handling
      │   │   │       ├── model/             # Model classes for entities
      │   │   │       ├── repository/        # Repository interfaces for database interaction
      │   │   │       └── service/           # Service layer for business logic
      │   │   └── resources/
      │   │       └── application.properties # Database configuration
      │   └── webapp/
      │       ├── WEB-INF/
      │       │   ├── web.xml                # Web application deployment descriptor
      │       │   ├── dispatcher-servlet.xml # Spring Dispatcher Servlet configuration
      │       │   └── views/                 # JSP files go here
      │       └── static/
      │           └── css/                   # CSS files for styling
      └── sql/
          ├── CreateTables.sql               # SQL script for creating tables
          └── InsertData.sql                 # SQL script for inserting sample data


SWYNEX Final Java Project

Project Overview

A Student Management System developed using Java, MySQL, and JDBC as part of the SWYNEX internship.

Features

- Add student records
- View all student records
- Update student marks
- Delete student records
- Input validation for student ID and marks
- Database error handling

OOP Concepts

- Encapsulation: Private fields with getter and setter methods
- Inheritance: Student extends Person
- Abstraction: Person is an abstract class
- Polymorphism: Student overrides displayDetails()

Technologies Used

- Java
- MySQL
- JDBC
- Visual Studio Code

Database Setup

Create a database named "student_db" and a table named "students" with these columns:

- "id" — INT, Primary Key
- "name" — VARCHAR(100), Not Null
- "marks" — DOUBLE, Not Null

Run the Project

1. Install Java and MySQL.
2. Place the MySQL Connector/J JAR file in the "lib" folder.
3. Set the "DB_PASSWORD" environment variable to your MySQL password.
4. Compile the Java files:
   "javac -cp ".;lib/*" *.java"
5. Run the application:
   "java -cp ".;lib/*" Main"

Learning Outcomes

This project demonstrates object-oriented programming, database connectivity, CRUD operations, input validation, and exception handling.

#SWYNEX #Internship #Java #MySQL #JDBC
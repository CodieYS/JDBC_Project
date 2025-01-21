JDBC Student Management System

This project is a Student Management System implemented using Java Database Connectivity (JDBC). It provides functionalities to create, manage, and manipulate student records in a MySQL database. The project is designed to demonstrate various aspects of database operations, exception handling, and batch processing in Java.

Features

Create a Student Table

Automatically creates a student table in the database if it does not already exist.

Insert Records

Add individual or multiple student records to the database.

View Records

Retrieve and display all student records.

Fetch records by a specific student ID.

Update Records

Update specific fields (e.g., name, course) of a student record.

Delete Records

Remove a student record from the database by ID.

Upload Files

Upload images or other binary files and associate them with a student record.

Exception Handling

Comprehensive exception handling using a custom ErrorHandle class to manage SQL exceptions gracefully.

Technologies Used

Java: Core programming language.

JDBC: To interact with the database.

MySQL: Backend database to store student records.

Maven: For dependency management.

Prerequisites

Java Development Kit (JDK) 8 or higher.

MySQL Database with user credentials.

Maven for building and running the project.

IDE (e.g., IntelliJ IDEA, Eclipse) for project development.

Setup Instructions

Clone this repository:

git clone https://github.com/your-repo/jdbc-student-management.git

Import the project into your IDE.

Set up the database:

Create a MySQL database named student_management.

Update the connection details in the JdbcConnec class:

private final String url = "jdbc:mysql://localhost:3306/student_management";
private final String user = "your_username";
private final String password = "your_password";

Run the project:

Execute the Main class to interact with the application.

Class Structure

1. JdbcConnec

Handles the connection to the MySQL database using DriverManager.

Implements singleton design pattern to ensure a single database connection.

2. StudentUtil

Provides utility methods for various database operations, including:

createStudentTable()

saveRecord(Student st)

deleteById(int id)

showAllRecById(int selectID)

saveMulRec(List<Student> ls)

uplodPic(File file, int id)

3. ErrorHandle

A custom class for handling SQL exceptions.

Includes methods like:

handleSQLException(SQLException e)

Wrappers for utility methods to handle exceptions.

4. Student

Model class representing a student entity with fields:

id

name

age

course

# JDBC Student Management Syste

This project is a **Student Management System** implemented using **Java Database Connectivity (JDBC)**. It provides functionalities to create, manage, and manipulate student records in a MySQL database. The project is designed to demonstrate various aspects of database operations, exception handling, and batch processing in Java.

## Features

1. **Create a Student Table**
   - Automatically creates a `student` table in the database if it does not already exist.

2. **Insert Records**
   - Add individual or multiple student records to the database.

3. **View Records**
   - Retrieve and display all student records.
   - Fetch records by a specific student ID.

4. **Update Records**
   - Update specific fields (e.g., name, course) of a student record.

5. **Delete Records**
   - Remove a student record from the database by ID.

6. **Upload Files**
   - Upload images or other binary files and associate them with a student record.

7. **Exception Handling**
   - Comprehensive exception handling using a custom `ErrorHandle` class to manage SQL exceptions gracefully.

## Technologies Used

- **Java**: Core programming language.
- **JDBC**: To interact with the database.
- **MySQL**: Backend database to store student records.
- **Maven**: For dependency management.

## Prerequisites

1. **Java Development Kit (JDK)** 8 or higher.
2. **MySQL Database** with user credentials.
3. **Maven** for building and running the project.
4. **IDE** (e.g., IntelliJ IDEA, Eclipse) for project development.

## Setup Instructions

1. Clone this repository:
   ```bash
   git clone https://github.com/your-repo/jdbc-student-management.git
   ```

2. Import the project into your IDE.

3. Set up the database:
   - Create a MySQL database named `student_management`.
   - Update the connection details in the `JdbcConnec` class:
     ```java
     private final String url = "jdbc:mysql://localhost:3306/student_management";
     private final String user = "your_username";
     private final String password = "your_password";
     ```

4. Run the project:
   - Execute the `Main` class to interact with the application.

## Class Structure

### 1. **JdbcConnec**
- Handles the connection to the MySQL database using `DriverManager`.
- Implements singleton design pattern to ensure a single database connection.

### 2. **StudentUtil**
- Provides utility methods for various database operations, including:
  - `createStudentTable()`
  - `saveRecord(Student st)`
  - `deleteById(int id)`
  - `showAllRecById(int selectID)`
  - `saveMulRec(List<Student> ls)`
  - `uplodPic(File file, int id)`

### 3. **ErrorHandle**
- A custom class for handling SQL exceptions.
- Includes methods like:
  - `handleSQLException(SQLException e)`
  - Wrappers for utility methods to handle exceptions.

### 4. **Student**
- Model class representing a student entity with fields:
  - `id`
  - `name`
  - `age`
  - `course`

## Database Schema

```sql
CREATE TABLE IF NOT EXISTS student (
    Stu_id INT AUTO_INCREMENT PRIMARY KEY,
    Stu_Name VARCHAR(20) NOT NULL,
    Stu_Course VARCHAR(15),
    Stu_Age TINYINT,
    image BLOB
);
```

## Future Enhancements

- Add a GUI interface using JavaFX or Swing.
- Implement user authentication for secure access.
- Add advanced search and filtering options.
- Improve file handling capabilities for large files.

## License

This project is open-source and available under the [MIT License](LICENSE).

---


# Student Management System

A simple Java application for managing student records using JDBC for database operations.

## Features
- Add new students
- Update existing student information
- Display all students
- Delete students

## Technologies Used
- Java
- JDBC
- MySQL

## Setup
1. Ensure you have Java and MySQL installed on your system.

2. Create a MySQL database named studentmanagementapp.

3. Update the database connection details in Connectionp.java if necessary.

4. Compile and run the Start.java file to launch the application.

## Usage
When you run the application, you'll be presented with a menu:

```java
1. Add Student
2. Update Student
3. Display Student
4. Delete Student
5. Exit
```
Choose the appropriate option to perform the desired operation.

## Project Structure
- ```Start.java```: Main class with the user interface
- ```Student.java```: Student model class
- ```Studentdao.java```: Data Access Object for database operations
- ```Connectionp.java```: Database connection provider


## License

[MIT](https://choosealicense.com/licenses/mit/)

package com.studentcrud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.Studentdao;

public class Start {

	public static void main(String[] args) throws IOException {

		System.out.println("Welcome to Student Management App");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("1. Add Student");
			System.out.println("2. Update Student");
			System.out.println("3. Display Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Exit");
			int c = Integer.parseInt(br.readLine());

			switch (c) {
			case 1:
				// addStudent();
				System.out.println("Enter student name : ");
				String name = br.readLine();

				System.out.println("Enter student phone: ");
				String phone = br.readLine();

				System.out.println("Enter city : ");
				String city = br.readLine();

				// create student object to store student
				Student student = new Student(name, phone, city);
				boolean answer = Studentdao.insertStudent(student);
				if (answer) {
					System.out.println("Student added successfully...");
				} else {
					System.out.println("Failed to add!!!");
				}
				System.out.println(student);

				break;

			case 2:
				// updateStudent();
				System.out.print("Enter student ID to update: ");
				int id = Integer.parseInt(br.readLine());

				System.out.print("Enter new name : ");
				String newName = br.readLine();

				System.out.print("Enter new phone : ");
				String newPhone = br.readLine();

				System.out.print("Enter new city : ");
				String newCity = br.readLine();

				Student updateStudent = new Student(id, newName, newPhone, newCity);

				boolean result = Studentdao.updateStudent(updateStudent);
				if (result) {
					System.out.println("Student updated successfully...");
				} else {
					System.out.println("Failed to update student!");
				}
				break;
				
				
			case 3:
				// displayStudents();
				Studentdao.displayStudents();
				break;

			case 4:
				// deleteStudent();
				System.out.println("Enter Student id to delete : ");
				int userId = Integer.parseInt(br.readLine());
				boolean f = Studentdao.deleteStudent(userId);
				if (f) {
					System.out.println("Student deleted...");
				} else {
					System.out.println("Failed to delete!!!!");
				}
				break;

			case 5:
				System.out.println("Thank for using Student Management App");
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}

		}
	}

}

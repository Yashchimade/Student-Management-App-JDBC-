package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Studentdao {

	public static boolean insertStudent(Student student) {
		boolean flag = false;
		try (Connection con = Connectionp.createC();
				PreparedStatement pstmt = con
						.prepareStatement("INSERT INTO students(name, phone, city) VALUES(?, ?, ?)")) {

			pstmt.setString(1, student.getStudentName());
			pstmt.setString(2, student.getStudentPhone());
			pstmt.setString(3, student.getStudentCity());

			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean updateStudent(Student student) {
		boolean flag = false;
		try (Connection con = Connectionp.createC();
				PreparedStatement pstmt = con
						.prepareStatement("UPDATE students SET name = ?, phone = ?, city = ? WHERE id = ?")) {

			pstmt.setString(1, student.getStudentName());
			pstmt.setString(2, student.getStudentPhone());
			pstmt.setString(3, student.getStudentCity());
			pstmt.setInt(4, student.getStudentId());

			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean deleteStudent(int userId) {
		boolean flag = false;
		try (Connection con = Connectionp.createC();
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM students WHERE id = ?")) {

			pstmt.setInt(1, userId);

			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void displayStudents() {
		try (Connection con = Connectionp.createC();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String city = rs.getString("city");

				System.out.println("Id : " + id);
				System.out.println("Name : " + name);
				System.out.println("Phone : " + phone);
				System.out.println("City : " + city);
				System.out.println("--------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

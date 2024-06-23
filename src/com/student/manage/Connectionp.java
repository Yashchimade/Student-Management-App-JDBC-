package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connectionp {
	
	static Connection con;
	
	public static Connection createC() {
		
		try {
			
			//load the driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//create the connection
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagementapp", "username", "password");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return con;
	}

}

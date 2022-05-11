package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Connector{
	public final static String DATA_BASE = "trung_tam_ngoai_ngu", USER = "root", PASS = "";
	
	public static Connection connect () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DATA_BASE, USER, PASS); 
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
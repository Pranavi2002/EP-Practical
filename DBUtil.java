package com.klu.DB;
import java.lang.ClassNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	final static String forNameURL = "com.mysql.jdbc.Driver";
	final static String dBURL = "jdbc:mysql:thin:@localhost:3306:EP";
	final static String username = "root";
	final static String password = "root";
	public static Connection DBConnection() throws ClassNotFoundException, SQLException{
		Class.forName(forNameURL);
		Connection con = DriverManager.getConnection(dBURL,username,password);
		return con;
	}
}

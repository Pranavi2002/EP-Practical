package com.klu.Insertion;
import java.lang.ClassNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.klu.DB.DBUtil;
import com.klu.Student.StudentBean;

public class StudentInsertion {
	public int StudentInsert(StudentBean student) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.DBConnection();
		PreparedStatement stmt=con.prepareStatement("insert into StudentDetails values(sb.getRegno,sb.getName,sb.getEmail)");
		int i = stmt.executeUpdate(); 
		return i;
	}
}

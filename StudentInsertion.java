package com.klu.Insertion;
import java.lang.ClassNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.klu.DB.DBUtil;
import com.klu.Student.StudentBean;

public class StudentInsertion {
	public int StudentInsert(StudentBean student) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.DBConnection();
		PreparedStatement stmt1=con.prepareStatement("insert into StudentDetails values(?,?,?)");
		stmt1.setInt(1,student.getRegno());
		stmt1.setString(2,student.getName());
		stmt1.setString(3,student.getEmail());
		int i = stmt1.executeUpdate(); 
		return i;
	}
	public int StudentDelete(int reg) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.DBConnection();
		PreparedStatement stmt2=con.prepareStatement("delete from StudentDetails where regno=?");
		stmt2.setInt(1,reg);
		int j = stmt2.executeUpdate(); 
		return j;
	}
// 	public int StudentUpdate(int reg1) throws ClassNotFoundException, SQLException {
// 		Connection con = DBUtil.DBConnection();
// 	        PreparedStatement stmt3=con.prepareStatement("update StudentDetails set name='Sai Pranavi'  where regno=?");
// 		stmt3.setInt(1,reg1);
// 		int k = stmt3.executeUpdate(); 
// 		return k;
// 	}
	public int StudentUpdate(String name,int reg1) throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.DBConnection();
		// PreparedStatement stmt3=con.prepareStatement("update StudentDetails set name='Sai Pranavi'  where regno=?");
		PreparedStatement stmt3=con.prepareStatement("update StudentDetails set name=?  where regno=?");
		stmt3.setString(1,name);
		stmt3.setInt(2,reg1);
		int k = stmt3.executeUpdate(); 
		return k;
	}
	public void StudentDisplay() throws ClassNotFoundException, SQLException {
		Connection con = DBUtil.DBConnection();
//		PreparedStatement stmt4=con.prepareStatement("select * from StudentDetails");
//		int l = stmt4.executeUpdate();
		PreparedStatement stmt4=con.prepareStatement("select * from StudentDetails");  
		ResultSet rs=stmt4.executeQuery();  
		while(rs.next()){  
			System.out.println(rs.getInt(1)+" "+rs.getString(2)); 
	}
}
}

package com.klu.MainPackage;
import java.lang.ClassNotFoundException;
import java.sql.SQLException;
import com.klu.Insertion.StudentInsertion;
import com.klu.Student.StudentBean;

public class Student {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		StudentBean sb = new StudentBean();
		sb.setRegno(190030801);
		sb.setName("Pranavi");
		sb.setEmail("kolipakavnssaipranavi@gmail.com");
		StudentInsertion si = new StudentInsertion();
		int i = si.StudentInsert(sb);
		if(i>0) {
			System.out.println("Insertion Successful");
		}
		else {
			System.out.println("Insertion Failed");
		}
	}
}

package com.klu.MainPackage;
import java.lang.ClassNotFoundException;
import java.sql.SQLException;
import com.klu.Insertion.StudentInsertion;
import com.klu.Student.StudentBean;
import java.util.*;
public class Student {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		 Scanner sc = new Scanner(System.in);
		 int ch;
		 ch = sc.nextInt();
		StudentBean sb = new StudentBean();
		switch(ch) {
		case 1 : 
			sb.setRegno(sc.nextInt());
			sb.setName(sc.next());
			sb.setEmail(sc.next());	
		StudentInsertion si = new StudentInsertion();
		int i = si.StudentInsert(sb);
		if(i>0) {
			System.out.println("Insertion Successful");
		}
		else {
			System.out.println("Insertion Failed");
		}
		case 2 : 
			int reg = sc.nextInt();
			StudentInsertion sd = new StudentInsertion();
			int j = sd.StudentDelete(reg);
			if(j>0) {
				System.out.println("Deletion Successful");
			}
			else {
				System.out.println("Deletion Failed");
		}
		case 3 : 
			int reg1 = sc.nextInt();	
			StudentInsertion su = new StudentInsertion();
			int k = su.StudentUpdate(reg1);
			if(k>0) {
				System.out.println("Updation Successful");
			}
			else {
				System.out.println("Updation Failed");
			}
		case 4 : 
			StudentInsertion sdis = new StudentInsertion();
			sdis.StudentDisplay();
		}
	}
	}



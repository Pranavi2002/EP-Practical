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
			System.out.println("Enter the registration number : ");
			sb.setRegno(sc.nextInt());
			System.out.println("Enter the name : ");
			sb.setName(sc.next());
			System.out.println("Enter the email : ");
			sb.setEmail(sc.next());	
		StudentInsertion si = new StudentInsertion();
		int i = si.StudentInsert(sb);
		if(i>0) {
			System.out.println("Insertion Successful");
		}
		else {
			System.out.println("Insertion Failed");
		}
		break;
		case 2 : 
			System.out.println("Enter the registration to delete : ");
			int reg = sc.nextInt();
			StudentInsertion sd = new StudentInsertion();
			int j = sd.StudentDelete(reg);
			if(j>0) {
				System.out.println("Deletion Successful");
			}
			else {
				System.out.println("Deletion Failed");
		}
			break;
//		case 3 :
//			int reg1 = sc.nextInt();	
//			StudentInsertion su = new StudentInsertion();
//			int k = su.StudentUpdate(reg1);
//			if(k>0) {
//				System.out.println("Updation Successful");
//			}
//			else {
//				System.out.println("Updation Failed");
//			}
		case 3 :
			 System.out.println("Enter id to make changes with..");
			int reg1 = sc.nextInt();
			System.out.println("Enter name to update..");
			String name = sc.next();
			System.out.println("Enter email to update..");
			String email = sc.next();	
			StudentInsertion su = new StudentInsertion();
			int k = su.StudentUpdate(reg1,name,email);
			if(k>0) {
				System.out.println("Updation Successful");
			}
			else {
				System.out.println("Updation Failed");
			}
			break;
		case 4 : 
			StudentInsertion sdis = new StudentInsertion();
			sdis.StudentDisplay();
			break;
		case 5 :
			System.exit(0);
		default : 
			System.out.println("Enter a valid no : ");
		}
	}
	}


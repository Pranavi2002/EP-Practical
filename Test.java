package com.klu.HQLHCQL_Practical9.HQLHCQL_Practical9;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
// 		create
//		Employee employee=new Employee();
//		employee.setEmpName("Pranavi");
//		employee.setEmpSalary("1300000");
//		employee.setEmpAddress("Khammam");
//		Employee employee2=new Employee();
//		employee2.setEmpName("Abhiram");
//		employee2.setEmpSalary("1250000");
//		employee2.setEmpAddress("Warangal");
//		session.save(employee);
//		session.save(employee2);
//		System.out.println("Inserted SuccessFully");
//		retrieve by id
//		Employee employee = (Employee) session.get(Employee.class,1);
//		System.out.println(employee.getEmpName());
//		System.out.println(employee.getEmpSalary());
//		System.out.println(employee.getEmpAddress());
//		UpdateQuery update = new UpdateQuery();
//		update.update();
//		RetrieveQuery.retrieve();
//		DeleteQuery.delete();
		CriteriaQuery criteria = new CriteriaQuery();
		criteria.criteria();
		transaction.commit();
		session.close();

	}

}

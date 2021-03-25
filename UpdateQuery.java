package com.klu.HQLHCQL_Practical9.HQLHCQL_Practical9;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class UpdateQuery {
public  void update()
{
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sf=cfg.buildSessionFactory();
Session session=sf.openSession();
Transaction transaction=session.beginTransaction();
Query query=session.createQuery("update Employee set empName=:n where empId=:i");
query.setParameter("n", "Ram");
query.setParameter("i", 2);
int status=query.executeUpdate();
System.out.println(status);
transaction.commit();
session.close();
System.out.println("Updated Successfully !!");
}
}

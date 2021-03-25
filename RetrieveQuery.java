package com.klu.HQLHCQL_Practical9.HQLHCQL_Practical9;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class RetrieveQuery {
public static void retrieve()
{
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sf=cfg.buildSessionFactory();
Session session=sf.openSession();
Transaction transaction=session.beginTransaction();
Query query=session.createQuery("from Employee");
List list=query.list();
Iterator itr=list.iterator();
while(itr.hasNext())
{
Employee employee=(Employee)itr.next();
System.out.println(employee.getEmpId()+""+employee.getEmpName()+""+employee.getEmpSalary()+""+employee.getEmpAddress());
}
}
}
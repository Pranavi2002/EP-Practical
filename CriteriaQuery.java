package com.klu.HQLHCQL_Practical9.HQLHCQL_Practical9;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class CriteriaQuery {
public void criteria()
{
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sf=cfg.buildSessionFactory();
Session session=sf.openSession();
Transaction transaction=session.beginTransaction();
Criteria criteria=session.createCriteria(Employee.class);
List<Employee> list=criteria.list();
Iterator itr=list.iterator();
while(itr.hasNext())
{
Employee employee=(Employee)itr.next();
System.out.println(employee.getEmpId()+""+employee.getEmpName()+""+employee.getEmpSalary()+""+employee.getEmpAddress());
}
}
}

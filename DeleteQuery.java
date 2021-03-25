package com.klu.HQLHCQL_Practical9.HQLHCQL_Practical9;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class DeleteQuery {
public static void delete()
{
Configuration cfg=new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sf=cfg.buildSessionFactory();
Session session=sf.openSession();
Transaction transaction=session.beginTransaction();
Query query=session.createQuery("delete from Employee where id=1");
query.executeUpdate();
transaction.commit();
session.close();
System.out.println("Deleted a Record Successfully");
}
}

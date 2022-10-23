package DAO;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entitys.Orderdetails;
import Entitys.Orders;
import Utils.HibernateUtil;

public class Test {
	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	
	public static void main(String[] args) throws IOException {
		
		
		Orders hoadon = new Orders();
		hoadon.setIdEmployee(32);
		hoadon.setIdCustommer(15);
		hoadon.setTotal(50);
		hoadon.setDate("22/10/2022");
		
		Orderdetails chitiet1 = new Orderdetails();
		chitiet1.setIdorders(hoadon);
		chitiet1.setIdProduct(16);
		chitiet1.setNameProduct("chi tiet 1");
		chitiet1.setPrice(10);
		chitiet1.setQuatity(20);
		
		Orderdetails chitiet2 = new Orderdetails();
		chitiet2.setIdorders(hoadon);
		chitiet2.setIdProduct(16);
		chitiet2.setNameProduct("chi tiet 2");
		chitiet2.setPrice(100);
		chitiet2.setQuatity(200);
				 
		 Session session  = factory.openSession();
		 Transaction transaction  = session.beginTransaction();
		 session.save(hoadon);
		 session.save(chitiet1);
		 session.save(chitiet2);
		 transaction.commit();
		 System.out.println("--------- after insert -------------");
		 System.out.println(hoadon);
		 System.out.println(chitiet1);
		 System.out.println(chitiet2);
		 	
	}
}

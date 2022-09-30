package quanlybanraucuqua.pojos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import quanlybanraucuqua.Utils.HibernateUtil;

public class Test {
	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	
	public static void main(String[] args) {
		Session session =  factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		User user = new User();
		user.setUsername("hello1111");
		user.setPassword("hihi");
		
		session.save(user);
		transaction.commit();
		
		System.out.println(user.getUsername());
		
	}
}

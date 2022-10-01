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
		
		Users user = new Users();
		user.setName("Nguyễn Hoàng Hải");
		user.setPhone("0123456951");
		user.setAddress("Hồ Hoàng Kiếm - Đống Đa - Hà Nội");
		user.setRole(1);
		
		session.save(user);
		transaction.commit();
		session.close();
		
	}
}

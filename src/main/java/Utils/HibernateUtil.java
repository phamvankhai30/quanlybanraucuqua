package Utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory getSessionFactory() {

		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");

			return configuration.buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Lỗi Hibernate chưa connect" + e);
		}

		return null;

	}
}
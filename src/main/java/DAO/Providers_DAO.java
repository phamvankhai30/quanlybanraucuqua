package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entitys.Providers;
import Utils.HibernateUtil;

public class Providers_DAO {
	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;

	public void addProvider(Providers provider) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(provider);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.clear();
			session.close();
		}
	}

	public void updateProvider(Providers provider) {

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.update(provider);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.clear();
			session.close();
		}
	}

	public void deleteProviderById(int id) {

		try {
			session = factory.openSession();
			Providers provider = session.get(Providers.class, id);

			transaction = session.beginTransaction();
			session.delete(provider);
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.clear();
			session.close();
		}

	}

	public Providers getProviderById(int id) {
		Providers provider = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			provider = session.get(Providers.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.clear();
			session.close();
		}
		return provider;

	}

	@SuppressWarnings("unchecked")
	public List<Providers> getAllProvider() {

		List<Providers> providers = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			providers = session.createQuery("from Providers").list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.clear();
			session.close();
		}
		return providers;

	}

	

	public static void main(String[] args) {
//		Providers_DAO dao = new Providers_DAO();
//		Providers provider = new Providers(1,"khai","mot","hai");
//		Providers dd = dao.getProviderById(15);
//		System.out.print(dd.getAddress());
		
//		List<Providers> list = dao.getNamProvider();
//		for(Providers result : list) {
//			System.out.println(result.getName());
//		}
	}

}

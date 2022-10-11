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

		}
	}
	
	public void updateProvider(Providers provider) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			session.saveOrUpdate(provider);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}
	}
	
	public Providers deleteProvider(int id) {
		Providers provider = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			provider = session.get(Providers.class, id);
			session.remove(provider);

			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}
		return provider;
		
	}
	
	public Providers getProviderById(int id) {
		Providers provider = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			provider = session.get(Providers.class, id);
			//provider = session.load(Providers.class, id);
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}
		return provider;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Providers> getAllProvider() {
		List <Providers> providers = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			providers = session.createQuery("from Providers").list();

			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}
		return providers;

		
	}
	public static void main(String[] args) {
		Providers_DAO dao = new Providers_DAO();
		List<Providers> list_providers = dao.getAllProvider();
		
		for (Providers i : list_providers) {
			System.out.println(i);
			
		}
	}
	
	
}

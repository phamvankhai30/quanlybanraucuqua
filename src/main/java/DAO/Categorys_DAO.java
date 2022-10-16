package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import Entitys.Categorys;

import Utils.HibernateUtil;

public class Categorys_DAO {
	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	
	@SuppressWarnings("unchecked")
	public List<Categorys> getAllCategorys() {

		List <Categorys> category = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			category = session.createQuery("from Categorys").list();

			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return category;
		
	}

	public void addCategory(Categorys category ) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(category);
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
	}
	
	public void updateCategory(Categorys category) {

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(category);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
	}

	public void deleteCategoryById(int id) {	
		
		try {
			session = factory.openSession();
			Categorys category = session.get(Categorys.class, id);
			
			if(category != null) {
				transaction = session.beginTransaction();
				session.delete(category);
				transaction.commit();
			}else {
				System.out.println("Loại Sản Phẩm Không Tồn Tại !");
			}
			
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}finally {
			session.clear();
			session.close();
		}
		
	}
	public Categorys getCategoryById(int id) {
		Categorys category = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			category = session.get(Categorys.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return category;
		
	}
	public static void main(String[] args) {
		Categorys_DAO dao = new Categorys_DAO();
		
		System.out.println(dao.getCategoryById(1));
//		List<Categorys> data = dao.getAllCategorys();
//		for(Categorys list : data) {
//			System.out.println(list.getName());
//		}
	}
}

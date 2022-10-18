package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entitys.Products;
import Utils.HibernateUtil;

public class Products_DAO {
	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;


	public void addProduct(Products product) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(product);
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
	
	public void updateProduct(Products product) {

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(product);
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

	public void deleteProductById(int id) {	
		
		try {
			session = factory.openSession();
			Products product = session.get(Products.class, id);
			
			transaction = session.beginTransaction();
			session.delete(product);
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
	
	
	public Products getProductById(int id) {
		Products product = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			product = session.get(Products.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return product;
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Products> getAllProduct() {

		List <Products> product = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();		
			product = session.createQuery("from Products").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return product;
		
	}
	
	public double TongTien(double soluong, double giatien) {
		return soluong*giatien;
	}
}

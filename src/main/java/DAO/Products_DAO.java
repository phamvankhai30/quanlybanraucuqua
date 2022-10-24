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


	public Products addProduct(Products product) {
		Products products = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(product);
			products = product;
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return products;
	}
	
	public void updateProduct(Products product) {

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.update(product);
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

	@SuppressWarnings("unchecked")
	public List<Products> orderByProductIdDESC() {

		List <Products> product = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();		
			product = session.createQuery("from Products p ORDER BY p.idProduct DESC").list();
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
	public List<Products> orderByCategoryASC() {

		List <Products> product = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();		
			product = session.createQuery("from Products p ORDER BY p.idCategory ASC").list();
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
	public List<Products> orderByCategoryDESC() {

		List <Products> product = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();		
			product = session.createQuery("from Products p ORDER BY p.idCategory DESC").list();
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
	public List<Products> orderByQuatityASC() {

		List <Products> product = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();		
			product = session.createQuery("from Products p ORDER BY p.quatity ASC").list();
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
	public List<Products> orderByQuatityDESC() {

		List <Products> product = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();		
			product = session.createQuery("from Products p ORDER BY p.quatity DESC").list();
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
	public List<Products> orderByPriceASC() {

		List <Products> product = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();		
			product = session.createQuery("from Products p ORDER BY p.price ASC").list();
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
	public List<Products> orderByPriceDESC() {

		List <Products> product = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();		
			product = session.createQuery("from Products p ORDER BY p.price DESC").list();
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
	public List<Products> orderByNameProductAZ() {

		List <Products> product = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();		
			product = session.createQuery("from Products p ORDER BY p.name ASC").list();
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
	public List<Products> orderByNameProductZA() {

		List <Products> product = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();		
			product = session.createQuery("from Products p ORDER BY p.name DESC").list();
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
	public List<Products> orderByProviderASC() {

		List <Products> product = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();		
			product = session.createQuery("from Products p ORDER BY p.idProvider ASC").list();
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
	public List<Products> orderByProviderDESC() {

		List <Products> product = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();		
			product = session.createQuery("from Products p ORDER BY p.idProvider DESC").list();
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
}

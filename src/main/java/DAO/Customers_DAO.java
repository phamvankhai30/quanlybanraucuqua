package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Entitys.Users;
import Utils.HibernateUtil;

public class Customers_DAO {
	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;


	public void addCustomer(Users customer ) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(customer);
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
	
	public void updateCustomer(Users customer) {

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.update(customer);
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

	public void deleteCustomerById(int id) {	
		
		try {
			session = factory.openSession();
			Users customer = session.get(Users.class, id);
			
			if(customer != null) {
				transaction = session.beginTransaction();
				session.delete(customer);
				transaction.commit();
			}else {
				System.out.println("Khách hàng Không Tồn Tại !");
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
	
	
	@SuppressWarnings("unchecked")
	public List<Users> getAllCustomer() {

		List <Users> customer = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			customer = session.createQuery("from Users U where U.role = 1").list();

			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return customer;
		
	}
	@SuppressWarnings("unchecked")
	public List<Users> getCustomerById(int user_id){
		List <Users> customer = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM Users U WHERE U.idUser = :userid and U.role = 1";
			Query<Users> query = session.createQuery(hql);
			query.setParameter("userid",user_id);
			customer = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return customer;
	}
	public static void main(String[] args) {
		Customers_DAO dao = new Customers_DAO();
//		List<Users> list_users = dao.getAllCustomer();
		
//		for (Users i : list_users) {
//			System.out.println(i);
//			
//		}
		System.out.println(dao.getCustomerById(200));
	}
}

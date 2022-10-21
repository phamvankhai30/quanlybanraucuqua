package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Entitys.Orders;
import Utils.HibernateUtil;

public class Orders_DAO {
	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	
	public int addOrder(Orders order) {
		int id = 0;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(order);
			id = order.getIdOrder();
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return id;
	}
	
	public void deletOrderById(int id) {	
		
		try {
			session = factory.openSession();
			Orders orders = session.get(Orders.class, id);
			
			if(orders != null) {
				transaction = session.beginTransaction();
				session.delete(orders);
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
	public List<Orders> getAllOrder(){
		
		List <Orders> order = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();		
			order = session.createQuery("FROM Orders").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return order;
		
	}

	public Orders getOrderById(int id) {
		Orders orderById = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			orderById = session.get(Orders.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return orderById;
		
	}
}

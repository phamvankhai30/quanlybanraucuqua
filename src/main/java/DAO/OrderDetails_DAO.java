package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import Entitys.Orderdetails;
import Utils.HibernateUtil;

public class OrderDetails_DAO {
	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	
	public void addOrderDetail(Orderdetails orderDetail) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(orderDetail);
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

	@SuppressWarnings("unchecked")
	public List<Orderdetails> getOrderDetailById(int idHD) {

		List <Orderdetails> orderdetail = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			String hql = "from Orderdetails O where O.idorders.idOrder = :id_HD";
			Query<Orderdetails> query = session.createQuery(hql);
			query.setParameter("id_HD",idHD);
			orderdetail = query.list();

			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return orderdetail;
	}

	@SuppressWarnings("unchecked")
	public List<Orderdetails> getAllOrderDetail() {

		List <Orderdetails> orderdetails = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();		
			orderdetails = session.createQuery("from Orderdetails").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return orderdetails;
		
	}

	@SuppressWarnings("unchecked")
	public List<Orderdetails> getallOrder(){
		List <Orderdetails> order_details = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			String hql = "FROM Orderdetails odt INNER JOIN Orders od ON odt.idOrder = od.idOrder";
			Query<Orderdetails> query = session.createQuery(hql);
			order_details = query.list();
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return order_details;
	}
	public static void main(String[] args) {
		OrderDetails_DAO dao = new OrderDetails_DAO();
		//List<Orderdetails> list = dao.getAllOrderDetail();
		List<Orderdetails> list = dao.getOrderDetailById(24);
		for(Orderdetails o : list) {
			System.out.println(o.getIdorders().getIdOrder());
		}
	}
}

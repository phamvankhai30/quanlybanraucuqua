package DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entitys.Orderdetails;
import Utils.HibernateUtil;

public class Report_Sales_DAO {
	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;

	// Hoá đơn tăng dần
	@SuppressWarnings("unchecked")
	public List<Object[]> OrderByIdOrderASC() {
		List<Object[]> orderByIdOrderASC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM Orderdetails ord INNER JOIN Orders od ON ord.idorders.idOrder = od.idOrder";
			orderByIdOrderASC = (List<Object[]>) session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.clear();
			session.close();
		}
		return orderByIdOrderASC;
	}

	// Hoá đơn giảm dần
	@SuppressWarnings("unchecked")
	public List<Object[]> OrderByIdOrderDESC() {
		List<Object[]> orderByIdOrderDESC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM Orderdetails ord INNER JOIN Orders od ON ord.idorders.idOrder = od.idOrder ORDER BY od.idOrder DESC";
			orderByIdOrderDESC = (List<Object[]>) session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.clear();
			session.close();
		}
		return orderByIdOrderDESC;
	}

	// sắp xếp theo id nhân viên tăng dần
	@SuppressWarnings("unchecked")
	public List<Object[]> OrderByIdEmployeeASC() {
		List<Object[]> orderByIdEmployeeASC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM Orderdetails ord INNER JOIN Orders od ON ord.idorders.idOrder = od.idOrder ORDER BY ord.idorders.idEmployee ASC";
			orderByIdEmployeeASC = (List<Object[]>) session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.clear();
			session.close();
		}
		return orderByIdEmployeeASC;

	}

	// sắp xếp theo id nhân viên giảm dần
	@SuppressWarnings("unchecked")
	public List<Object[]> OrderByIdEmployeeDESC() {
		List<Object[]> orderByIdEmployeeDESC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM Orderdetails ord INNER JOIN Orders od ON ord.idorders.idOrder = od.idOrder ORDER BY ord.idorders.idEmployee DESC";
			orderByIdEmployeeDESC = (List<Object[]>) session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.clear();
			session.close();
		}
		return orderByIdEmployeeDESC;

	}

	// sắp xếp theo id sản phẩm giảm dần
	@SuppressWarnings("unchecked")
	public List<Object[]> OrderByIdProductDESC() {
		List<Object[]> orderByIdProductDESC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM Orderdetails ord INNER JOIN Orders od ON ord.idorders.idOrder = od.idOrder ORDER BY ord.idProduct DESC";
			orderByIdProductDESC = (List<Object[]>) session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.clear();
			session.close();
		}
		return orderByIdProductDESC;

	}

	// sắp xếp theo id sản phẩm tăng dần
	@SuppressWarnings("unchecked")
	public List<Object[]> OrderByIdProductASC() {
		List<Object[]> orderByIdProductASC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM Orderdetails ord INNER JOIN Orders od ON ord.idorders.idOrder = od.idOrder ORDER BY ord.idProduct ASC";
			orderByIdProductASC = (List<Object[]>) session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.clear();
			session.close();
		}
		return orderByIdProductASC;
	}

	// sắp xếp theo tiền tăng dần
	@SuppressWarnings("unchecked")
	public List<Object[]> OrderByPriceASC() {
		List<Object[]> orderByIdMonneyASC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM Orderdetails ord INNER JOIN Orders od ON ord.idorders.idOrder = od.idOrder ORDER BY ord.idorders.total ASC";
			orderByIdMonneyASC = (List<Object[]>) session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.clear();
			session.close();
		}
		return orderByIdMonneyASC;
	}

	// sắp xếp theo tiền giảm dần
	@SuppressWarnings("unchecked")
	public List<Object[]> OrderByPriceDESC() {
		List<Object[]> orderByIdMonneyDESC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM Orderdetails ord INNER JOIN Orders od ON ord.idorders.idOrder = od.idOrder ORDER BY ord.idorders.total DESC";
			orderByIdMonneyDESC = (List<Object[]>) session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.clear();
			session.close();
		}
		return orderByIdMonneyDESC;
	}

	public static void main(String[] args) {

		Report_Sales_DAO report_Sales_DAO = new Report_Sales_DAO();
		
		List<Object[]> list = report_Sales_DAO.OrderByIdEmployeeDESC();

		for(Object[] ob : list) {
			Orderdetails orderdetails1 = (Orderdetails) ob[0];
			System.out.println(orderdetails1.getIdorders().getIdEmployee());
		}

	}

}

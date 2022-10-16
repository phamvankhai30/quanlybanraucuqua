package DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Entitys.Users;
import Utils.HibernateUtil;

public class Employees_DAO {
	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;


	public void addEmployee(Users employee ) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(employee);
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
	
	public void updateEmployee(Users employee) {

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(employee);
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

	public void deleteEmployeeById(int id) {	
		
		try {
			session = factory.openSession();
			Users employee = session.get(Users.class, id);
			
			if(employee != null) {
				transaction = session.beginTransaction();
				session.delete(employee);
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
	public List<Users> getAllEmployee() {

		List <Users> employee = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			employee = session.createQuery("from Users U where U.role = 2").list();

			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return employee;
		
	}
	@SuppressWarnings("unchecked")
	public List<Users> searchEmployeeById(int user_id){
		List <Users> employee = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			String hql = "FROM Users U WHERE U.idUser = :user_id and U.role = 2";
			Query<Users> query = session.createQuery(hql);
			query.setParameter("user_id",user_id);
			employee = query.list();
			
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}
		return employee;
		
	}

}

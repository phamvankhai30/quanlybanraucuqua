package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Entitys.ImportBills;
import Utils.HibernateUtil;

public class ImportBills_DAO {
	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	
	public ImportBills addImportBill(ImportBills importBill) {
		ImportBills idImportBill = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(importBill);
			idImportBill = importBill;
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return idImportBill;
	}

	@SuppressWarnings("unchecked")
	public List<ImportBills> getAllImportBill(){
		List<ImportBills> importBill = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			importBill = session.createQuery("from ImportBills").list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		}finally {
			session.clear();
			session.close();
		}
		return importBill;
	}

	public void deleteImportBill(int id) {
		try {
			session = factory.openSession();
			ImportBills importBills = session.get(ImportBills.class, id);
			
			if(importBills != null) {
				transaction = session.beginTransaction();
				session.delete(importBills);
				transaction.commit();
			}else {
				System.out.println("Hoá Đơn Không Tồn Tại !");
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

	public ImportBills searchImportBillById(int id) {
		ImportBills importBills = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			importBills = session.get(ImportBills.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return importBills;
	}
}

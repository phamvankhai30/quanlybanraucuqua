package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import Entitys.ImportBillDetails;
import Utils.HibernateUtil;

public class ImportBillDetails_DAO  {
	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	
	public void addImportBillDetail(ImportBillDetails billDetails) {
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(billDetails);
			
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
	public List<ImportBillDetails> getImportBillDetail(int id) {

		List<ImportBillDetails> billDetails = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			String hql = "FROM ImportBillDetails impbdt WHERE impbdt.IDimportBill.idImport = :idImport";
			Query<ImportBillDetails> query = session.createQuery(hql);
			query.setParameter("idImport",id);
			billDetails = query.list();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

		}finally {
			session.clear();
			session.close();
		}
		return billDetails;
		
	}
	


}

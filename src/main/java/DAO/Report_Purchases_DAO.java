package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Entitys.ImportBills;
import Utils.HibernateUtil;

public class Report_Purchases_DAO {
	static final SessionFactory factory = HibernateUtil.getSessionFactory();
	Session session = null;
	Transaction transaction = null;
	
	@SuppressWarnings("unchecked")
	public List<ImportBills> ImportBillOrderByIdASC() {
		List<ImportBills> importBillByIdASC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM ImportBills";
			importBillByIdASC = session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.clear();
			session.close();
		}
		return importBillByIdASC;
	}

	@SuppressWarnings("unchecked")
	public List<ImportBills> ImportBillOrderByIdDESC() {
		List<ImportBills> importBillByIdDESC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM ImportBills im ORDER BY im.idImport DESC";
			importBillByIdDESC = session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.clear();
			session.close();
		}
		return importBillByIdDESC;
	}
	
	@SuppressWarnings("unchecked")
	public List<ImportBills> ImportBillOrderByIdProductASC() {
		List<ImportBills> importBillByIdProductASC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM ImportBills im ORDER BY im.productID.idProduct ASC";
			importBillByIdProductASC = session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.clear();
			session.close();
		}
		return importBillByIdProductASC;
	}
	
	@SuppressWarnings("unchecked")
	public List<ImportBills> ImportBillOrderByIdProductDESC() {
		List<ImportBills> importBillByIdProductDESC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM ImportBills im ORDER BY im.productID.idProduct DESC";
			importBillByIdProductDESC = session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.clear();
			session.close();
		}
		return importBillByIdProductDESC;
	}
	
	@SuppressWarnings("unchecked")
	public List<ImportBills> ImportBillOrderByIdCategoryASC() {
		List<ImportBills> importBillByIdCategoryASC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM ImportBills im ORDER BY im.idCategory ASC";
			importBillByIdCategoryASC = session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.clear();
			session.close();
		}
		return importBillByIdCategoryASC;
	}
	
	@SuppressWarnings("unchecked")
	public List<ImportBills> ImportBillOrderByIdCategoryDESC() {
		List<ImportBills> importBillByIdCategoryDESC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM ImportBills im ORDER BY im.idCategory DESC";
			importBillByIdCategoryDESC = session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.clear();
			session.close();
		}
		return importBillByIdCategoryDESC;
	}
	
	@SuppressWarnings("unchecked")
	public List<ImportBills> ImportBillOrderByIdProviderASC() {
		List<ImportBills> importBillByIdProviderASC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM ImportBills im ORDER BY im.idProvider ASC";
			importBillByIdProviderASC = session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.clear();
			session.close();
		}
		return importBillByIdProviderASC;
	}
	
	@SuppressWarnings("unchecked")
	public List<ImportBills> ImportBillOrderByIdProviderDESC() {
		List<ImportBills> importBillByIdProviderDESC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM ImportBills im ORDER BY im.idProvider DESC";
			importBillByIdProviderDESC = session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.clear();
			session.close();
		}
		return importBillByIdProviderDESC;
	}
	
	@SuppressWarnings("unchecked")
	public List<ImportBills> ImportBillOrderByQuatityASC() {
		List<ImportBills> importBillByIdQuatityASC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM ImportBills im ORDER BY im.quatity ASC";
			importBillByIdQuatityASC = session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.clear();
			session.close();
		}
		return importBillByIdQuatityASC;
	}
	
	@SuppressWarnings("unchecked")
	public List<ImportBills> ImportBillOrderByQuatityDESC() {
		List<ImportBills> importBillByQuatityDESC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM ImportBills im ORDER BY im.quatity DESC";
			importBillByQuatityDESC = session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.clear();
			session.close();
		}
		return importBillByQuatityDESC;
	}
	
	@SuppressWarnings("unchecked")
	public List<ImportBills> ImportBillOrderByMonneyDESC() {
		List<ImportBills> importBillByMonneyDESC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM ImportBills im ORDER BY im.price DESC";
			importBillByMonneyDESC = session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.clear();
			session.close();
		}
		return importBillByMonneyDESC;
	}
	
	@SuppressWarnings("unchecked")
	public List<ImportBills> ImportBillOrderByMonneyASC() {
		List<ImportBills> importBillByMonneyASC = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hql = "FROM ImportBills im ORDER BY im.price ASC";
			importBillByMonneyASC = session.createQuery(hql).list();

			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.clear();
			session.close();
		}
		return importBillByMonneyASC;
	}
}

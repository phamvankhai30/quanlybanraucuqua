package BUS;

import java.util.List;

import DAO.ImportBills_DAO;
import Entitys.ImportBills;
import Entitys.Products;

public class ImportBills_BUS {
	ImportBills_DAO importBills_DAO = new ImportBills_DAO();
	ImportBills importBills = new ImportBills();
	
	public ImportBills addImportBill(Products product, int idCategory, int idProvider, double quatity, double price, String Date) {
		importBills.setProductID(product);
		importBills.setIdCategory(idCategory);
		importBills.setIdProvider(idProvider);
		importBills.setQuatity(quatity);
		importBills.setPrice(price);
		importBills.setDate(Date);
		
		return importBills_DAO.addImportBill(importBills);
	}
	
	public List<ImportBills> listImportBill(){
		return importBills_DAO.getAllImportBill();
	}
	
	public void deleteImportBill(int id) {
		importBills_DAO.deleteImportBill(id);
	}
	
	public ImportBills searchImportBillById(int id) {
		return importBills_DAO.searchImportBillById(id);
	}
}

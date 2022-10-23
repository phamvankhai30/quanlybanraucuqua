package BUS;

import java.util.List;

import DAO.ImportBillDetails_DAO;
import Entitys.ImportBillDetails;
import Entitys.ImportBills;

public class ImportBillDetails_BUS {
	ImportBillDetails_DAO importBillDetails_DAO =  new ImportBillDetails_DAO();
	
	ImportBillDetails billDetails = new ImportBillDetails();
	
	public void addImportBillDetails(ImportBills importBill, String nameProduct, String description) {
		billDetails.setIDimportBill(importBill);
		billDetails.setNameProduct(nameProduct);
		billDetails.setDescription(description);
		
		importBillDetails_DAO.addImportBillDetail(billDetails);
	}
	
	public List<ImportBillDetails> ChiTietHoaDonNhap(int id){
		return importBillDetails_DAO.getImportBillDetail(id);
	}
}

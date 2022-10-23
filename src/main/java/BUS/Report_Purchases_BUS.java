package BUS;

import java.util.List;

import DAO.Report_Purchases_DAO;
import Entitys.ImportBills;

public class Report_Purchases_BUS {
	Report_Purchases_DAO report_Purchases_DAO = new Report_Purchases_DAO();
	
	public List<ImportBills> HoaDonNhapTang() {
		return report_Purchases_DAO.ImportBillOrderByIdASC();
	}
	
	public List<ImportBills> HoaDonNhapGiam() {
		return report_Purchases_DAO.ImportBillOrderByIdDESC();
	}
	
	public List<ImportBills> MaLoaiSanPhamTang() {
		return report_Purchases_DAO.ImportBillOrderByIdCategoryASC();
	}
	
	public List<ImportBills> MaLoaiSanPhamGiam() {
		return report_Purchases_DAO.ImportBillOrderByIdCategoryDESC();
	}
	
	public List<ImportBills> MaSanPhamTang() {
		return report_Purchases_DAO.ImportBillOrderByIdProductASC();
	}
	public List<ImportBills> MaSanPhamGiam() {
		return report_Purchases_DAO.ImportBillOrderByIdProductDESC();
	}
	
	public List<ImportBills> MaNhaCungCapTang() {
		return report_Purchases_DAO.ImportBillOrderByIdProviderASC();
	}
	public List<ImportBills> MaNhaCungCapGiam() {
		return report_Purchases_DAO.ImportBillOrderByIdProviderDESC();
	}
	public List<ImportBills> SoLuongTang() {
		return report_Purchases_DAO.ImportBillOrderByQuatityASC();
	}
	public List<ImportBills> SoLuongGiam() {
		return report_Purchases_DAO.ImportBillOrderByQuatityDESC();
	}
	public List<ImportBills> TienTang() {
		return report_Purchases_DAO.ImportBillOrderByMonneyASC();
	}
	public List<ImportBills> TienGiam() {
		return report_Purchases_DAO.ImportBillOrderByMonneyDESC();
	}
	
}

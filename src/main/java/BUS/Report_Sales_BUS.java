package BUS;

import java.util.List;

import DAO.Report_Sales_DAO;
import Entitys.Orderdetails;

public class Report_Sales_BUS {
	Report_Sales_DAO report_Sales_DAO = new  Report_Sales_DAO();
	
	public List<Object[]> SapXepTheoMaHoaDonTangDan(){
		return report_Sales_DAO.OrderByIdOrderASC();
	}
	
	public List<Object[]> SapXepTheoMaHoaDonGiamDan(){
		return report_Sales_DAO.OrderByIdOrderDESC();
	}
	
	public List<Object[]> SapXepTheoMaSanPhamTangDan(){
		return report_Sales_DAO.OrderByIdProductASC();
	}
	
	public List<Object[]> SapXepTheoMaSanPhamGiamDan(){
		return report_Sales_DAO.OrderByIdProductDESC();
	}
	
	public List<Object[]> SapXepTheoMaNhanVienTangDan(){
		return report_Sales_DAO.OrderByIdEmployeeASC();
	}
	
	public List<Object[]> SapXepTheoMaNhanVienGiamDan(){
		return report_Sales_DAO.OrderByIdEmployeeDESC();
	}
	public List<Object[]> SapXepTheoTienTangDan(){
		return report_Sales_DAO.OrderByMonneyASC();
	}
	
	public List<Object[]> SapXepTheoTienGiamDan(){
		return report_Sales_DAO.OrderByMonneyDESC();
	}
	
	public static void main(String[] args) {

		Report_Sales_BUS report_Sales_DAO = new Report_Sales_BUS();
		
		List<Object[]> list = report_Sales_DAO.SapXepTheoMaNhanVienGiamDan();

		for(Object[] ob : list) {
			Orderdetails orderdetails1 = (Orderdetails) ob[0];
			System.out.println(orderdetails1.getIdorders().getIdEmployee());
		}

	}
}

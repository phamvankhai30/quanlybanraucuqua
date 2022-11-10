package BUS;

import java.util.List;

import DAO.Report_Sales_DAO;
public class Report_Sales_BUS {
	Report_Sales_DAO report_Sales_DAO = new  Report_Sales_DAO();
	
	public List<Object[]> OrderByIdOrderASC(){
		return report_Sales_DAO.OrderByIdOrderASC();
	}
	
	public List<Object[]> OrderByIdOrderDESC(){
		return report_Sales_DAO.OrderByIdOrderDESC();
	}
	
	public List<Object[]> OrderByIdProductASC(){
		return report_Sales_DAO.OrderByIdProductASC();
	}
	
	public List<Object[]> OrderByIdProductDESC(){
		return report_Sales_DAO.OrderByIdProductDESC();
	}
	
	public List<Object[]> OrderByIdEmployeeASC(){
		return report_Sales_DAO.OrderByIdEmployeeASC();
	}
	
	public List<Object[]> OrderByIdEmployeeDESC(){
		return report_Sales_DAO.OrderByIdEmployeeDESC();
	}
	public List<Object[]> OrderByPriceASC(){
		return report_Sales_DAO.OrderByPriceASC();
	}
	
	public List<Object[]> OrderByPriceDESC(){
		return report_Sales_DAO.OrderByPriceDESC();
	}
	
	public static void main(String[] args) {

//		Report_Sales_BUS report_Sales_DAO = new Report_Sales_BUS();
//		
//		List<Object[]> list = report_Sales_DAO.SapXepTheoMaNhanVienGiamDan();
//
//		for(Object[] ob : list) {
//			Orderdetails orderdetails1 = (Orderdetails) ob[0];
//			System.out.println(orderdetails1.getIdorders().getIdEmployee());
//		}

	}
}

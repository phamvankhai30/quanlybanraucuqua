package BUS;

import java.util.List;

import DAO.OrderDetails_DAO;
import Entitys.Orderdetails;

public class OrderDetails_BUS {
	OrderDetails_DAO orderDetails_DAO = new OrderDetails_DAO();
	Orderdetails orderdetails = new  Orderdetails();
	
	public void addOrderDetail(int idOrder, int idProduct, String tenSP, double soLuong, double giaTien) {
		orderdetails.setIdOrder(idOrder);
		orderdetails.setIdProduct(idProduct);
		orderdetails.setNameProduct(tenSP);
		orderdetails.setQuatity(soLuong);
		orderdetails.setPrice(giaTien);
		orderDetails_DAO.addOrderDetail(orderdetails);
	}
	
	public List<Orderdetails> listOrderDetailsByID(int idHD) {
	    	return orderDetails_DAO.getOrderDetailById(idHD);
    }
	
	public List<Orderdetails> listAllOrderDetail(){
		return orderDetails_DAO.getAllOrderDetail();
	}
}

package BUS;

import java.util.List;

import DAO.Orders_DAO;
import Entitys.Orders;

public class Orders_BUS {
	Orders_DAO orders_DAO = new  Orders_DAO();
	Orders order = new Orders();
	
	public Orders addOrder(int idCustomer, int idEmployee, double total, String date) {
		
		order.setIdCustommer(idCustomer);
		order.setIdEmployee(idEmployee);
		order.setTotal(total);
		order.setDate(date);
		return orders_DAO.addOrder(order);
	}
	
	public void deleteOrder(int id) {
		orders_DAO.deletOrderById(id);
	}
	public List<Orders> listOrder() {
		return orders_DAO.getAllOrder();
	}
	
	public Orders searchOrderById(int idOrder) {
		return orders_DAO.getOrderById(idOrder);
	}
}

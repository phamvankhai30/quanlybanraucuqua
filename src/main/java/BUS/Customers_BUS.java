package BUS;

import java.util.List;

import DAO.Customers_DAO;
import Entitys.Users;


public class Customers_BUS {
	Users customer = new Users();
	Customers_DAO customer_DAO = new Customers_DAO();
	
    public void addCustomer(String name,String phone,String address){
        	
    	customer.setName(name);
    	customer.setPhone(phone);
    	customer.setAddress(address);
    	customer.setRole(1); //role = 1 is customer; role = 2 is  employee
    	customer_DAO.addCustomer(customer);
    }
    
    public void updateCustomer(String name,String phone,String address){
    	
    	customer.setName(name);
    	customer.setPhone(phone);
    	customer.setAddress(address);
    	customer_DAO.updateCustomer(customer);
    }
    
    public void deleteCustomerById(int id) {
    	customer_DAO.deleteCustomerById(id);
    }
    
    public List<Users> showCustomers() {
    	return customer_DAO.getAllCustomer();
    }
    public Users getCustomerById(int id) {
    	return customer_DAO.getCustomerById(id);
    }
    
}

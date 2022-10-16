package BUS;

import java.util.List;

import DAO.Employees_DAO;
import Entitys.Users;

public class Employees_BUS {
	Users employee = new Users();
	Employees_DAO employee_DAO = new Employees_DAO();
	
    public void addEmployee(String name,String phone,String address){
        	
    	employee.setName(name);
    	employee.setPhone(phone);
    	employee.setAddress(address);
    	employee.setRole(2); //role = 1 is customer; role = 2 is  employee
    	employee_DAO.addEmployee(employee);
    }
    
    public void updateEmployee(String name,String phone,String address){
    	
    	employee.setName(name);
    	employee.setPhone(phone);
    	employee.setAddress(address);
    	employee_DAO.updateEmployee(employee);
    }
    
    public void deleteEmployeeById(int id) {
    	employee_DAO.deleteEmployeeById(id);
    }
    
    public List<Users> listEmployee() {
    	return employee_DAO.getAllEmployee();
    }
    public List<Users> searchEmployeeById(int id) {
    	return employee_DAO.searchEmployeeById(id);
    }

    public static void main(String[] args) {
		Employees_BUS bus = new Employees_BUS();
		bus.addEmployee("Khai ne", "01245689", "Hoa binh");
	}
}

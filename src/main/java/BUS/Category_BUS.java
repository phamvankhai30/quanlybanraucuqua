package BUS;

import java.util.List;

import DAO.Categorys_DAO;
import Entitys.Categorys;

public class Category_BUS {
	Categorys category = new Categorys();
	Categorys_DAO category_DAO = new  Categorys_DAO();
	
	public void addCategory(String name){
    	
    	category.setName(name);
    	category_DAO.addCategory(category);
    }
    
    public void updateCategory(String name){
    	
    	category.setName(name);
    	category_DAO.updateCategory(category);
    }
    
    public void deleteCategoryById(int id) {
    	category_DAO.deleteCategoryById(id);
    }

    public Categorys searchCategoryById(int id) {
    	return category_DAO.getCategoryById(id);
    }
    
	public List<Categorys> listCategorys() {
	    	return category_DAO.getAllCategorys();
	}

}

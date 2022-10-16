package BUS;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.imageio.ImageIO;

import DAO.Products_DAO;
import Entitys.Products;

public class Products_BUS {
	Products product = new Products();
	Products_DAO product_DAO = new Products_DAO();
	
    public void addProduct(int idCategory,int provider, String img, String name, double SoLuong, double price, String Description, String time){
        	
        	product.setIdCategory(idCategory);
        	product.setIdProvider(provider);
        	product.setImg(img);
        	product.setName(name);
        	product.setQuatity(SoLuong);
        	product.setPrice(price);
        	product.setDescription(Description);
        	product.setDate(time);
            product_DAO.addProduct(product);
    }
    
    public void updateProduct(int idCategory, int provider, String img, String name, double SoLuong, double price, String Description, String time){
    	
	    	product.setIdCategory(idCategory);
	    	product.setIdProvider(provider);
	    	product.setImg(img);
	    	product.setName(name);
	    	product.setQuatity(SoLuong);
	    	product.setPrice(price);
	    	product.setDescription(Description);
	    	product.setDate(time);
	        product_DAO.updateProduct(product);
    }
    
    public void deleteProductById(int id) {
    	product_DAO.deleteProductById(id);
    }
    
    public List<Products> ListProducts() {
    	return product_DAO.getAllProduct();
    }
    public Products getProductById(int id) {
    	return product_DAO.getProductById(id);
    }
    public static void main(String[] args) throws ParseException, IOException {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		String localDateTime = LocalDateTime.now().format(dateTimeFormatter);
		
		InputStream img = new FileInputStream(new File("C:\\Users\\Admin\\Desktop\\quanlybanraucuqua\\src\\main\\img\\oi.jpg"));
			
		Products product = new Products();
		Products_BUS products_BUS = new Products_BUS();

//		product.setIdCategory(idCategory);
//    	product.setIdProvider(provider);
//    	product.setImg(img);
//    	product.setName(name);
//    	product.setQuatity(SoLuong);
//    	product.setPrice(price);
//    	product.setDescription(Description);
//    	product.setDate(time);
//        product_DAO.addProduct(product);
		
    	//products_BUS.addProduct(1, 14, img, "Cá Cua", 10, 125000, "lala", localDateTime);
		
		
		
	}
}

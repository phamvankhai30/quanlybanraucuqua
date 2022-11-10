package BUS;

import java.util.List;

import DAO.Products_DAO;
import Entitys.Products;

public class Products_BUS {
	Products product = new Products();
	Products_DAO product_DAO = new Products_DAO();

	public Products addProduct( int idCategory, int provider, String img, String name, double SoLuong,
			double price, String Description, String time) {
		
		product.setIdCategory(idCategory);
		product.setIdProvider(provider);
		product.setImg(img);
		product.setName(name);
		product.setQuatity(SoLuong);
		product.setPrice(price);
		product.setDescription(Description);
		product.setDate(time);
		return product_DAO.addProduct(product);
	}

	public void updateProduct(int idProduct, int idCategory, int provider, String img, String name, double SoLuong,
			double price, String Description, String time) {
		product.setIdProduct(idProduct);
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

	public void updateQuatityProduct(int idProduct, double SoLuong) {
		product_DAO.updateQuatityProduct(idProduct, SoLuong);
	}

	public void deleteProductById(int id) {
		product_DAO.deleteProductById(id);
	}

	public Products searchProductById(int id) {
		return product_DAO.getProductById(id);
	}

//	public double TongTienSP(double soluong, double giatien) {
//		return product_DAO.TongTien(soluong, giatien);
//	}

	// ma san pham mac dinh la tang dan
	public List<Products> ListProducts() {
		return product_DAO.getAllProduct();
	}

	public List<Products> orderByProductIdDESC() {
		return product_DAO.orderByProductIdDESC();
	}

	public List<Products> orderByCategoryASC() {
		return product_DAO.orderByCategoryASC();
	}

	public List<Products> orderByCategoryDESC() {
		return product_DAO.orderByCategoryDESC();
	}

	public List<Products> orderByQuatityASC() {
		return product_DAO.orderByQuatityASC();
	}

	public List<Products> orderByQuatityDESC() {
		return product_DAO.orderByQuatityDESC();
	}

	public List<Products> orderByPriceASC() {
		return product_DAO.orderByPriceASC();
	}

	public List<Products> orderByPriceDESC() {
		return product_DAO.orderByPriceDESC();
	}

	public List<Products> orderByNameProductAZ() {
		return product_DAO.orderByNameProductAZ();
	}

	public List<Products> orderByNameProductZA() {
		return product_DAO.orderByNameProductZA();
	}

	public List<Products> orderByProviderASC() {
		return product_DAO.orderByProviderASC();
	}

	public List<Products> orderByProviderDESC() {
		return product_DAO.orderByProviderDESC();
	}

	public static void main(String[] args) {
		Products_BUS bus = new Products_BUS();
		bus.updateQuatityProduct(16, 40);
	}
}

package Entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetails")
public class Orderdetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_orderDetail")
	private int idOrderDetail;
	
	@Column(name = "id_order")
	private int idOrder;
	
	@Column(name = "id_product")
	private int idProduct;
	
	@Column(name = "name_product")
	private int nameProduct;
	

	@Column(name = "Quatity")
	private double quatity;

	@Column(name = "Price")
	private double price;

	public int getIdOrderDetail() {
		return idOrderDetail;
	}

	public void setIdOrderDetail(int idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
	
	public int getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(int nameProduct) {
		this.nameProduct = nameProduct;
	}

	public double getQuatity() {
		return quatity;
	}

	public void setQuatity(double quatity) {
		this.quatity = quatity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
}

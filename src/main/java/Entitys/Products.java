package Entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Products implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private int idProduct;
	
	@Column(name = "id_category")
	private int idCategory;
	
	@Column(name = "id_provider")
	private int idProvider;

	@Column(name = "Name")
	private String name;
	
	@Column( name = "Price")
	private double price;
	
	@Column(name = "Quatity")
	private double quatity;
	
	@Column(name = "Description")
	private String description;

	@Column(name = "img")
	private String img;
	
	@Column(name = "Date")
	private String date;

	@OneToOne(mappedBy = "productID")
	private ImportBills importBills;
	
	

	public ImportBills getImportBills() {
		return importBills;
	}

	public void setImportBills(ImportBills importBills) {
		this.importBills = importBills;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int id_product) {
		this.idProduct = id_product;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public int getIdProvider() {
		return idProvider;
	}

	public void setIdProvider(int idProvider) {
		this.idProvider = idProvider;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getQuatity() {
		return quatity;
	}

	public void setQuatity(double quatity) {
		this.quatity = quatity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}

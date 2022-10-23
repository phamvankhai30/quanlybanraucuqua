
package Entitys;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "importbills")
public class ImportBills implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_import ")
	private int idImport;

	@Column(name = "id_category")
	private int idCategory;

	@Column(name = "id_provider")
	private int idProvider;
	
	@Column(name = "Quatity")
	private double quatity;
	
	@Column(name = "Price")
	private double price;

	@Column(name = "Date")
	private String date;
	
	@OneToOne
	@JoinColumn(name = "id_product")
	private Products productID;
	
	@OneToOne(mappedBy = "IDimportBill")
	private ImportBillDetails importBillDetails;

	public int getIdImport() {
		return idImport;
	}

	public void setIdImport(int idImport) {
		this.idImport = idImport;
	}

	public Products getProductID() {
		return productID;
	}

	public void setProductID(Products productID) {
		this.productID = productID;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ImportBillDetails getImportBillDetails() {
		return importBillDetails;
	}

	public void setImportBillDetails(ImportBillDetails importBillDetails) {
		this.importBillDetails = importBillDetails;
	}
}

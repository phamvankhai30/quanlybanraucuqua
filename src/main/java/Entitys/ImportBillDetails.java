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
@Table(name = "importbilldetails")
public class ImportBillDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_importdetail ")
	private int idImportDetail;

	@Column(name = "name_product")
	private String nameProduct;

	@Column(name = "Description")
	private String description;

	@OneToOne
	@JoinColumn(name = "id_importbill", nullable = false)
	private ImportBills IDimportBill;

	public int getIdImportDetail() {
		return idImportDetail;
	}

	public void setIdImportDetail(int idImportDetail) {
		this.idImportDetail = idImportDetail;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ImportBills getIDimportBill() {
		return IDimportBill;
	}

	public void setIDimportBill(ImportBills iDimportBill) {
		IDimportBill = iDimportBill;
	}
	
	
}


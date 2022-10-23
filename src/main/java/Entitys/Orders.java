package Entitys;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private int idOrder;

	@Column(name = "id_employee")
	private int idEmployee;

	@Column(name = "id_custommer")
	private int idCustommer;

	@Column(name = "Total")
	private double total;

	@Column(name = "Date")
	private String date;

	@OneToMany(mappedBy = "idorders")
	private Set<Orderdetails> orderdetails = new HashSet<Orderdetails>();

	public Set<Orderdetails> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(Set<Orderdetails> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public int getIdCustommer() {
		return idCustommer;
	}

	public void setIdCustommer(int idCustommer) {
		this.idCustommer = idCustommer;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}

package com.tech;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.tech.Entity.Customer;

import lombok.Data;

@Data
@Entity
public class Transaction_Records {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int Transfer_From;
	private Double Rs;
	
	@ManyToOne
	public Customer customer;
	
	
	

	
	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public int getTransfer_From() {
		return Transfer_From;
	}





	public void setTransfer_From(int transfer_From) {
		Transfer_From = transfer_From;
	}





	public Double getRs() {
		return Rs;
	}





	public void setRs(Double rs) {
		Rs = rs;
	}





	public Customer getCustomer() {
		return customer;
	}





	public void setCustomer(Customer customer) {
		this.customer = customer;
	}





	@Override
	public String toString() {
		return "Transaction_Records [id=" + id + ", Transfer_From=" + Transfer_From + ", Rs=" + Rs + ", customer="
				+ customer + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

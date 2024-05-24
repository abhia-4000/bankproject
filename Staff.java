package com.tech;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.tech.Entity.Customer;

import lombok.Data;

@Data
@Entity
public class Staff {

	@Id
	private int s_Id;
	private int pin;
	private String s_Name;
	private String addrs;
	
	@OneToMany
	public List<Customer> customer;
	
	
	
	
	
	
	
	public int getS_Id() {
		return s_Id;
	}







	public void setS_Id(int s_Id) {
		this.s_Id = s_Id;
	}







	public int getPin() {
		return pin;
	}







	public void setPin(int pin) {
		this.pin = pin;
	}







	public String getS_Name() {
		return s_Name;
	}







	public void setS_Name(String s_Name) {
		this.s_Name = s_Name;
	}







	public String getAddrs() {
		return addrs;
	}







	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}







	public List<Customer> getCustomer() {
		return customer;
	}







	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}







	@Override
	public String toString() {
		return "\nStaff ID is =" + s_Id + ",\n Staff pin is =" + pin + ",\n Staff Name is =" + s_Name + ",\n Staff Address is =" + addrs + ".\n";
	}
	
	
}

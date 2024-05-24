package com.tech.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.tech.Staff;

import lombok.Data;


@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int c_Id;
	private int pin;
	private String c_Name;
	private String addrs;
	private double bal;
	private String type;
	
	@ManyToOne
	public Staff staff;
	
	
	
	
	public int getC_Id() {
		return c_Id;
	}




	public void setC_Id(int c_Id) {
		this.c_Id = c_Id;
	}




	public int getPin() {
		return pin;
	}




	public void setPin(int pin) {
		this.pin = pin;
	}




	public String getC_Name() {
		return c_Name;
	}




	public void setC_Name(String c_Name) {
		this.c_Name = c_Name;
	}




	public String getAddrs() {
		return addrs;
	}




	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}




	public double getBal() {
		return bal;
	}




	public void setBal(double bal) {
		this.bal = bal;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public Staff getStaff() {
		return staff;
	}




	public void setStaff(Staff staff) {
		this.staff = staff;
	}




	@Override
	public String toString() {
		
		return "\n Customer_Id is =" + c_Id + ",\n Customer_pin is =" + pin + ",\n Customer_Name is =" + c_Name + ",\n Customer_address is =" + addrs + ",\n Account_Balance is =" + bal
				+ ",\n Account_type is =" + type + ".";
	}
	
	

}

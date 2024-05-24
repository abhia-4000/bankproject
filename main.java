package com.tech;

import java.sql.SQLException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tech.Entity.Customer;
import com.tech.hibernateUtil.hibernateUtil;

import Exception.InvalidChoice;

public class main {

	static main m = new main();
	static Operation op = new Operation();
	Scanner sc = new Scanner(System.in);

	void Demo() throws ClassNotFoundException, SQLException {
		System.out.println("Select One of them..");
		System.out.println("1]. ADMIN SECTION \n2]. CUSTOMER SECTION \n3]. STAFF SECTION \n4].Exit");
		System.out.println("Enter Your Choice :");
		int ch = sc.nextInt();
		if (ch == 1) {
			op.Admin();
		} else if (ch == 2) {
			while (true) {
				m.Customer_Oper();
			}
		} else if (ch == 3) {
			while (true) {
				m.Staff_Oper();
			}
		}else if(ch==4){
			op.Exit();
		}
		else {
			throw new InvalidChoice("Invalid Password..");
		}
	}

	void Admin_oper() throws ClassNotFoundException, SQLException {
		System.out.println("Which Operation do you want to perfrom Select one of following..");
		System.out.println(
				"1]. Create Customer Data \n2]. Update Customer Data \n3]. Delete Customer Data \n4]. Get Customer Data \n5]. Ragister New Staff \n6]. Update Staff Information \n7]. Delete Staff Information \n8]. Get Staff Information \n9]. Get Transaction \n10]. Back");
		System.out.println("Enter Your Choice :");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			op.Cust_Register();
			break;

		case 2:
			op.Update_Cust_Data();
			break;

		case 3:
			op.Delete_Cust_Data();
			break;

		case 4:
			op.Get_Cust_Data();
			break;

		case 5:
			op.Staff_Register();
			break;

		case 6:
			op.Update_Staff_Data();
			break;

		case 7:
			op.Delete_Staff_Data();
			break;

		case 8:
			op.Get_Staff_Data();
			break;
			
		case 9:
			op.Get_Transactions();

		case 10:
			m.Demo();
			break;

		default:
			throw new InvalidChoice("Invalid Password..");

		}
	}

	void Customer_Oper() throws ClassNotFoundException, SQLException {
		System.out.println("Welcome Dear Sir/Ma'am");
		System.out.println("Please Select One Of Them..");
		System.out.println(
				"1]. Create New Account \n2]. Update Information \n3]. Change Pin \n4]. Deposite Money \n5]. Withdraw Money \n6]. Money Transfer \n7]. Balance Info \n8]. Back");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			op.Cust_Register();
			break;

		case 2:
			op.Update_Cust_Data();
			break;

		case 3:
			op.Change_Pin();
			break;

		case 4:
			op.Deposite_Money();
			break;

		case 5:
			op.Withdraw_Money();
			break;

		case 6:
			op.Money_Transfer();
			break;

		case 7:
			op.Balance_Info();
			break;

		case 8:
			m.Demo();
			break;
			
		case 9:
			throw new InvalidChoice("Invalid Password..");

		}
	}

	void Staff_Oper() throws ClassNotFoundException, SQLException {

		System.out.println("Please Select One Of Them..");
		System.out.println("1]. Create New Staff Id \n2]. Customer Info \n3]. Delete Customer Record \n4]. Update Customer Info \n5]. Back");

		System.out.println("Enter Your Choice..");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			op.Staff_Register();
			break;

		case 2:
			op.Get_Cust_Data();
			break;
			
		case 3:
			op.Delete_Cust_Data();
			break;
			
		case 4:
			op.Update_Cust_Data();
			break;

		case 5:
			m.Demo();
			break;

		case 6:
			throw new InvalidChoice("Invalid Password..");
			

		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		m.Demo();
		System.out.println("do you want to continue...");
		while (true) {
			m.Admin_oper();
		}
	}
}

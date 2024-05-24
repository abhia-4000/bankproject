package com.tech;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tech.Entity.Customer;
import Exception.IncorrectSecretCode;
import Exception.InsufficientBalance;
import Exception.InvalidPass;

import com.tech.hibernateUtil.hibernateUtil;

public class Operation {

	Scanner sc = new Scanner(System.in);
	Admin ad = new Admin();
	Customer cust = new Customer();
	Staff st = new Staff();

	void Admin() throws ClassNotFoundException, SQLException {
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("Enter Admin Secreat Id : ");
		String Id = sc.next();
		if (Id.equals("Admin@123")) {
			System.out.println("Enter Your ID : ");

			Admin ad = session.load(Admin.class, sc.nextInt());

			System.out.println("Enter Your Pin : ");
			if (ad.getA_pwd().equals(sc.next())) {
				System.out.println("Welcome To Admin Panel..");

			} else {
				throw new InvalidPass("Invalid Password");
			}
		}

		session.close();
		sf.close();
	}

	void Cust_Register() {

		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("Enter Your Pin : ");
		cust.setPin(sc.nextInt());

		System.out.println("Enter Your Name : ");
		cust.setC_Name(sc.next());

		System.out.println("Enter Your Address : ");
		cust.setAddrs(sc.next());

		while (true) {
			System.out.println("Enter Minimun Ammount to be Deposite : ");
			double rs = sc.nextDouble();

			if (rs >= 500) {
				cust.setBal(rs);
				break;
			} else {
				throw new InsufficientBalance("Ammount Should Be Greater Than 500 RS");
			}
		}

		System.out.println("Enter Account Type : Saving / Current");
		cust.setType(sc.next());

		List<Customer> l=new ArrayList<Customer>();
		l.add(cust);
		
		session.save(cust);
		session.beginTransaction().commit();
		session.close();
		sf.close();

		System.out.println("Congratulation Your Account Created Succcessfully..");
	}

	void Get_Cust_Data() {
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("What is Your Designation..");
		System.out.println("1]. Admin \n2]. Staff");
		System.out.println("Select One : ");
		int ch = sc.nextInt();
		if (ch == 2) {
			System.out.println("Enter Staff ID : ");

			Staff info = session.load(Staff.class, sc.nextInt());

			System.out.println("Enter Your Pin : ");
			if (info.getPin() == (sc.nextInt())) {
				List<Customer> cust = session.createQuery("from Customer").getResultList();
				for (Customer c : cust) {
					System.out.print("*************************");
					System.out.println(c);
					System.out.println("*************************");
				}
			} else {
				throw new InvalidPass("Invalid Password");
			}
		} else {
			System.out.println("Enter Admin ID : ");

			Admin info = session.load(Admin.class, sc.nextInt());

			System.out.println("Enter Your Pin : ");
			if (info.getA_pwd().equals(sc.next())) {
			List<Customer> cust = session.createQuery("from Customer").getResultList();
			for (Customer c : cust) {
				System.out.print("*************************");
				System.out.println(c);
				System.out.println("*************************");
			}
		} else {
			throw new InvalidPass("Invalid Password");
		}
		}
		session.close();
		sf.close();

		System.out.println("Data Fetched Successfully..");
	}


	void Update_Cust_Data() {
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("Enter Account Number : ");
		Customer info = session.get(Customer.class, sc.nextInt());

		System.out.println("Which feild you want to update..?");
		System.out.println("1. Name \n2. Address \n3. account type \n4. All ");
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("Enter New Name : ");
			info.setC_Name(sc.next());
		} else if (choice == 2) {
			System.out.println("Enter new Address : ");
			info.setAddrs(sc.next());
		} else if (choice == 3) {
			System.out.println("Enter type : ");
			info.setType(sc.next());
		}
		else {
			System.out.println("Enter New Name : ");
			info.setC_Name(sc.next());
			System.out.println("Enter new Address : ");
			info.setAddrs(sc.next());
			System.out.println("Enter type : ");
			info.setType(sc.next());
			
		}

		session.update(info);
		session.beginTransaction().commit();
		session.close();
		sf.close();

		System.out.println("Data Updated Successfully..");
	}

	void Delete_Cust_Data() {

		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("Enter Account Number : ");

		Customer info = session.get(Customer.class, sc.nextInt());
		if (info != null) {
			session.delete(info);
		}

		session.beginTransaction().commit();
		session.close();
		sf.close();

		System.out.println("Record Deleted Successfully..");

	}

	void Staff() {
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("Enter Staff Secreat Id : ");
		String Id = sc.next();
		if (Id.equals("Staff@123")) {
			System.out.println("Enter Your id : ");
			st.setS_Id(sc.nextInt());

			System.out.println("Enter Your password");
			st.setPin(sc.nextInt());
		} else {
			throw new IncorrectSecretCode("We can't proceed further..");
		}
		session.save(ad);
		session.beginTransaction().commit();
		session.close();
		sf.close();

		System.out.println("Welcome To Staff Panel..");

	}

	void Staff_Register() {

		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("Enter Staff Secreat Id : ");
		String Id = sc.next();
		if (Id.equals("Staff@123")) {
			System.out.println("Enter Staff ID : ");
			st.setS_Id(sc.nextInt());

			System.out.println("Enter Pin : ");
			st.setPin(sc.nextInt());

			System.out.println("Enter Name : ");
			st.setS_Name(sc.next());

			System.out.println("Enter Address : ");
			st.setAddrs(sc.next());
		} else {
			throw new IncorrectSecretCode("We can't proceed further..");
		}
		session.save(st);
		session.beginTransaction().commit();
		session.close();
		sf.close();

		System.out.println("Congratulation Your ID is Ganerated Succcessfully..");
	}

	void Get_Staff_Data() {
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("What is Your Designation..");
		System.out.println("1]. Admin \n2]. Staff");
		System.out.println("Select One : ");
		int ch = sc.nextInt();
		if (ch == 2) {
			System.out.println("Enter Staff ID : ");

			Staff info = session.load(Staff.class, sc.nextInt());

			System.out.println("Enter Your Pin : ");
			if (info.getPin() == (sc.nextInt())) {
				List<Staff> staff = session.createQuery("from Staff").getResultList();
				for (Staff c : staff) {
					System.out.print("*************************");
					System.out.println(c);
					System.out.println("*************************");
				}
			} else {
				throw new InvalidPass("Invalid Password");
			}
		} else {
			System.out.println("Enter Admin ID : ");

			Admin info = session.load(Admin.class, sc.nextInt());

			System.out.println("Enter Your Pin : ");
			if (info.getA_pwd().equals(sc.next())) {
			List<Staff> staff = session.createQuery("from Staff").getResultList();
			for (Staff c : staff) {
				System.out.print("*************************");
				System.out.println(c);
				System.out.println("*************************");
			}
		} else {
			throw new InvalidPass("Invalid Password");
		}
		}
		session.close();
		sf.close();

		System.out.println("Data Fetched Successfully..");
	}

	void Update_Staff_Data() {
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("Enter Staff ID : ");
		Staff info = session.get(Staff.class, sc.nextInt());

		System.out.println("Which feild you want to update..?");
		System.out.println("1. Name \n2. Address \n3. All ");
		int choice = sc.nextInt();
		if (choice == 1) {
			System.out.println("Enter New Name : ");
			info.setS_Name(sc.next());
		} else if (choice == 2) {
			System.out.println("Enter new Address : ");
			info.setAddrs(sc.next());
		}

		session.update(info);
		session.beginTransaction().commit();
		session.close();
		sf.close();
	}

	void Delete_Staff_Data() {

		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("Enter Account Number : ");

		Staff info = session.get(Staff.class, sc.nextInt());
		if (info != null) {
			session.delete(info);
		}

		session.beginTransaction().commit();
		session.close();
		sf.close();

		System.out.println("Record Deleted Successfully..");

	}

	void Deposite_Money() {
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("Enter Account Number : ");
		Customer info = session.get(Customer.class, sc.nextInt());

		System.out.println("Enter How Many rs You Want To Deposite : ");
		info.setBal(info.getBal() + sc.nextDouble());

		session.update(info);
		session.beginTransaction().commit();
		session.clear();
		sf.close();

		System.out.println("Money Deposited Successfully..");

	}

	void Withdraw_Money() {
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("Enter Account Number : ");
		Customer info = session.get(Customer.class, sc.nextInt());

		System.out.println("Enter How Many rs You Want To Withdraw : ");
		info.setBal(info.getBal() - sc.nextDouble());

		session.update(info);
		session.beginTransaction().commit();
		session.clear();
		sf.close();

		System.out.println("Money Withdraw Successfully..");

	}

	void Change_Pin() {
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("Enter Account Number : ");
		Customer info = session.get(Customer.class, sc.nextInt());

		System.out.println("Enter New Pin : ");
		info.setPin(sc.nextInt());
		session.update(info);
		session.beginTransaction().commit();
		session.close();
		sf.close();

		System.out.println("Pin Changed Successfully..");

	}

	void Balance_Info() {
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("Enter Your Accouont Number : ");

		Customer info = session.load(Customer.class, sc.nextInt());

		System.out.println("Enter Your Pin : ");
		if (info.getPin() == (sc.nextInt())) {
			System.out.print("*******************************");
			System.out.println("Account Balance Is  : " + info.getBal());
			System.out.println("*******************************");

		} else {
			throw new InvalidPass("Invalid Password");
		}
		session.close();
		sf.close();
	}

	void Money_Transfer() {

		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		Transaction bt=session.beginTransaction();
		
		System.out.println("Enter Your Accouont Number : ");
		int acc=sc.nextInt();

		Customer info = session.load(Customer.class, acc);
		System.out.println("Enter Your Pin : ");
		if (info.getPin() == (sc.nextInt())) {
			System.out.println("Enter Account Number To Transfer : ");
			int id = sc.nextInt();

			Customer find = session.find(Customer.class, id);

			Double cash=0.0;
			if (find != null) {
				System.out.println("How Many RS You Want To Transfer : ");
				cash = sc.nextDouble();
				info.setBal(info.getBal()-cash);
				if (info.getBal() >= 500) {
					find.setBal(find.getBal() + cash);
					
					Transaction_Records t=new Transaction_Records();
					t.setTransfer_From(acc);
					t.setRs(cash);
					t.setCustomer(find);
					session.save(t);
					
					System.out.println("Ammount Transfer Successfully..");
				} else {
					throw new InsufficientBalance("Account balance is greater than 500 rs..");
				}
			} else {
				System.out.println("Sorry..Account Number Does Not Exist..");
			}


		}

		
		
		
		bt.commit();
		session.clear();
		sf.close();

	}
	
	void Get_Transactions() {
		SessionFactory sf = hibernateUtil.getSessionFactory();
		Session session = sf.openSession();

		System.out.println("What is Your Designation..");
		System.out.println("1]. Admin \n2]. Staff");
		System.out.println("Select One : ");
		int ch = sc.nextInt();
		if (ch == 1) {
		System.out.println("Enter Admin Secreat Code : ");
		String code=sc.next();
		if(code.equals("Admin@123")) {

			List<Transaction_Records> records = session.createQuery("from Transaction_Records").getResultList();
			for (Transaction_Records c : records) {
				System.out.print("*************************\n");
				System.out.println("Transaction Id is : " +c.getId());
				System.out.println("Trransfer Account Number is : " + c.getTransfer_From());
				System.out.println("Receiver Account Number is : " + c.getCustomer().getC_Id());
				System.out.println("Rs Transfer : " + c.getRs());
				System.out.println("*************************");
			}
		}
		else {
			throw new IncorrectSecretCode("Please Enter Valid Secreat Code..");
		}
		}
		else{
			System.out.println("Enter Staff Secreat Code : ");
			String code=sc.next();
			if(code.equals("Staff@123")) {

				List<Transaction_Records> records = session.createQuery("from Transaction_Records").getResultList();
				for (Transaction_Records c : records) {
					System.out.print("*************************\n");
					System.out.println("Transaction Id is : " +c.getId());
					System.out.println("Trransfer Account Number is : " + c.getTransfer_From());
					System.out.println("Receiver Account Number is : " + c.getCustomer().getC_Id());
					System.out.println("Rs Transfer : " + c.getRs());
					System.out.println("*************************");
				}
			}
			else {
				throw new IncorrectSecretCode("Please Enter Valid Secreat Code..");
			}

		}
		
		session.close();
		sf.close();
	}
	
	void Exit() {
		System.out.println("Thank You.. for connecting with us.. 🙌😊");
		System.out.println("visit once again..🙌😊");

	}
}

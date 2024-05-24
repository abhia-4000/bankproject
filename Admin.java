package com.tech;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Admin {

		@Id
		private int a_Id;
		private String a_pwd;
		
		

		public int getA_Id() {
			return a_Id;
		}



		public void setA_Id(int a_Id) {
			this.a_Id = a_Id;
		}



		public String getA_pwd() {
			return a_pwd;
		}



		public void setA_pwd(String a_pwd) {
			this.a_pwd = a_pwd;
		}


		
}



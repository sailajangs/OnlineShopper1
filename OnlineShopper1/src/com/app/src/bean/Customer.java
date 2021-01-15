package com.app.src.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes

@Entity
@Table(name="customer_details")
public class Customer {
		@Id
		@Column(name="custID")
		@GeneratedValue
		private int custID;
		
		@Column(name="emailId")
		private String emailId;    
	
	    @Column(name="userName")
	    private String userName;

		@Column(name="password")
		    private String password;
		@Transient
		    private String confpassword;
            
		    
			public int getCustID() {
				return custID;
			}

			public void setCustID(int custID) {
				this.custID = custID;
			}

			public String getUserName() {
				return userName;
			}

			public void setUserName(String userName) {
				this.userName = userName;
			}

			public String getEmailId() {
				return emailId;
			}

			public void setEmailId(String emailId) {
				this.emailId = emailId;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}

			public String getConfpassword() {
				return confpassword;
			}

			public void setConfpassword(String confpassword) {
				this.confpassword = confpassword;
			}

			@Override
			public String toString() {
				return "Customer [custID=" + custID + ", emailId=" + emailId + ", userName=" + userName + ", password="
						+ password + ", confpassword=" + confpassword + "]";
			}

	
		    

}

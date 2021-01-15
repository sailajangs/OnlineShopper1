package com.app.src.bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author MSLC
 */
@SessionAttributes

@Entity
@Table(name="shopper_login_details")
public class Login implements Serializable{
	

		@Id
		@Column(name="ShopperID")
		@GeneratedValue
	private int Id;
	    @Column(name="EmailID")
	private String emailId;
	    @Column(name="Password")
	private String password;

    public String getPassword() {
        return password;
    }
    
    @Autowired
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }
    
    @Autowired
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }  
    
}

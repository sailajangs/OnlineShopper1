package com.app.src.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes

@Entity
@Table(name="shopper_cart_details")
public class CartDetails implements Serializable{
	
	@Id
	@Column(name="CartID")
	@GeneratedValue
	int cartId;
	@Column(name="ProductId")
    int pid;
	@Column(name="ProductName")
    String pname;
	@Column(name="Amount")
    double amount;
	@Column(name="EmailID")
    String emailId;
    @Column(name="Quantity")
    int quantity;
	@Column(name="Imageurl")
    String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



    public CartDetails() {
    }

    public CartDetails(String pname, int quantity) {
        this.pname = pname;
        this.quantity = quantity;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartDetails(int pid, String pname, int amount, String emailId, int quantity) {
        this.pid = pid;
        this.pname = pname;
        this.amount = amount;
        this.emailId = emailId;
        this.quantity = quantity;
    }
    
    @Override
	public String toString() {
		return "CartDetails [cartId=" + cartId + ", pid=" + pid + ", pname=" + pname + ", amount=" + amount
				+ ", emailId=" + emailId + ", quantity=" + quantity + ", imageUrl=" + imageUrl + "]";
	}

   
}

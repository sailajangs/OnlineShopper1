package com.app.src.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes

@Entity
@Table(name="order_items")
public class ItemsList implements Serializable{
	
	
	@Id
	@Column(name="itemId")
	@GeneratedValue
	int itemId;

	@Column(name="productName")
	String productName;
	@Column(name="quantity")
	int quantity;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="OrderId",referencedColumnName="OrderId",nullable=false,insertable = true,updatable = false)
	OrderDetails orders;
	

	public OrderDetails getOrders() {
		return orders;
	}

	public void setOrders(OrderDetails orders) {
		this.orders = orders;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
	        return quantity;
	    }
	 
	 public void setQuantity(int quantity) {
	        this.quantity = quantity;
	    }

	    public ItemsList(String productName, int quantity) {
	        this.productName = productName;
	        this.quantity = quantity;
	    }

	    public ItemsList() {
	    }
	    

	    public String getProductName() {
	        return productName;
	    }

	    public void setProductName(String productName) {
	        this.productName = productName;
	    }

		@Override
		public String toString() {
			return "ItemsList [itemId=" + itemId + ", productName=" + productName + ", quantity=" + quantity + "]";
		}
	    

	    
}

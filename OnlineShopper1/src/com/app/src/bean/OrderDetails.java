package com.app.src.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.CascadeType;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes

@Entity
@Table(name="shopper_order_details")
public class OrderDetails implements Serializable{
    
	@Id
	@Column(name="OrderId")
	@GeneratedValue
	int orderId;
	@Column(name="EmailId")
    String emailId;
	@Column(name="TotalAmount")
    double totalAmount;
	@Column(name="ShippingAddress")
    String shippingAddress;
	@OneToMany(cascade=CascadeType.ALL,targetEntity = ItemsList.class, mappedBy="orders",fetch = FetchType.LAZY)
    List<ItemsList> items;
	@Column(name="TimeOfOrder")
    String timeOfOrder;

    public String getTimeOfOrder() {
        return timeOfOrder;
    }

    public void setTimeOfOrder(String timeOfOrder) {
        this.timeOfOrder = timeOfOrder;
    }
    

    public OrderDetails(String emailId, double totalAmount, String shippingAddress) {
        this.emailId = emailId;
        this.totalAmount = totalAmount;
        this.shippingAddress = shippingAddress;
    }

    public OrderDetails() {
    }


    public List<ItemsList> getItems() {
        return items;
    }

    public void setItems(List<ItemsList> items) {
        this.items = items;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(long totalAmount) {
        this.totalAmount = totalAmount;
    }

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", emailId=" + emailId + ", totalAmount=" + totalAmount
				+ ", shippingAddress=" + shippingAddress + ", items=" + items + ", timeOfOrder=" + timeOfOrder + "]";
	}
    
    
}

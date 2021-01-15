package com.app.src.bean;

public class PlaceOrder {
		String address;
	    String city;
	    String state;
	    String country;
	    int pincode;
	    String emailId;
	    int quantity;
	    int cartId;
			public String getAddress() {
				return address;
			}
			public void setAddress(String address) {
				this.address = address;
			}
			public String getCity() {
				return city;
			}
			public void setCity(String city) {
				this.city = city;
			}
			public String getState() {
				return state;
			}
			public void setState(String state) {
				this.state = state;
			}
			public String getCountry() {
				return country;
			}
			public void setCountry(String country) {
				this.country = country;
			}
			public int getPincode() {
				return pincode;
			}
			public void setPincode(int pincode) {
				this.pincode = pincode;
			}
			public String getEmailId() {
				return emailId;
			}
			public void setEmailId(String emailId) {
				this.emailId = emailId;
			}
			public int getQuantity() {
				return quantity;
			}
			public void setQuantity(int quantity) {
				this.quantity = quantity;
			}
			public int getCartId() {
				return cartId;
			}
			public void setCartId(int cartId) {
				this.cartId = cartId;
			}
			@Override
			public String toString() {
				return "PlaceOrder [address=" + address + ", city=" + city + ", state=" + state
						+ ", country=" + country + ", pincode=" + pincode + ", emailId=" + emailId + ", quantity=" + quantity
						+ ", cartId=" + cartId + "]";
			}
   
}

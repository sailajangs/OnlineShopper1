package com.app.src.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes

@Entity
@Table(name="shopper_product_details")
public class Product implements Serializable {

	@Id
	@Column(name="ProductId")
	@GeneratedValue
	    int productId;
	@Column(name="ProductName")
	    String productname;
	@Column(name="ProductType")
	    String productType;
	@Column(name="StockAvailable")
	    int stockAvailable;
	@Column(name="Price")
	    double price;
	@Column(name="Category")
	    String category;
	@Column(name="Description")
	    String description;
	@Column(name="Imageurl")
	    String imageurl;

	    public String getImageurl() {
	        return imageurl;
	    }
	    @Autowired
	    public void setImageurl(String imageurl) {
	        this.imageurl = imageurl;
	    }

	   
	  

	    public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getDescription() {
	        return description;
	    }
	    @Autowired
	    public void setDescription(String description) {
	        this.description = description;
	    }

	  

	    public double getPrice() {
	        return price;
	    }
	    @Autowired
	    public void setPrice(double price) {
	        this.price = price;
	    }

	    public int getProductId() {
	        return productId;
	    }
	    @Autowired
	    public void setProductId(int productId) {
	        this.productId = productId;
	    }

	    public String getProductType() {
	        return productType;
	    }
	    @Autowired
	    public void setProductType(String productType) {
	        this.productType = productType;
	    }

	    public String getProductname() {
	        return productname;
	    }
	    @Autowired
	    public void setProductname(String productname) {
	        this.productname = productname;
	    }

	    public int getStockAvailable() {
	        return stockAvailable;
	    }
	    @Autowired
	    public void setStockAvailable(int stockAvailable) {
	        this.stockAvailable = stockAvailable;
	    }
	    
		@Override
		public String toString() {
			return "Product [productname=" + productname + ", productType=" + productType + ", stockAvailable="
					+ stockAvailable + ", price=" + price + ", category=" + category + ", description="
					+ description + ", imageurl=" + imageurl + "]";
		}
	    
}

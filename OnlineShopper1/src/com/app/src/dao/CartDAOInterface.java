package com.app.src.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.src.bean.ProductDetails;
import com.app.src.bean.CartDetails;
import com.app.src.bean.EditCartDetails;

public interface CartDAOInterface {

	@Autowired
	public List<CartDetails>  addProductstoCart (ProductDetails prod);
	public List<CartDetails>  editCart(EditCartDetails prod);
	public List<CartDetails>  removeFromCartDAO(int cartID);
	public List<CartDetails>  getUserCart(String email);
	
}

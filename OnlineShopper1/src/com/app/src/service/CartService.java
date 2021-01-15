package com.app.src.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.src.bean.ProductDetails;
import com.app.src.bean.CartDetails;
import com.app.src.bean.EditCartDetails;

@Service
@Transactional 
public interface CartService {
	
	@Autowired
	public List<CartDetails>  getProduct(ProductDetails prod);
	public List<CartDetails>  getProduct(String email);
	public List<CartDetails>  editCartService(EditCartDetails ep);
	public List<CartDetails>  removeFromCart(int cartID);


}

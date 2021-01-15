package com.app.src.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.src.bean.ProductDetails;
import com.app.src.bean.CartDetails;
import com.app.src.bean.EditCartDetails;
import com.app.src.dao.CartDAOInterface;



@Service
@Transactional 
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartDAOInterface cartDao;
	

	@Override
	public List<CartDetails> getProduct(ProductDetails prod) {
        return cartDao.addProductstoCart(prod);
	
	}
	
	@Override
	public List<CartDetails> editCartService(EditCartDetails ep)
    {
         return cartDao.editCart(ep);
    }
	
	@Override
	  public List<CartDetails> removeFromCart(int cartID) {
          return cartDao.removeFromCartDAO(cartID);

    }

	@Override
	public List<CartDetails> getProduct(String email) {
		// TODO Auto-generated method stub
		return cartDao.getUserCart(email);
	}
	
	

}

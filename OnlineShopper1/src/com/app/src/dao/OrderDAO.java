package com.app.src.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.src.bean.OrderDetails;

public interface OrderDAO {
	
	@Autowired
	public OrderDetails placeOrder(String address);
	public List<OrderDetails> cancelOrder(int orderId,String emailId);
}

package com.app.src.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.src.bean.OrderDetails;

@Service
@Transactional 
public interface OrderService {
	
	@Autowired
	public OrderDetails placeOrder(String address);
	public List<OrderDetails> cancelOrder(int orderId,String emailId);

}

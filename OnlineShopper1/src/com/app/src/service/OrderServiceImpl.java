package com.app.src.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.src.bean.OrderDetails;
import com.app.src.dao.OrderDAO;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDAO placeOrder;
	
	
	public OrderDAO getPlaceOrder() {
		return placeOrder;
	}

	public void setPlaceOrder(OrderDAO placeOrder) {
		this.placeOrder = placeOrder;
	}



	@Override
	public OrderDetails placeOrder(String address) {
		OrderDetails order=placeOrder.placeOrder(address);
		return order;
	}

	@Override
	public List<OrderDetails> cancelOrder(int orderId, String emailId) {
		List<OrderDetails> list=placeOrder.cancelOrder(orderId,emailId);
		return list;
	}

}

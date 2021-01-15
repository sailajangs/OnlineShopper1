package com.app.src.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.src.bean.Item;
import com.app.src.bean.Product;


public interface SearchDAOInterface {
	
	
	@Autowired
	//public List getDetails(String item);
	public List getDetails(Item item);
}

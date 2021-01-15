package com.app.src.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.src.bean.Item;
import com.app.src.bean.Product;

@Service
@Transactional 
public interface SearchInterface {
	
	@Autowired
	//public List searchProduct(String item);
	public List searchProduct(Item item);
}

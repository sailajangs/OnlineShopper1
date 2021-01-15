package com.app.src.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.src.dao.SearchDAOInterface;
import com.app.src.bean.Item;
import com.app.src.bean.Product;

@Service
@Transactional 
public class SearchService implements SearchInterface{
	
	@Autowired
	SearchDAOInterface searchDAO;

    public SearchDAOInterface getSearchDAO() {
        return searchDAO;
    }

    public void setSearchDAO(SearchDAOInterface searchDAO) {
        this.searchDAO = searchDAO;
    }

    @Override
	public List searchProduct(Item item){
    List list;
    list= searchDAO.getDetails(item);
    return list;

    }
}

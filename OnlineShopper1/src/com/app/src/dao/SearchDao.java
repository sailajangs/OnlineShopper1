package com.app.src.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Criteria;
import org.hibernate.Query;
import com.app.src.bean.Item;
import com.app.src.bean.Product;
import com.app.src.dao.SearchDAOInterface;

import javassist.bytecode.Descriptor.Iterator;

@Repository
public class SearchDao implements SearchDAOInterface{
	
	@Autowired(required=true)
	SessionFactory sessionFactory;

	@Override
	public List getDetails(Item item) {
		// TODO Auto-generated method stub
		Product p= new Product();
		Session session=sessionFactory.getCurrentSession();
		String hql = "from com.app.src.bean.Product p where p.productType=:ptype";
        Query createQuery = session.createQuery(hql).setParameter("ptype",item.getItem());
        System.out.println("in dao before query====="+ createQuery.getQueryString());
        List list = createQuery.list();
        return list;
	}
}
package com.app.src.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.app.src.bean.CartDetails;
import com.app.src.bean.Customer;
//import com.app.src.bean.CartDetails;
import com.app.src.bean.Login;


@Repository
@Transactional
public class LoginRegisterDAO {

	@Autowired(required=true)
	SessionFactory sessionFactory;
	
	public boolean check(Login lt) {
		System.out.println("==============Inside DAO============"+lt.getEmailId()+","+lt.getPassword());
        String pwd_by_user = lt.getPassword();
        Session session=sessionFactory.getCurrentSession();
        List<Login> list= new ArrayList<Login>();
        String hql = "from com.app.src.bean.Login l where l.emailId=:emailid";
        String hql1= "select l.emailId from com.app.src.bean.Login l";
        List<Login> list1=session.createQuery(hql1).list();  
        System.out.println(list1);
	        if(list1.contains(lt.getEmailId())) {
	          Query createQuery = session.createQuery(hql);
	          createQuery.setParameter("emailid", lt.getEmailId());
	          list= createQuery.list();
	        }
	        if (list.isEmpty()) {
	            return false;
	        } 
	        else {
	            Login login1 = (Login) list.get(0);
		            if ((login1.getPassword().equals(pwd_by_user))) {
		                return true;  } 
		            else 
		            {
		                return false; }
	             }

     }

	public boolean createCustomer(Customer cust) {
		Session session=sessionFactory.getCurrentSession();
        Login l = new Login();
        String hql = "from com.app.src.bean.Login l where l.emailId=:emailId";
        System.out.println("email id is "+cust.getEmailId());
        Query createQuery = session.createQuery(hql);
        createQuery.setParameter("emailId", cust.getEmailId());
        List<Login> list = createQuery.list();

        if (list.isEmpty()) {
        	session.save(cust);
            l.setEmailId(cust.getEmailId());
            l.setPassword(cust.getPassword());
            session.save(l);
            return false;
        } else {
           return true;
       }
	}
	
	public void clearCart(String email) {
		Session session=sessionFactory.getCurrentSession();
		List<Integer> list=session.createQuery("select cartId from com.app.src.bean.CartDetails c where c.emailId=:email").setParameter("email",email).list();
		for(int i=0;i<list.size();i++) {
			CartDetails cd= (CartDetails) session.get(CartDetails.class,list.get(i));
			session.delete(cd);
	    }
        
        
	}
}

package com.app.src.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.src.bean.Customer;
import com.app.src.bean.Login;
import com.app.src.dao.LoginRegisterDAO;



@Service
@Transactional 
public class LoginRegisterService {
	
	@Autowired
    LoginRegisterDAO loginDAO;
    
    
    public LoginRegisterDAO getLoginDAO() {
        return loginDAO;
    }

    public void setLoginDAO(LoginRegisterDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

   
    
    public boolean check(Login login){
        System.out.println("service "+login.getEmailId()+","+login.getPassword());
        boolean x=loginDAO.check(login);
        return x;



    }
    
    
    public boolean createCustomer(Customer cust){
        boolean x=loginDAO.createCustomer(cust);
        return x;
    }
    
    public void userLogout(String email){
    	loginDAO.clearCart(email);
    }
    

}
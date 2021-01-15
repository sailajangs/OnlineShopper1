package com.app.src.dao;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.src.bean.ProductDetails;
import com.app.src.bean.CartDetails;
import com.app.src.bean.EditCartDetails;
import com.app.src.bean.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Repository
@Transactional
public class CartDAO implements CartDAOInterface {
	
		
	@Autowired(required=true)
	SessionFactory sessionFactory;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<CartDetails> addProductstoCart(ProductDetails prod) {
		Session openSession = getSession();
        int pId = Integer.parseInt(prod.getPid());
        System.out.println(" the pid in addcart controller is "+ pId);
        Product getProductId = (Product) openSession.get(Product.class, pId);
        String Pname=getProductId.getProductname();
        if(isEmptyTable(Pname).isEmpty()) {
        	CartDetails cd = new CartDetails() ;
        	cd.setAmount(getProductId.getPrice());                                                            //if cart do not contain that product
            cd.setPname(getProductId.getProductname());
            cd.setPid(pId);
            cd.setQuantity(1);
            cd.setEmailId(prod.getEmail());
            cd.setImageUrl(getProductId.getImageurl());
            openSession.save(cd);
        	
        }
        else
        {
        	    System.out.println("inside addProductstoCart else ");
        	    int cartId=isEmptyTable(Pname).get(0);
        	    System.out.println("inside addProductstoCart else "+cartId);
        		CartDetails cd1 = (CartDetails) openSession.get(CartDetails.class,cartId);
        		cd1.setQuantity((cd1.getQuantity())+1);
        		cd1.setAmount(cd1.getAmount()+getProductId.getPrice());
        		openSession.beginTransaction();
        		openSession.saveOrUpdate(cd1);	
        		openSession.getTransaction().commit();
          	
        }
        List<CartDetails> loadAll= openSession.createCriteria(CartDetails.class).list();
        return loadAll;
        }
	
	
	 @SuppressWarnings("unchecked")
	@Override
	    public List<CartDetails> editCart(EditCartDetails prod) {
		    Session SessionEdit= getSession();
	        Product getProductId = (Product) SessionEdit.get(Product.class, prod.getPid());
	        String Pname=getProductId.getProductname();
	        int cartId=isEmptyTable(Pname).get(0);
	        CartDetails newCart = (CartDetails) SessionEdit.get(CartDetails.class, cartId);
	        newCart.setQuantity(prod.getQuantity());
	        newCart.setAmount((getProductId.getPrice())*(prod.getQuantity()));
	        SessionEdit.beginTransaction();
	        SessionEdit.update(newCart);
	        SessionEdit.getTransaction().commit();
	        List<CartDetails> newCartList = SessionEdit.createCriteria(CartDetails.class).list();
	        return newCartList;
	    }
	 
	 
	 @SuppressWarnings("unchecked")
	 @Override
	   public List<CartDetails> removeFromCartDAO(int cartId)
	    {
		    Session SessionDelete=getSession();
	        CartDetails cartToDelete=(CartDetails)SessionDelete.get(CartDetails.class,cartId);
	        SessionDelete.beginTransaction();
	        SessionDelete.delete(cartToDelete);
	        SessionDelete.getTransaction().commit();
	        List<CartDetails> newCartList=SessionDelete.createCriteria(CartDetails.class).list();
	        return newCartList;
	    }
	
	  @SuppressWarnings("unchecked")
	  private List<Integer> isEmptyTable(String Pname) {
		  String hql="select c.cartId from com.app.src.bean.CartDetails c,com.app.src.bean.Product p where c.pname=p.productname and c.pname=:Pname";
		   if(sessionFactory.openSession().createQuery(hql).setParameter("Pname",Pname).uniqueResult()!=null);
		     return sessionFactory.openSession().createQuery(hql).setParameter("Pname",Pname).list();
	  }
	  
	  private Session getSession() {
		  return  sessionFactory.openSession();
	  }


	@Override
	public List<CartDetails> getUserCart(String email) {
		 Session sessionGet=getSession();
		 List<CartDetails> getCart=sessionGet.createQuery("from  com.app.src.bean.CartDetails c where c.emailId=:email").setParameter("email", email).list();
		return getCart;
	} 
}

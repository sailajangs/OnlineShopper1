package com.app.src.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.app.src.bean.CartDetails;
import com.app.src.bean.ItemsList;
import com.app.src.bean.OrderDetails;
import com.app.src.bean.Product;
import org.hibernate.Query;

@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired(required=true)
	SessionFactory sessionFactory;

	@Override
	public OrderDetails placeOrder(String address) {
        Session openSession= sessionFactory.openSession();
        @SuppressWarnings("unchecked")
		List<CartDetails> cartlist=openSession.createCriteria(CartDetails.class).list();
        String emailId = cartlist.get(0).getEmailId();
        String hql = "select sum(c.amount) from com.app.src.bean.CartDetails c";
        Query createQuery1 = openSession.createQuery(hql);
        double totalAmount = (double) createQuery1.list().get(0);
        OrderDetails order = new OrderDetails(emailId, totalAmount, address);
        List<ItemsList> items=new ArrayList<ItemsList>();
        for(int i=0;i<cartlist.size();i++) {
        	ItemsList il =new ItemsList();
        	il.setProductName(cartlist.get(i).getPname());
        	il.setQuantity(cartlist.get(i).getQuantity());
        	il.setOrders(order);
        	items.add(il); 
        }
        order.setItems(items);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        order.setTimeOfOrder(currentDate);

        /**
         *  The Below will iterate through the product details fetched from the cart details table.
         * And updates the stock available of each product .
         */
        for (int i = 0; i < cartlist.size(); i++) {
            CartDetails cd = (CartDetails) cartlist.get(i);
            System.out.println("===Inside dao loop==="+cd.getPid()+"====="+cd.getCartId()+"===="+cartlist.get(i));
            Product getProduct = (Product) openSession.get(Product.class, cd.getPid());
            getProduct.setStockAvailable(getProduct.getStockAvailable() - cd.getQuantity());
            openSession.beginTransaction();
            openSession.update(getProduct);
            openSession.delete(cd);
            openSession.getTransaction().commit();
            System.out.println("===Inside dao loop==="+getProduct);
        }

        System.out.println("===Inside dao loop before save===");
        openSession.save(order);
        /**
         *  Deleting the rows from CartDetails table i.e clearing the cart Details table
         */



        return order;
	}

	@Override
	public List<OrderDetails> cancelOrder(int orderId, String emailId) {
		Session openSession= sessionFactory.openSession();
		System.out.println(emailId+"===before for loop ==="+orderId);
		OrderDetails orderDetails = (OrderDetails) openSession.get(OrderDetails.class, orderId);  
		List<ItemsList> items = orderDetails.getItems();
		System.out.println("===before for loop ==="+items);
        for(int i=0;i<items.size();i++)
        {
        	System.out.println("===inside for loop ==="+items.size());
            ItemsList il=(ItemsList)items.get(i);
            String productName = il.getProductName();
            int quantity = il.getQuantity();
            String hql="from com.app.src.bean.Product p where p.productname=:pname";
            List<Product> list = openSession.createQuery(hql).setParameter("pname",productName).list();
            Product product =(Product) list.get(0);
            product.setStockAvailable(product.getStockAvailable()+quantity);
            openSession.beginTransaction();
            openSession.update(product);
            openSession.getTransaction().commit();

        }
		openSession.beginTransaction();
		openSession.delete(orderDetails);
		openSession.getTransaction().commit();
        String hql="from com.app.src.bean.OrderDetails o where o.emailId=:emailid";
        Query createQuery = openSession.createQuery(hql);
        createQuery.setParameter("emailid", emailId);
        List<OrderDetails> orders = createQuery.list();
        return orders;
	}

}

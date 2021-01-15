package com.app.src.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.app.src.bean.ProductDetails;
import com.app.src.bean.CartDetails;
import com.app.src.bean.Customer;
import com.app.src.bean.EditCartDetails;
import com.app.src.bean.Item;
import com.app.src.bean.Login;
import com.app.src.bean.OrderDetails;
import com.app.src.bean.PlaceOrder;
import com.app.src.service.CartService;
import com.app.src.service.LoginRegisterService;
import com.app.src.service.OrderService;
import com.app.src.service.SearchInterface;

@Controller
public class CentralController{	
	
	 @Autowired(required=true)
	 LoginRegisterService loginService;
	 
	 @Autowired(required=true)
	 SearchInterface search;
	 
	 @Autowired(required=true)
	 CartService cartService;
	 
	 @Autowired(required=true)
	 OrderService orderService;
	 
	@RequestMapping(value="/homepage")
	public ModelAndView getHome() {
		ModelAndView mv = new ModelAndView("homepage");
        return mv;
		
	}
	
	@RequestMapping(value="/homepageuser", method= {RequestMethod.GET})
	public ModelAndView getUserHome(@RequestParam String emailId) {
		ModelAndView mv = new ModelAndView("homepageuser");
		mv.addObject("email",emailId);
        return mv;
		
	}
	 
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
        return mv;
		
	}
	
	@RequestMapping(value="/homepageuser", method=RequestMethod.POST)
	public ModelAndView loginsuccess(@ModelAttribute("loginForm") Login login1) {
		
          
        boolean x = loginService.check(login1);
        System.out.println("====================In new Dispatcher login action======================="+x);
        if (x) {
        	ModelAndView mv = new ModelAndView("homepageuser");
            mv.addObject("email", login1.getEmailId());
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("login");
            String message = "Invalid User name and Password...... Try Again";
            mv.addObject("message", message);
            return mv;
        }
		
	}
	
	@RequestMapping(value="/logout.htm", method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView logout(@RequestParam String emailId) {
		    loginService.userLogout(emailId);
			ModelAndView mv  = new ModelAndView("homepage");
        return mv;
		
	}
	
	@RequestMapping(value="/Registration", method=RequestMethod.GET)
	public ModelAndView newCustomer() {
		ModelAndView mv = new ModelAndView("Registration");
        return mv;
		
	}
	
	@RequestMapping(value="/registrationController.htm", method=RequestMethod.POST)
	public ModelAndView createNewCustomer(@ModelAttribute("regForm") Customer cust) {
		
          
        System.out.println("====================In new Dispatcher login action=======================");
        boolean exist = loginService.createCustomer(cust);

        if (!exist) {
            ModelAndView mv = new ModelAndView("registrationSuccess");
            mv.addObject("message", "You registration is successful!");
            mv.addObject("email", cust.getEmailId());
            return mv;
        } else {
            ModelAndView mv = new ModelAndView("Registration");
            mv.addObject("message", "The user name already exists."
            		+ "please register with different Email address");
            mv.addObject("email", cust.getEmailId());
            return mv;
        }
		
	}
	
	/**
     * The Following is the handler that displays the product list for the product item selected by the user from the category
     */
	 @RequestMapping(value="/searchController.htm", method= {RequestMethod.GET,RequestMethod.POST})
	 public ModelAndView searchController(@RequestParam String type,@RequestParam String emailId,

			   HttpServletRequest request, HttpServletResponse response) throws Exception {

		    ModelAndView mv;

	        /**
	         * checks whether the email Id is null or not. If the emailId is null then the product list1 page is displayed
	         */
	        if (emailId.equals("null")) {

	            mv = new ModelAndView("productlist");


	        } 
	        /**
	         * Else product list page is displayed.
	         */
	        else {


	            mv = new ModelAndView("userproductlist");

	        }

	        /**
	         * Setting the item in the simple POJO and calling the service class method to get the product details for that item name
	         */
	        Item i = new Item();
	        i.setItem(type);
	        List list = search.searchProduct(i);
            for(int j=0;j<list.size();j++) {
            	System.out.println("In search Controller list values is " +list.get(j));
            }

	        /**
	         * setting the products and session email Id in the response page
	         */
	        System.out.println("In search Controller email id is " + emailId+list.size());
	        mv.addObject("email", emailId);
	        mv.addObject("List", list);
	        
	        
	        
	       // mv.addObject("semailId", EmailId);
	        return mv;
	    }
	 
	 
	 
	 @RequestMapping (value="/addcart.htm" ,method= {RequestMethod.POST})
	 public ModelAndView addToCart(@ModelAttribute ("addProduct") ProductDetails add, HttpServletRequest request) {
		 
		 /**
	         * Checking the user is logged in or not
	         */
	        if ((add.getEmail()).equals("null")) {
	            ModelAndView mv = new ModelAndView("login");
	            mv.addObject("message", "You have not logged in..Please sign in if you are an user or sign up!");
	            return mv;
	        } 
		 /**
	         * The product is added to the cart if the user is logged in..
	         */
	        else
	        {
	            System.out.println("in add cart controller ....................." + add.getPid());
	            List list = cartService.getProduct(add);

	            ModelAndView mv = new ModelAndView("success");
	            Iterator itr = list.iterator();
	            double amt = 0;
	            int size=0;
	            while (itr.hasNext()) {
	                CartDetails cd = (CartDetails) itr.next();
	                amt = amt + cd.getAmount();
	                size+=cd.getQuantity();

	            }

	            mv.addObject("amount", String.format("%.2f", amt));
	            mv.addObject("sizeofcart", size);
	            mv.addObject("email", add.getEmail());
	            mv.addObject("List", list);
	            String EmailId = (String) request.getSession(false).getAttribute("emailId");
	            System.out.println("In add cart controller email id is ==" + EmailId);
	            mv.addObject("semailId", EmailId);
	            return mv;

	        }

	 }

	 @RequestMapping (value="/edit.htm" ,method= {RequestMethod.GET,RequestMethod.POST})

	 public ModelAndView editCart(@ModelAttribute ("edit") EditCartDetails edit, HttpServletRequest request) {

         /**
          *  updating the quantity in the data base by calling the service class method
          */
         List<CartDetails> newCartList = cartService.editCartService(edit);


         /**
          *  calculating the total amount of all products  in the cart.
          */
         Iterator<CartDetails> i = newCartList.iterator();
         double amt = 0;
         int size=0;
         while (i.hasNext()) {
             CartDetails cd = (CartDetails) i.next();
             amt = amt + cd.getAmount();
             size+=cd.getQuantity();
         }

         /**
          *  setting the response page to show the cart details  and adding all products of the cart  to it to render on the page
          */
         ModelAndView mv = new ModelAndView("success");
         mv.addObject("amount", String.format("%.2f",amt));
         mv.addObject("sizeofcart", size);
         mv.addObject("List", newCartList);
         mv.addObject("email", edit.getEmail());
         return mv;
	 }
	 
	 @RequestMapping (value="/remove.htm" ,method= {RequestMethod.GET,RequestMethod.POST})
	 public ModelAndView removeCart(@RequestParam int cartid,@RequestParam String email, HttpServletRequest request) {
		 
		 /**
	         * Removing the product from the cart details by calling the service class method and passing the java POJO as
	         * an argument..
	         */
	        List<CartDetails> newProductList = cartService.removeFromCart(cartid);

	        /**
	         *  calculating the total amount of all products  in the cart.
	         */
	        double amt = 0;
	        int size=0;
	        Iterator<CartDetails> i = newProductList.iterator();
	        while (i.hasNext()) {
	            CartDetails cd = (CartDetails) i.next();
	            amt = amt + cd.getAmount();
	            size+=cd.getQuantity();
	        }
	        /**
	         *  setting the response page to show the cart details  and adding all products of the cart  to it to render on the page
	         */
	        ModelAndView mv = new ModelAndView("success");
	        mv.addObject("List", newProductList);
	        mv.addObject("amount", String.format("%.2f",amt));
	        mv.addObject("email", email);
	        mv.addObject("sizeofcart", size);
	        if(newProductList.size()==0) {
	        	mv.addObject("message","Your cart is empty. Please add items in your cart to proceed!.");
	        }
	        System.out.println("In edit controller remove email id is ==" + email);
	        return mv;
	 }
	 
	 @RequestMapping (value="/displayaddress.htm" ,method= {RequestMethod.GET,RequestMethod.POST})
	 public ModelAndView placeOrderForm(@RequestParam String email, HttpServletRequest request) {
		 /**
		     * The Following is the handler that displays the address page before placing the order.
		     */
		        List list = cartService.getProduct(email);
		        int sizeofcart=0;
		        
		        Iterator itr = list.iterator();
	            double amt = 0;
	            while (itr.hasNext()) {
	                CartDetails cd = (CartDetails) itr.next();
	                amt = amt + cd.getAmount();
	                sizeofcart+=cd.getQuantity();
	            }
		        ModelAndView mv = new ModelAndView("displayaddress");
		        mv.addObject("List",list);
		        mv.addObject("sizeofcart",sizeofcart);
		        mv.addObject("totalAmount",String.format("%.2f", amt));
		        mv.addObject("email", email);
		        mv.addObject("semailId", email);
		        System.out.println("In place order controller display address email id is " + email);

		        return mv;
	 }
	 
	 @RequestMapping (value="/placeOrder.htm" ,method= {RequestMethod.POST})
	 public ModelAndView placeOrder(@ModelAttribute ("placeOrderForm") PlaceOrder placeOrderForm, HttpServletRequest request) {
	
		 String address = (placeOrderForm.getAddress() + " ," + placeOrderForm.getCity() +
				          " ," + placeOrderForm.getState() + " ," + "USA" + " ," + placeOrderForm.getPincode());
		 
		 OrderDetails placeOrder=orderService.placeOrder(address);
		 List<OrderDetails> orderlist=new ArrayList<OrderDetails>();
		 orderlist.add(placeOrder);
		 ModelAndView mv = new ModelAndView("viewOrderSuccessful");
		 if (orderlist.isEmpty()) {
	            mv.addObject("message", "You Have No Orders to display");
	            mv.addObject("email", placeOrder.getEmailId());
	            return mv;
	        }
		 else {
		 mv.addObject("message", "Thank You for Shopping with us. Your order has been successfully placed");
         mv.addObject("orderlist", orderlist);
         mv.addObject("email", placeOrder.getEmailId());
         }
         return mv;
	 }
	 
	 @RequestMapping (value="/cancelOrder.htm" ,method= {RequestMethod.GET,RequestMethod.POST})
	 public ModelAndView cancelOrder(@RequestParam int orderid,@RequestParam String email, HttpServletRequest request) {
       
	        ModelAndView mv = new ModelAndView("viewOrderSuccessful");
	        List<OrderDetails> list = orderService.cancelOrder(orderid, email);
	        /**
	         * If the order detail list is empty then display no orders to display
	         */
	        if (list.isEmpty()) {
	            mv.addObject("message", "Your orders has been cancelled.");
	            System.out.println("In View Order Controller viewordersuccessful email id is " + email);
	            mv.addObject("email", email);
	            return mv;
	        } /**
	         * Otherwise display the order details   to the user..
	         */
	        else {
	            Iterator it = list.iterator();
	            while (it.hasNext()) {
	                OrderDetails ir = (OrderDetails) it.next();
	                email = ir.getEmailId();
	            }
	            mv.addObject("message", "Order Details");
	            mv.addObject("orderlist", list);
	            mv.addObject("email", email);
	            System.out.println("In View Order Controller viewordersuccessful email id is " + email);
	            return mv;
	        }
	 }
	 
	 
}

	
    

    
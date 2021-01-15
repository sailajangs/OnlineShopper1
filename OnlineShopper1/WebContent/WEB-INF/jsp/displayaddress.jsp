<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-
transitional.dtd"> <html xmlns="http://www.w3.org/1999/xhtml" > 
    <head>
         <c:set var="base" value="${pageContext.request.contextPath}"/>
        <link rel="stylesheet" href="${base}/CSS/button.css" type="text/css"/>
        <link rel="stylesheet" href="${base}/resources/CSS/homepage1.css" type="text/css"/>
        <link rel="stylesheet" href="ttps://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
         <title>Billing Address</title>
    </head>
    
    <body  style="background-color:white;margin:0px;padding:0px;border:0px">
      <header>
         <div class="div_logo">
           <h2 class="logo">Shopper's Central</h2>
         <div>
        <br/>
        <jsp:include page="menu1.jsp"></jsp:include>
     </header>
                         <div class="row">
                               
                                
                                    <div class="col-sm-6" style="padding-left:40px;">
                                      <form action="placeOrder.htm" method="post" modelAttribute="placeOrderForm">
                                            <div class="form-group">
                                            <h3 style="font-family:Helvetica,Arial,sans-serif;">Billing Address:</h3></div>
                                            <div class="form-group">
                                            <label for="comment">Address:</label>
                                            <textarea name="address" class="form-control" rows="5"></textarea>
                                            </div>

                                             <div class="form-group">
                                            <label for="cntry">Country:</label>
                                            <input type="text" name="country" value="USA" class="form-control" disabled/></div>

                                                  <div class="form-group">
						                          <label for="sel1">State </label>
						                          <select id="STATE"  name="state" class="form-control">
						                                <option value="SELECT">SELECT</option>
						                                <option value="Arkansas">Arkansas</option>
						                                <option value="California">California</option>
						                                <option value="Colorado">Colorado</option>
						                                <option value="Florida">Florida</option>
						                                <option value="Illinois">Illinois</option>
						                                <option value="Iowa">Iowa</option>
						                                <option value="Missouri">Missouri</option>
						                                <option value="Nebraska"> Nebraska</option>
						                                <option value="Nevada">Nevada</option>
						                                <option value="New Jersey">New Jersey</option>
						                                <option value="New Mexico">New Mexico</option>
						                                <option value="New York">New York</option>
						                                <option value="Oklahoma">Oklahoma</option>
						                                <option value="Pennsylvania">Pennsylvania</option>
						                                <option value="Tennessee">Tennessee</option>
						                                <option value="Texas">Texas</option>
						                                <option value="Utah">Utah</option>
						                                <option value="Vermont">Vermont</option>
						                                <option value="Virginia">Virginia</option>
						                                <option value="Washington"> Washington</option>
						                            </select>
                                                    </div>
                                              <div class="form-group">
                                             <label for="name">City </label>
                                             <input type="text" id="CITY" name="city" class="form-control"/></div>

                                             <div class="form-group">
                                            <label for="name">Zipcode:</label>
                                            <input type="text" name="pincode" maxlength="6" class="form-control"/>
                                            </div>

                                 		  <div class="form-group">
                                            <input type="hidden" name="emailId" value="${email}" class="form-control"/>
                                            <input type="submit" value="Proceed to Check Out" class="form-control" 
                                            style="background-color:#238e2b;align:center;color:white;font-size:15px;"/>
                                           </div>
                                       
                                                                 
                                  </form>      
                               </div>
                                <div class="col-sm-3" style="padding:70px 50px;">
	                                <table class="table" style="border:1px solid green; border-radius:1px;">
	                                   <tr class="active">
	                                      <th class="active" colspan="4"><h3 style="color:#238e2b;">Order Summary
			                               <span class="badge" style="padding:7px 13px;font-size:15px;font-weight:900;background-color:#238e2b;float:right;">
			                                 ${sizeofcart}</span></h3>
			                               </th></tr>
		                                     <c:forEach items="${List}" var="list" >
						                           <tr class="active">
						                                   <td class="active"><img src="${list.imageUrl}" height="60"/></td>
						                                   <td class="active">x</td>
						                                   <td class="active">${list.quantity}</td>
						                                   <td class="active">$<fmt:formatNumber type = "number"  maxIntegerDigits = "3" value="${list.amount}"></fmt:formatNumber></td>
						                            </tr>
						                     </c:forEach>
					                     <tr><td class="active" colspan="3">Sub Total:</td>
					                         <td class="active">$ ${totalAmount}</td></tr>
					                 </table>
                                </div>
                       </div>
    </body>
</html>

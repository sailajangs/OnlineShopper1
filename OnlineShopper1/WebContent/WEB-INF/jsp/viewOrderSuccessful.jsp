<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:set var="base" value="${pageContext.request.contextPath}"/>
        <link rel="stylesheet" href="${base}/resources/CSS/homepage1.css" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <title>Purchase information</title>
    </head>
    <body style="background-color: white">
         <header>
	         <div class="div_logo">
	            <h2 class="logo">Shopper's Central</h2>
	        </div>
		        <br/>
		        <jsp:include page="menu1.jsp"></jsp:include>
		 </header>
          <div class="panel panel-default">
            
			       <div class="panel-heading"><h4>${message}</h4></div>
			       <div class="panel-content">
			       <table class="table">
			        <thead>
			           <tr style="background-color:lightgrey">
			              <th colspan=2 style="font-size:15px;text-align:center;">Customer Information</th>
			              <th colspan=4 style="font-size:15px;text-align:center">Purchase Details</th>
			           </tr>
			           <tr >
			                <th>Email</th>
			                <th>Transaction No.</th>
			                <th>Item Name-Quantity</th>
			                <th >Total Amount </th>
			                <th >Time Of Order</th>
			                <th width="50"></th>
			            </tr>
			         </thead>
			            
			          <tbody>     
			               <tr>
			                <c:forEach var="orderlist" items="${orderlist}">
			                        <td>${orderlist.emailId}</td>
			                        <td>${orderlist.orderId}</td>
			                        <td >
			                            <c:forEach var="items" items="${orderlist.items}">
			
			                                <table class="table table-striped">
			                                <tr>
			                                    <td>${items.productName}</td>
			                                    <td><span style="padding:5px;">x</span>${items.quantity}</td>
			                                </tr>
			                                </table>
			                            </c:forEach>
			                        </td>
			                        <td> ${orderlist.totalAmount}</td>
			                        <td>${orderlist.timeOfOrder}</td>
			                        <td><a href="${base}/cancelOrder.htm?orderid=${orderlist.orderId}&email=${orderlist.emailId}" class="btn btn-info">Cancel Order</a></td>
			                 </tr>
			               </c:forEach>
			            </tbody>
			                    
			          </table>
			          </div>
			   </div>
 
    </body>
</html>
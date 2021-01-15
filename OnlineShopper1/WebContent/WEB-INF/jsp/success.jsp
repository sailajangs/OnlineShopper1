<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="t"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-
    transitional.dtd">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>cart details</title>
        <c:set var="base" value="${pageContext.request.contextPath}"/>
        <link rel="stylesheet" href="${base}/resources/CSS/homepage1.css" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

    <style>
        .tr{

            border: 1px solid brown;
        }

    </style>
   


    <script  type="text/javascript">
        function validateEntry(FormObject){
              var number1=/^[0-9]{1,7}$/;
            if(FormObject.elements['quantity'].value=="")
            {
                alert("No Quantity Is Set For Updation");
                FormObject.elements['quantity'].focus();
                return false;
            }
             a= FormObject.elements['quantity'].value;
            if(!number1.test(a)){
                alert("Please Enter Digits Only ");
                 FormObject.elements['quantity'].focus()
                return  false;
            }

            else
            return true ;  
          }
    </script>
</head>
<body style="background-color:white;margin:0px;padding:0px;border:0px;">
		<header>
	         <div class="div_logo">
	            <h2 class="logo">Shopper's Central</h2>
	        </div>
		        <br/>
		        <jsp:include page="menu1.jsp">
		          <jsp:param name="sizeofcart" value="${sizeofcart}"></jsp:param>
		        </jsp:include>
		 </header>
  
    

        
    <div class="panel panel-default">
    <div class="panel-heading"> <h3>Your Cart Items</h3></div>
    <div class="panel-content">
    <table class="table" align="center">
    <thead>
        <tr>
            <th></th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Amount</th>
        </tr>
     </thead>
     <tbody>
        <c:forEach items="${List}" var="list" >

            <form action="edit.htm" method="post" modelAttribute="edit">
                <tr>
                    <td width="70"><img src="${list.imageUrl}" width="60" height="60"/></td>
                    <td>${list.pname}
                    <input type="hidden" name="pid" id="pid" value="${list.pid}"/></td>
                    <td>${list.quantity}

                        <input type="text" name="quantity" id="quantity" style="visibility:visible;width:25px"/>
					    <input type="hidden" name="email" id="email" value="${email}"/>
                        <input type="submit" value="Update" class="btn btn-info" onclick="return validateEntry(this.form)"/>
                        <a href="${base}/remove.htm?cartid=${list.cartId}&email=${email}" class="btn btn-info">Remove</a>
                    </td>
                    <td>$<fmt:formatNumber type = "number"  maxIntegerDigits = "3" value="${list.amount}"></fmt:formatNumber></td>
                    <td></td>
                </tr>
            </form>

        </c:forEach>
        <tr>
            <td colspan="3"></td>
            <td ><span>Total:</span><font color="green">$${amount}</font>Only</td>
            <td></td>
        </tr>
        <tr>

            <td colspan="4"> <a href="${base}/homepageuser.htm?emailId=${email}" class="btn btn-info" role="button">Continue Shopping</a></td>
            <c:if test="${sizeofcart ne 0}">
            <td style="float:right">
              <a href="${base}/displayaddress.htm?email=${email}" class="btn btn-info" role="button">Place Order</a></td>
             </c:if>
        </tr>
       </tbody>
    </table>
      	     <center>
            <p id="alink" style="color:red;"> <strong> ${message}</strong></p>
             </center>
    </div>
    </div>
</body>
</html>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopper's Central Products</title>
        <c:set var="base" value="${pageContext.request.contextPath}"/>
        <link rel="stylesheet" href="${base}/resources/CSS/homepage1.css" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="${base}/resources/CSS/button.css"/>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    </head>
    <body style="background-color:white;margin:0px;padding:0px;border:0px" onload="noBack()">
    <header>
         <div class="div_logo">
        <h2 class="logo">Shopper's Central</h2>
        <div>
        <br/>
        <jsp:include page="menu.jsp"></jsp:include>
     </header>
        <br/> 
       <div class="row" style="padding:50px">
            <c:forEach items="${List}" var="list">
              <div class="col-sm-4" style="padding-top:25px;">
                <form action="addcart.htm" method="post" modelAttribute="addProduct">
                            <div class="card">
                                <div class="img-container">
                                    <img src="${list.imageurl}" width=200px height=200px/>     
                               </div>
                                <div class="card-body">
                                <h3>${list.productname}</h3>
                                <h3>Price:<font color="red">$ ${list.price}</font></h3></td>
                                </div>
                               
                            </div>
                            <div class="card" style="padding-top:5px">
                            <div class="card-body">
                                   <p>${list.description}</p>
                                       <input type="hidden" name="email" value="null">
                                     <p> Stock Available: ${list.stockAvailable}</p>
                                    <input type="hidden" name="pid" value=${list.productId}>
                                    <input type="submit" value="Add to Cart" size="50" class="button">
                            </div>
                            </div>
                </form>
                </div>
            </c:forEach>
        </div>


    </body>
</html>
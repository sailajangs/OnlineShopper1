<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <c:set var="base" value="${pageContext.request.contextPath}"/>
        <link rel="stylesheet" href="${base}/resources/CSS/master1.css" type="text/css"/>
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Menu</title>
    </head>
    <body>

 

        <ul class='dd_menu'>
            <li><a id="Categories">Categories</a>
                <ul><a href="${contextPath}/searchController.htm?type=Books&emailId=null">Books</a>
                    <a href="${contextPath}/searchController.htm?type=Electronics&emailId=null">Electronics</a>
                    <a href="${contextPath}/searchController.htm?type=Clothing&emailId=null">Clothing</a>  
                </ul>
            </li>
            <li><a href='homepage.htm'>Home</a></li>

            <li><A HREF="Registration.htm" >Register</A>
            </li>
            <li> <A HREF="login.htm">Login</A></li>
            </li>
           
        </ul>
       
    </body>
</html>
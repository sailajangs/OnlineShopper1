
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:set var="base" value="${pageContext.request.contextPath}"/>
        <link rel="stylesheet" href="${base}/resources/CSS/master1.css" type="text/css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <title>Home Menu-User</title>
    </head>
    <body>            
        <ul class='dd_menu'>
            <li><a id="Categories">Categories</a>
               <ul> <a href="${base}/searchController.htm?type=Books&emailId=${email}">Books</a>
                    <a href="${base}/searchController.htm?type=Electronics&emailId=${email}">Electronics</a>
                    <a href="${base}/searchController.htm?type=Clothing&emailId=${email}">Clothing</a>
               </ul>
               </li>


            <li><a href="${base}/homepageuser.htm?emailId=${email}">Home</a></li>
             <li> <a id="account"> Hello ${email}</a>
		            <ul>
		                <a href="${base}/logout.htm?emailId=${email}">Logout</a>
		            </ul>
            </li>

            <li style="font:15px arial, verdana, sans-serif; font-weight: bold;color:#fff;padding:9px 45px;display:block;">Cart
            <span class="badge" style="padding:3px 3px;font-size:15px;font-weight:900;background-color:black;">${param.sizeofcart}</span></li>
        </ul>

    </body>
</html>

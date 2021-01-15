<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:set var="base" value="${pageContext.request.contextPath}"/>
        <link rel="stylesheet" href="${base}/resources/CSS/homepage1.css" type="text/css"/>
        <link rel="stylesheet" type="text/css" href="${base}/resources/CSS/button.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
	    <body style="background-color: whitesmoke">
	      <center>
	            <input type="hidden" name="emailId" value="${email}">
	        <center> <i class="glyphicon glyphicon-thumbs-up" style="font-size:50px;color:#207720;padding: 30px 20px;"></i> </center>   
	        <h2>${message}</h2>
	        <br/>
	        <h2><font color="blue">${email}</font></h2>
	        <center> <a href="${base}/homepageuser.htm?emailId=${email}" class="btn btn-info" role="button">Return to home page</a></center>
	      </center>
	    </body>

</html>

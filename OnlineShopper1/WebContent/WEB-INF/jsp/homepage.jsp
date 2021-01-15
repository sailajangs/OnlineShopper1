<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
        <c:set var="base" value="${pageContext.request.contextPath}"/>
        <script  type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.2.min.js">
        </script>
        <link rel="stylesheet" href="${base}/resources/CSS/homepage1.css" type="text/css"/>
        <title>Shopper's Central Home</title>

</head>
<body style="background-color:white;margin:0px;padding:0px;border:0px">
       <header>
         <div class="div_logo">
	        <h2 class="logo">Shopper's Central</h2>
	        </div>
	        <br/>
	        <jsp:include page="menu.jsp"></jsp:include>
      </header>
 
        <div class="main">
         <div class="innerdiv">
        <h3 align="left"><font color="black">Electronics</font> </h3><hr/>

       
        <table border="0" width="300">
            <tr>
                <td colspan="3"> <h4>SmartPhones</h4></td>
            </tr>
            <tr>
                <td colspan="3" width="200"> <img src="${base}/resources/images/Electronics/iPhoneXs Max.jpg" width="180"  height="160"/> </td>
            </tr>
            <tr> 
            <td colspan="3" width="200" align="left"><h4>The New Apple iPhone Xs Max (Black)</h4> <br/></td>
            </tr>
            <tr> 
            <td colspan="3" width="200" align="left"><a href="${base}/searchController.htm?type=Electronics&emailId=null">Show more...</a>
            <br/></td>
            </tr>
        </table></div>
         <div class="innerdiv">
        <h3><font color="black">All Clothing</font> </h3><hr/>
       
        <table border="0" width="300">
            <tr>
                <td colspan="3"> <h4>Women's trends!</h4></td>
            </tr>
            <tr>
                <td colspan="3" width="200"> <img src="${base}/resources/images/Clothing/top3.jpg" width="180"  height="160"/> </td>
             </tr>
             
                <tr>
                   <td colspan="3" width=200 align="left"><h4>Women's sweater jackets</h4><br/></td>
                </tr>
             <tr> 
            <td colspan="3" width="200" align="left"><a href="${base}/searchController.htm?type=Clothing&emailId=null">Show more...</a>
            <br/></td>
            </tr>
        </table>
        </div>
        
        <div class="innerdiv">
                 <h3><font color="black">Books</font></h3><hr/>
               
        <table border="0" width="300">
            <tr>
                <td colspan="3"> <h4>Modern Database Management</h4></td>
            </tr>
            <tr>
                <td colspan="3" width="200"> <img src="${base}/resources/images/Books/dbms.jpg" width="180"  height="160"/> </td>
            </tr>
             <tr>
                 <td colspan="3" width="200" align="left"><h4>Modern Database Management</h4><br/></td>
             </tr>
            <tr> 
            <td colspan="3" width="200" align="left"><a href="${base}/searchController.htm?type=Books&emailId=null">Show more...</a>
            <br/></td>
            </tr>
        </table>
        </div >
        </div>
           </body>
</html>
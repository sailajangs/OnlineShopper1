<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-
transitional.dtd"> <html xmlns="http://www.w3.org/1999/xhtml" > 

    <head>
        <c:set var="base" value="${pageContext.request.contextPath}"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		 <meta name="viewport" content="width=device-width, initial-scale=1">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
         <link rel="stylesheet" href="${base}/resources/CSS/homepage1.css" type="text/css"/>
        <title>User Login Page</title>
            </head>
    <body style="background-color: whitesmoke" class="text-center">
        <br/>
                        <form action="homepageuser.htm" method="post" modelAttribute="loginForm" class="form-signin">
                        <div class="div_logo">
                            <a href='homepage.htm'><h2 class="logo">Shopper's Central</h2></a>
  						   <table cellpadding="10" align="center">
							   <tr>
									<td><h1 class="h3 mb-3 font-weight-normal" align="center">LOGIN HERE</h1><br></td>
							   </tr>

                                <tr>
                                    <td><label class="sr-only">Email address</label>
                                    <input type="text" name="emailId" class="form-control" placeholder="Email address" required autofocus/></td>
                                    <td class="invalid"><div id="u-emailid"></div></td>
                                </tr>
                                <tr>
                                    <td><label class="sr-only">Password</label>
                                     <input type="password" name="password" class="form-control" placeholder="Password" required autofocus/></td>
                                    <td class="invalid"><div id="u-password"></div></td>
                                </tr>
                                <tr>
                                    <td style="padding-top:25px;"><button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button></td>
									<td></td>
                                </tr>
								<tr>
								    <td style="padding-top:5px;" align="center"><a href="Registration.htm">New User?</a></td>
                                    <td></td>
								</tr>
                            </table>
                        </form>
        <center>
            <p style="color:red;"> <strong> ${message}</strong></p>
        </center>

    </body>
</html>
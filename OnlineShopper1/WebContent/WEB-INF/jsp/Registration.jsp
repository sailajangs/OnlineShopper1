<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-
transitional.dtd"> <html xmlns="http://www.w3.org/1999/xhtml" >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
         <c:set var="base" value="${pageContext.request.contextPath}"/>
         <link rel="stylesheet" href="${base}/resources/CSS/homepage1.css" type="text/css"/>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"/>
                <script type="text/javascript">
            function validateForm()
            {

                 var x=document.forms["regForm"]["emailId"].value;
                var atpos=x.indexOf("@");
                var dotpos=x.lastIndexOf(".");

                if(document.forms["regForm"]["userName"].value=="")
                    {
                    document.getElementById("u-name").innerHTML="User Name must be filled out ";
                    return false;
                    }
                      else if(document.forms["regForm"]["userName"].value.length<=4)
                    {
                         document.getElementById("u-name").innerHTML="username must be of atleast of 5 character";

                         return false;
                    }
                  

                    else if(document.forms["regForm"]["emailId"].value=="")
                    {
                         document.getElementById("u-name").innerHTML="";
                         document.getElementById("u-id").innerHTML="Email id must be filled out";
                         return false;
                    }
                    else if(document.forms["regForm"]["emailId"].length<=4)
                        {
                            document.getElementById("u-name").innerHTML="";
                          document.getElementById("u-id").innerHTML="Email id must be greater then 4 characters";
                          return false;
                        }

                   
                else if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
                {
                    document.getElementById("u-name").innerHTML="";
                    document.getElementById("u-id").innerHTML="Email Id is not valid(Ex:abc@xyz.com)";
                    return false;
                }
                    else if(document.forms["regForm"]["password"].value=="")
                         {
                             document.getElementById("u-name").innerHTML="";
                              document.getElementById("u-id").innerHTML="";
                             document.getElementById("u-password").innerHTML="Password must be filled out";
                             return false;

                         }


                         else if(document.forms["regForm"]["confpassword"].value=="")
                         {
                             document.getElementById("u-password").innerHTML="";
                             document.getElementById("u-cpassword").innerHTML=" Confirm Password must be filled out";
                             return false;

                         }

                        else if(document.forms["regForm"]["password"].value!=document.forms["regForm"]["confpassword"].value)
                             {
                                   document.getElementById("u-password").innerHTML="";
                                     document.getElementById("u-cpassword").innerHTML="Confirm Password should match with Password entered above";
                                     return false;
                             }


else
    {

        return true;
    }

  }

                  

        </script>

       
    </head>
    <body style="background-color: whitesmoke" >
                                   
           <div class="container" align="center">          
	           <form action="registrationController.htm" method="post" modelAttribute="regForm" onsubmit="return validateForm()">
	                    <div class="div_logo">
				         <a href='homepage.htm'><h2 class="logo">Shopper's Central</h2></a> 
				        </div>
	            <fieldset style="width:250px;">
	              <legend style="padding-top:20px">REGISTRATION PAGE </legend>
	                <div class="form-group">
	                   <label for="Name">Name *</label>
	                   <input type="text" name="userName" class="form-control" maxlength="20" size="30"/>
	                    <div id="u-name"></div>
	                    
	                    <label for="email">Email Id *</label>
	                    <input type="text" name="emailId" class="form-control" maxlength="20" size="30"/>
	                    <div id="u-id"></div>
	
	
	                    <label for="password">Password</label>
	                     <input type="password" name="password" class="form-control"size="30" maxlength="15"/>
	                    <div id="u-password"></div>
	
	                     <label for="confpassword">Confirm Password</label>
	                     <input type="password" name="confpassword" class="form-control" size="30" maxlength="15"/>
	                     <div id="u-confpassword"></div>
	                      
	                     <div style="padding-top:25px;"><input type="submit" value="Create An Account" class="btn btn-default" id="sbutton"/></div>
	                   </div>
	               </fieldset>
	            </form>
	     <center>
            <p style="color:red;"> <strong> ${message}</strong></p>
        </center>
          </div>

   </body>
</html>

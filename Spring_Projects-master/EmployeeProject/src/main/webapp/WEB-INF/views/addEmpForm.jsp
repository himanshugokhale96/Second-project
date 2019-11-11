<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function val()
	{
		var exp=document.getElementById("exp").value;
		var age=document.getElementById("age").value;
		if(isNaN(exp))
			{
				document.getElementById("demo").innerHTML="Enter a Valid Number";
			}
		else
			document.getElementById("demo").innerHTML="";
		if(isNaN(age))
		{
			document.getElementById("demo2").innerHTML="Enter a Valid Number";
		}
	else
		document.getElementById("demo2").innerHTML="";
	}
function val1()
{
	var exp=document.getElementById("em").value;
	var contain = exp.indexOf('@');
	var k = exp.length;
	var c = new RegExp("[.]com$");
	
if( contain<1 || !c.test(exp) )
{
	
	document.getElementById("demo1").innerHTML="Enter a Valid Email id";
}
else
	document.getElementById("demo1").innerHTML="";
}
	
function validateForm()
{
	var age= document.getElementById("age").value;
	var experience = document.getElementById("exp").value;
	var email = document.getElementById("em").value;
	var phno = document.getElementById("ph").value;
	
	if((email=="") && (phno==0))
	{
	alert(" Email id/mobile number alteast one is mandatory");
	return false;
	}
	
}
</script>
<style>
.red {
color:red;
}
</style>
</head>
<body>

<h3>FILL IN THE FORM</h3>

  
        <h1>Add New Employee</h1>  
       <form:form name ="empForm" method="post"  action="addEmpForm" onsubmit = "return validateForm()">    
  
        <table >    
         <tr>    
          <td>Name : </td>   
          <td><form:input path="name"/></td>  
         </tr>    
         <tr>    
          <td>Experience :</td>    
          <td><form:input id="exp" onkeyup="val()" path="experience" /></td>  
          <td>
          <span id="demo" class="red"></span>
          </td>
         </tr>   
         <tr>    
          <td>Age :</td>    
          <td><form:input path="age" id = "age" onkeyup="val()"/></td>
          <td><span id = "demo2" class="red"></span> </td>
         </tr>
         <tr>
         <td>Address :</td>
         <td><form:input path = "address" />
         </td>   
         <tr>    
          <tr>
          <td>
          Mobile Number:
          </td>
          <td><form:input path = "phno" id = "ph" />
          </td>
          </tr>
          <tr>
          <td>
          Email Id:
          </td>
          <td>
          <form:input path = "email" id="em" onkeyup="val1()"/>
          </td>
          <td><span id = demo1 class ="red"></span>
          </tr>
          <td><input type="submit" value="Next" /></td>    
         </tr>    
        </table>    
       </form:form>    

</body>
</html>
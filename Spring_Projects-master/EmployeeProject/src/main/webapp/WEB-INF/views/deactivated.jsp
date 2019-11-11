<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Deactivated Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Name</th><th>Age</th><th>Experience</th><th>Address</th><th>CreatedTime</th><th>ModifiedTime</th></tr>
   <c:forEach var="empl" items="${dlist}">   
   <tr>  
   <td>${empl.name}</td>  
   <td>${empl.age}</td>  
   <td>${empl.experience}</td>  
   <td>${empl.address}</td> 
   <td>${empl.createdTime}</td>
   <td>${empl.modifiedTime}</td>
   <td>
   <form action = "activate/${empl.name}">
   <input type = "submit" value= "ACTIVATE">
   </form>
   </td>
      </tr>  
   </c:forEach>  
   </table>
   
   <br><table cellpadding="3">
   <tr>
   <td>
   <form action = "allEmp">
<input type = "submit" value = "VIEW ALL EMPLOYEES">
</form>
</td>
<td>
   <form action = "home">
   <input type = "submit" value="HOME">
   </form>
   </td>
   </tr>
   </table>
</body>
</html>
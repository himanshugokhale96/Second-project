<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Active Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Name</th><th>Age</th><th>Experience</th><th>Address</th><th>CreatedTime</th><th>ModifiedTime</th><th>Edit</th><th>Delete</th></tr>
   <c:forEach var="emp" items="${list}">   
   <tr>  
   <td>${emp.name}</td>  
   <td>${emp.age}</td>  
   <td>${emp.experience}</td>  
   <td>${emp.address}</td> 
   <td>${emp.createdTime}</td>
   <td>${emp.modifiedTime}</td>
   <td><form action = "editemp/${emp.name}">
   <input type = "submit" value="EDIT">
   </form>
   </td> 
  
  
   <td>
   <form action = "deleteemp/${emp.name}">
   <input type = "submit" value = "DELETE">
   </form>
   </td>
   </tr>  
   </c:forEach>  
   </table>  
   <br/>  
   <br>
   <table cellpadding="3">
   <tr>
   <td>
   <form action = "allEmp">
<input type = "submit" value = "VIEW ALL EMPLOYEES">
</form>
</td>
<td>
   <form action = "addEmp">
   <input type = "submit" value = "Add New Employee">
   </form>
   </td>
   <td>
   <form action = "home">
   <input type = "submit" value="HOME">
   </form>
   </td>
   </tr>
   </table>
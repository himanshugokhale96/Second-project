<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Imported Employees</h2>
<table border="2" data-width="70%" cellpadding="4" id = "datatable"> 
<tr><th>Name</th><th>Mobile No</th><th>Email</th><th>Age</th><th>Address</th></tr>
<c:forEach var="empl" items="${list}"> 

<tr>
<td>${empl.name}</td>
<td>${empl.phno}</td>
<td>${empl.email}</td>
<td>${empl.age}</td>
<td>${empl.address}</td>
</tr>
</c:forEach>
</table>
<br>
<a href = "allEmp"><button>View all Emp</button></a>
</body>
</html>
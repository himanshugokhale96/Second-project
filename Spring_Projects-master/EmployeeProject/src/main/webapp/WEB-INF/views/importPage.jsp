<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Import Employees</title>
<style>
.div{
color:#32CD32;
}
.red{
color:#FF0000;
}
</style>
</head>
<body>
<br>


<h2>Importing Employees</h2>
<table> 
<tr><td>
<form action ="downloadTemp">
<input type = "submit" value="Download Template">
</form>
</td>
</tr>
<tr>
<td>
<form action="import">
<input type=file name=file >
</td>

<td>
<input type = "submit" value="IMPORT">
</td>
</form>
</tr>
</table>
<c:if test="${success==1}">
<div class="div">import successfull</div>
<br>
<h2> Imported Employees</h2>
<table border="2" data-width="70%" cellpadding="4" id = "datatable"> 
<tr><th>Name</th><th>Mobile No</th></tr>
<c:forEach var="empl" items="${list}">

<tr>
<td>${empl.name}</td>
<td>${empl.phno}</td>
</tr>
</c:forEach>
</table>
<br>
<a href = "allEmp"><button>View all Emp</button></a>
</c:if>
<c:if test="${at==5}">
<div class = "red">incorrect Employee name</div>
</c:if>
<c:if test="${at==0}">
<div class = "red">incorrect Mobile Number</div>
</c:if>
<c:if test="${at==1}">
<div class = "red">incorrect Email id</div>
</c:if>
<c:if test="${at==2}">
<div class = "red">incorrect Employee Age</div>
</c:if>
<c:if test="${at==3}">
<div class = "red">Experience invalid</div>
</c:if>
<c:if test="${at==4}">
<div class = "red">invalid Address</div>
</c:if>
<c:if test="${null==0}">
<div class = "red">name can not be Empty</div>
</c:if>
</body>
</html>
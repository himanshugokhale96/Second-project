<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>

<c:if test="${error==0}">
<h3>
Educational Details
</h3>

<table>
<tr>
<td><b>Name:</b></td>
<td>${edu.name}</td>
</tr>
<tr>
<td><b>Tenth Percentage:</b></td>
<td>${edu.tenth}</td>
</tr>
<tr>
<td><b>Inter Percentage:</b></td>
<td>${edu.inter}</td>
</tr>
<tr>
<td><b>B.tech Percentage:</b></td>
<td>${edu.btech}</td>
</tr>
</table>
</c:if>
<c:if test="${error==1}">
<b>Sorry! &nbsp;&nbsp;&nbsp;Educational Details of this Employee are not Found</b></c:if>
</body>
</html>
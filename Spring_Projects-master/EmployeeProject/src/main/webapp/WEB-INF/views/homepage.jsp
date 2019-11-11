<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.ac:hover{
background-color:black;
color:white;
}
</style>
</head>
<body background = "http://www.webdesigndev.com/wp-content/uploads/2012/05/003048-The-Yacht-Company-_-Yacht-Charter-Yacht-Sales-_-Y.CO_.jpg">
<br>
<br>
<table cellpadding="3">
<tr><td>
<form action = "addEmp">
<input class="ac" type ="submit" value = "ADD EMP">
</form>
</td>
<td>
<form action = "viewEmp">
<input class="ac" type = "submit" value = "VIEW EMP">
</form>
</td>
<td>
<form action = "allEmp">
<input class="ac" type = "submit" value = "VIEW ALL EMPLOYEES">
</form>
</td>
<td>
<form action = "viewAll">
<input class="ac" type = "submit" value = "VIEW ACTIVE EMPLOYEES">
</form>
</td>
<td>
<form action = "viewDeactivated">
<input class="ac" type = "submit" value = "VIEW DEACTIVATED EMP">
</form>
<td>
<a href="delete"><button class="ac">DROP EMP</button></a>
</form>
</td>
<td>
<a href="importPage"><button>IMPORT EMPLOYEES</button></a></td>

</tr>
</table>
</body>
</html>
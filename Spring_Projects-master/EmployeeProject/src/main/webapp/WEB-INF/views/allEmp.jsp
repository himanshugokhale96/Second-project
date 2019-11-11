<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
/* Popup container - can be anything you want */
.popup {
  position: relative;
  display: inline-block;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* The actual popup */
.popup .popuptext {
  visibility: hidden;
  width: 160px;
  background-color: #555;
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 8px 0;
  position: absolute;
  z-index: 1;
  bottom: 125%;
  left: 50%;
  margin-left: -80px;
}

/* Popup arrow */
.popup .popuptext::after {
  content: "";
  position: absolute;
  top: 100%;
  left: 50%;
  margin-left: -5px;
  border-width: 5px;
  border-style: solid;
  border-color: #555 transparent transparent transparent;
}

/* Toggle this class - hide and show the popup */
.popup .show {
  visibility: visible;
  -webkit-animation: fadeIn 1s;
  animation: fadeIn 1s;
}

/* Add animation (fade in the popup) */
@-webkit-keyframes fadeIn {
  from {opacity: 0;} 
  to {opacity: 1;}
}

@keyframes fadeIn {
  from {opacity: 0;}
  to {opacity:1 ;}
}
#myDIV {
  width: 100%;
  padding: 50px 0;
  text-align: center;
  background-color: lightblue;
  margin-top: 20px;
}
</style>
<script>
function popup()
{
	
	var pop = document.getElementById("myPopup");
	  pop.classList.toggle("show");

}
 /*function myFunction() {
	  var x = document.getElementById("myDIV");
	  if (x.style.display === "none") {
	    x.style.display = "block";
	  } else {
	    x.style.display = "none";
	  }
	}*/
</script>
<style>

.s{
background-color:#FF0000;
}
.s:hover{
opacity:0.7;
}
.blue{
background-color:#000080;
  color: white;
}
.ac {
  background-color: #3CBC8D;
  color: white;
}
.ac:hover{
color:black;
}
</style>
<script scr="jquery-1.11.2.js"></script>
<link rel = "sytlesheet" type = "text/css" href = "//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<script type = "text/javascript" src="//cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<script type = "text/javascript">
$(document).ready(function () { 
	$('#datatable').dataTable();
});
</script>
</head>
<body>
<h1>All Employees List</h1>  
<table border="2" data-width="70%" cellpadding="4" id = "datatable">  
<tr><th>Name</th><th>Age</th><th>Experience</th><th>Address</th><th>Contact Info</th><th>CreatedTime</th><th>ModifiedTime</th><th>EDIT</th></tr>
   <c:forEach var="empl" items="${list}">  
    
   <tr>  
   <td>
   <input type = "button" value = "${empl.name}" onclick = "window.open('edu/${empl.name}','mywindow','height = 200,width =250')" />
    
   </td>  
   <td>${empl.age}</td>  
   <td>${empl.experience}</td>  
   <td>${empl.address}</td> 
   <td>
   <c:if test="${empl.email != null}"> ${empl.email} </c:if>
   <c:if test="${empl.email == null}"> ${empl.phno} </c:if>
   </td>
   <td>${empl.createdTime}</td>
   <td>${empl.modifiedTime}</td>
   <td><form action = "editemp/${empl.name}">
   <input type = "submit" value="EDIT">
   </form>
   </td> 
    <td>
    <c:if test="${empl.active==1}">
    <form action = "deleteemp/${empl.name}">
    <input class = "s" type = "submit" value = "DELETE">
    </form>
    </c:if>
  <c:if test="${empl.active==0}">
    <form action = "activate/${empl.name}">
   <input class="ac" type = "submit" value= "ACTIVATE">
   </form>
   </c:if>
</td>   
  </tr>  
   </c:forEach>  
   </table>
   <br>
   <table>
   <tr>
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
   <td><form action = "export">
   <input type = "submit" value = "EXPORT">
   </form>
   </td>
   </tr>
   </table>
</body>
</html>
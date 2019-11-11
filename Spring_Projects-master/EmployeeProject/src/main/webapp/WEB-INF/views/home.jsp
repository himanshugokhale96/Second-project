<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Spoors</title>
	<style>
	img.bg {
    min-height: 100%;
    min-width: 1024px;
    width: 100%;
    height: auto;
    position: fixed;
    top: 0;
    left: 0;
}

@media screen and (max-width: 1024px){
    img.bg {
    left: 50%;
    margin-left: -512px; }
}

</style>
</head>
<body background ="C:\Users\welcome\Desktop\spo.png">
<!--  <img src="C:\Users\welcome\Desktop\spo.png" alt="bckgound" class="bg" /> -->
<center>
<br>

&nbsp;&nbsp;&nbsp;&nbsp;<b><h1 style="color:white;">WELCOME TO SPOORS!</h1></b>
<form action = "sign">
<input type = "submit" value = "sign-in">
</form>
</center>
</body>
</html>

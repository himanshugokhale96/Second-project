<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Edit Employee</h1>  
       <form:form method="POST" action="/suma/save">    
        <table>    
        <tr>  
         <td><form:hidden  path="name" /></td>  
         </tr>   
         <tr>    
          <td>Age : </td>   
          <td><form:input path="age"  /></td>  
         </tr>    
         <tr>    
          <td>Experience :</td>    
          <td><form:input path="experience" /></td>  
         </tr>   
         <tr>    
          <td>Address :</td>    
          <td><form:input path="address" /></td>  
         </tr>   
          <tr>
          <td>Mobile number :</td>
          <td><form:input path = "phno" /></td>
          </tr>
          <tr>
          <td>Email Id :</td>
          <td> <form:input path = "email" /></td>
          </tr> 
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
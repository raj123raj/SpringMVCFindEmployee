<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Search Employees</title>
        </head>
        <body>
		<h1>Search Employees</h1>
       <form:form  method="post" action="/SpringMVCFindEmployee/searchEmployee"  >  
      	<table >  
         <tr>  
          <td>Employee Name : </td>
          <td><form:input path="name"/></td>
         </tr>  
         <tr>
         <td>Choose a Location : </td>
          <td><form:select path="location">  
        <form:option value="Location1" label="Location1"/>  
        <form:option value="Location2" label="Location2"/>  
        </form:select> 
         </td>
         </tr>
         <tr>
          <td> </td>  
          <td><input type="submit" value="Search" /></td>  
         </tr>  
        </table>  
        

       </form:form>  
       </body>
       </html>

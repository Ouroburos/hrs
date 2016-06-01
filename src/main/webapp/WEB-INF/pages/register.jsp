<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
<link rel="stylesheet" href="resources/booking.css" > 
<%@include  file="navbar.jsp" %>	
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Register</title>
	</head>
	<body>
	
			 <c:if test="${errorMessage != null}">
   				<div class="alert alert-danger">${errorMessage}</div>
 			 </c:if>
			
		<c:if test="${newCustomerCreated}">
			<div class="container">
			  <div class="alert alert-success fade in">
			    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			    <strong>Success!</strong> User created successfully!
			</div>		
		</c:if>
		
		<div class="container col-sm-4 col-sm-offset-4">
  			<div>
			<h1 id="vcenter">Register</h1>			
				<form:form action="register" method="POST" commandName="customer">
				 	
				    First name:   
				    <form:input path="firstname" class="form-control"/>  <form:errors path="firstname" cssClass="alert alert-danger" element="div"/><br/>
					Last name:    
					<form:input path="lastname" class="form-control"/>   <form:errors path="lastname" cssClass="alert alert-danger" element="div"/><br/>
			  	    Username:     
			  	    <form:input path="username" class="form-control"/>   <form:errors path="username" cssClass="alert alert-danger" element="div"/><br/>
				    Password:     
				    <form:password path="password" class="form-control"/> <form:errors path="password" cssClass="alert alert-danger" element="div"/> <br/>
				    Phone number: 
				    <form:input path="phone" class="form-control"/>      <form:errors path="phone" cssClass="alert alert-danger" element="div"/><br/>
				    Email:        
				    <form:input path="email" class="form-control"/>      <form:errors path="email" cssClass="alert alert-danger" element="div"/><br/>		 
				    		  <input type="submit" value="register" class="btn btn-primary"/>
				</form:form>
			</div>
		</div>	
	
	</body>
</html>
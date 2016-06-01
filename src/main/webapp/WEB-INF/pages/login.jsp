<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HRS Login</title>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
	<link href="<c:url value="resources/mycss.css" />" rel="stylesheet"> 
</head>
<body style="background-image: url('resources/lobby.jpg'); background-repeat: no-repeat; background-size: cover;">

	<c:if test="${errorMessage != null}">
		<div class="alert alert-danger">${errorMessage}</div>
	</c:if>
  	
  	<div class="container col-sm-4 col-sm-offset-4">
  		<div>
			<h1 id="vcenter">Login</h1>
			<form:form action="login" method="POST" commandName="customer">
			   	Username: 
			   	<form:input path="username" class="form-control" style="width:300px;"/>    <form:errors path="username" cssClass="alert alert-danger" element="div"/><br/>
			   	Password: 
			   	<form:password path="password" class="form-control" style="width:300px;"/>  <form:errors path="password" cssClass="alert alert-danger" element="div"/><br/>
			   		  <input type="submit" value="Login" class="btn btn-primary" />
		 	</form:form>
	 	</div>
	</div>
</body>
</html>
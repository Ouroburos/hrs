<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/mycss.css" >
<title>Ratings</title>

</head>
	<body>
		<%@include file="navbar.jsp" %>
<!-- <jsp:include page="navbar.html"/>  -->
	

		<c:if test="${errorMessage != null}">
			<div class="alert alert-danger">${errorMessage}</div>
		</c:if>
		
		<c:if test="${newRatingCreated}">
			<div class="container">
			  <div class="alert alert-success fade in">
			    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
			    <strong>Success!</strong> Rating submitted successfully!
			</div>		
		</c:if>
	  	
	  	<div class="container col-sm-4 col-sm-offset-4 center">
	  		<div>
				<h1 id="vcenter">Rate your stay</h1>
				
				<form action="rating" method="POST" class="">
				   <div class="stars">
				   
					    <input class="star star-5" id="star-5" type="radio" name="star" value="5"/>
					    <label class="star star-5" for="star-5"></label>
					    <input class="star star-4" id="star-4" type="radio" name="star" value="4"/>
					    <label class="star star-4" for="star-4"></label>
					    <input class="star star-3" id="star-3" type="radio" name="star" value="3"/>
					    <label class="star star-3" for="star-3"></label>
					    <input class="star star-2" id="star-2" type="radio" name="star" value="2"/>
					    <label class="star star-2" for="star-2"></label>
					    <input class="star star-1" id="star-1" type="radio" name="star" value="1"/>
					    <label class="star star-1" for="star-1"></label>
					</div>
				   
				  	<div class="form-group">
					  <label for="comment">Comment:</label>
					  <textarea class="form-control" rows="5" id="comment" name="comment"></textarea>
					</div>
					
					
					<button type="rating" value="Submit" class="btn btn-primary">
					Submit
					</button>
					
					
				</form>
				
		 	</div>
		</div>


	</body>
</html>
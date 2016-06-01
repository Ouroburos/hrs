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
<title>Rooms</title>
</head>
<body>

<%@include  file="navbar.jsp" %>
<!-- <jsp:include page="navbar.html"/>  -->


<%-- 
	<c:forEach var="room" items="${Rooms}">
		<div class="rooms-list"><h4>${room.type.name}</h4>
			<p>${room.type.description}</p>
			<ul>
				<c:forEach var="a" items="${room.type.amenities}">
					<li>${a}</li><br/>
				</c:forEach>
			</ul> 
		</div>
	</c:forEach> --%>

<!--  DIVIDER  -->
	
	<div class="">
		<h3 class="text-center">Indulge in the</h3>
		<h1 class="text-center">Amenities</h1>
	</div>
	
	<hr>
	<!-- Single -->
	<div class="row">
		<div class="col-lg-8">
			<img src="resources/bednpillows.jpg" alt="" style="width:850px;height:500px;">
			
		</div>
		<div class="col-lg-4 room-margin">
			<div class="rooms-list"><h4>${Rooms.get(0).type.name}</h4>
			<hr>
				<p>${Rooms.get(0).type.description}</p>
				<ul>
					<c:forEach var="a" items="${Rooms.get(0).type.amenities}">
						<li>${a}</li><br/>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	
	<!-- Double -->
	<div class="row">
		<div class="col-lg-4 room-margin">
 			<div class="rooms-list"><h4>${Rooms.get(3).type.name}</h4>
 			<hr>
				<p>${Rooms.get(3).type.description}</p>
				<ul>
					<c:forEach var="a" items="${Rooms.get(3).type.amenities}">
						<li>${a}</li><br/>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="col-lg-8">
			<img src="resources/regdouble.jpg" alt="" style="width:850px;height:500px;">
		</div>
	</div>
	
	<!-- Single Deluxe -->
	<div class="row">
		<div class="col-lg-8">
			<img src="resources/verynicesingle.jpg" alt="" style="width:850px;height:500px;">
	</div>
		<div class="col-lg-4">
			<div class="rooms-list room-margin"><h4>${Rooms.get(5).type.name}</h4>
			<hr>
				<p>${Rooms.get(5).type.description}</p>
				<ul>
					<c:forEach var="a" items="${Rooms.get(5).type.amenities}">
						<li>${a}</li><br/>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	
	<!-- Double Deluxe -->
	<div class="row">
		<div class="col-lg-4">
 			<div class="rooms-list room-margin"><h4>${Rooms.get(7).type.name}</h4>
 			<hr>
				<p>${Rooms.get(7).type.description}</p>
				<ul>
					<c:forEach var="a" items="${Rooms.get(7).type.amenities}">
						<li>${a}</li><br/>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="col-lg-8">
			<img src="resources/verynicedouble.jpg" alt="" style="width:850px;height:600px;">
		</div>
	</div>

	<!-- Executive Suite -->
	<div class="row">
		<div class="col-lg-8">
			<img src="resources/executivesuite.jpg" alt="" style="width:850px;height:600px;">
	</div>
		<div class="col-lg-4">
			<div class="rooms-list room-margin"><h4>${Rooms.get(8).type.name}</h4>
			<hr>
				<p>${Rooms.get(8).type.description}</p>
				<ul>
					<c:forEach var="a" items="${Rooms.get(8).type.amenities}">
						<li>${a}</li><br/>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	
	<!--  Luxury Suite  -->
	<div class="row">
		<div class="col-lg-4">
 			<div class="rooms-list room-margin"><h4>${Rooms.get(9).type.name}</h4>
 			<hr>
				<p>${Rooms.get(9).type.description}</p>
				<ul>
					<c:forEach var="a" items="${Rooms.get(9).type.amenities}">
						<li>${a}</li><br/>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="col-lg-8">
			<img src="resources/luxurysuite.jpg" alt="" style="width:850px;height:500px;">
		</div>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<c:if test="${authenticated}">
      <label id="authenticated"></label>
</c:if> 



<!DOCTYPE html>
<html>

<%-- <jsp:include page="navbar.html"/> --%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" >
<link rel="stylesheet" href="resources/booking.css" > 

<title>Home</title>
</head>
<body>
<!-- <jsp:include page="navbar.html"/>  -->
<%@include  file="navbar.jsp" %>

<header class="item header margin-top-0 " id="header9">
        <h1><span id="restful">Restful</span> Stay Hotel</h1>
        <p>Rated <span id="rated">${ourRating}</span> by our guests</p>
</header>
    
<div id="messages"></div>
<div id="bookingMessage">
  <c:if test="${message != null}">
    <div class="alert alert-danger">${message}</div>
  </c:if>
</div>
<div id="main-div">
<!-- Booking Form  -->
<div id="contact-form" class="clearfix">

    <h2>Book A Hotel Room</h2>
 
    <form method="POST" action="/RestfulStayHotel/makeReservation">
    
          <label for="checkin">Check In: </label>
        <input type="date" id="checkin" name="checkin" min="" max="" required />
      
          <label for="nights">Nights: </label>
        <select id="nights" name="nights" required></select>
        
          <label for="cap">Capacity: </label>
        <!-- Append children here based on types of rooms available -->
        <select id="cap" name="cap" required></select> 
         
          <label for="room">Room: </label>
        <!-- Append children here based on types of rooms available -->
        <select id="roomtypes" name="roomtypes" required></select>

          <label for="price">Price: </label>
        <!-- Append children here based on types of rooms available -->
        <input type="range" id="price" name="price" min="" max=""  required/>
        
          <label for="amns">Amenities: </label>
        <div id="amns-div"></div>
        

        <input type="submit" value="Make Reservation" id="submit-button" />
    </form>
</div>
<div id="room-display">
</div>
</div>
<!-- Booking div -->
<c:if test="${authenticated}">
	<div id="contact-form" class="clearfix">
	   
		<div>
			<div><h3 class="text-center">Reservations</h1></div>
						
			<c:forEach items="${currentUser.getReservations()}" var="r">
				<ul class="list-group">
				<!-- 	<li class="list-group-item"></li> -->
					<li>Room type: ${r.room.type.name}</li>
					<li>Amenities: ${r.room.type.amenities}</li>
					<li>Check in: ${r.getFormattedCheckIn()}</li>
					<li>Check out: ${r.getCheckOut()}</li>
				</ul>
			</c:forEach>			
			
		</div>
	
	</div>
</c:if>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="resources/util.js"></script>
    <script src="resources/home.js"></script>
</body>
</html>
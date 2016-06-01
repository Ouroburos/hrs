<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<div class="wrapper ">
  <div class="container">

    <nav role="navigation" class="navbar plain margin-top-20">
            
      <div id="navbar-collapse-02" class="collapse navbar-collapse">
        <ul class="nav navbar-nav navbar-right">            
          <li class="propClone"><a href="home">Home</a></li>
          <li class="propClone"><a href="rooms">Rooms</a></li>
          <c:if test="${canRateHotel}">
			<li class="propClone"><a href="rating">Rate Your Stay</a></li>
		  </c:if>
		  <c:if test="${not authenticated}">
		    <li class="propClone"><a href="register">Create Account</a></li>
			<li class="propClone"><a href="login">Login</a></li>
		  </c:if>
		  <c:if test="${authenticated}">
			<li class="propClone"><a href="logout">Logout</a></li>
		  </c:if>
        </ul>           
      </div>            
    </nav>
  </div>
</div>

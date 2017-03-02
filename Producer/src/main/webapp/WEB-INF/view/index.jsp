<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
	<head>
		<meta charset="utf-8">
		<title>Vendor Entry</title>
		<link rel="stylesheet" href="<c:url value='css/style.css'></c:url>"/>
	</head> 
	<body>
		<div><h2>Vendor Entry</h2></div>
		
		<div id="form">
		<form:form modelAttribute="vendor" action="vendor">
		
		<fieldset>
		<legend>Vendor Information</legend>
		<div>
		<label for="vendorname">Vendor Name</label>
		<form:input path="vendorname"/>
		</div>
		
		<div>
		<label for="firstName">First Name</label>
		<form:input path="firstName"/>
		</div>
		
		<div>
		<label for="lastName">Last Name</label>
		<form:input path="lastName"/>
		</div>
		
		<div>
		<label for="city">City</label>
		<form:input path="city"/>
		</div>
		
		<div>
		<label for="zipcode">Zip Code</label>
		<form:input path="zipcode"/>
		</div>
		
		<div>
		<label for="phonenumber">Phone Number</label>
		<form:input path="phonenumber"/>
		</div>
		
		<div>
		<input type="submit"/>
		</div>
		
		</fieldset>
		
		</form:form>
		</div>
	</body>
</html>
